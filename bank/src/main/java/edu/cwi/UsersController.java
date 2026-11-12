package edu.cwi;

import edu.cwi.data.User;
import edu.cwi.data.Account;
import edu.cwi.data.Transaction;

import edu.cwi.data.UserMapper;
import edu.cwi.data.AccountMapper;
import edu.cwi.data.TransactionMapper;
import edu.cwi.data.MyBatisConfig;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;

import org.apache.ibatis.session.SqlSession;
import org.mindrot.jbcrypt.BCrypt;

import java.math.BigDecimal;
import java.util.Map;

public class UsersController implements CrudHandler {


    @Override
    public void getAll(Context ctx) {

        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {

            UserMapper mapper = session.getMapper(UserMapper.class);

            ctx.json(mapper.getAllUsers());
        }
    }


    @Override
    public void getOne(Context ctx, String resourceId) {

        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {

            UserMapper mapper = session.getMapper(UserMapper.class);

            ctx.json(mapper.getById(Integer.parseInt(resourceId)));
        }
    }


    @Override
    public void create(Context ctx) {

        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {

            // Get the three mappers
            UserMapper userMapper = session.getMapper(UserMapper.class);
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            TransactionMapper transactionMapper = session.getMapper(TransactionMapper.class);

            // Deserialize the JSON request
            User user = ctx.bodyAsClass(User.class);

            // Set the opening deposit
            BigDecimal deposit = BigDecimal.valueOf(5.00);

            // Hash the user's password
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(hashedPassword);

            // Insert the user
            userMapper.insert(user);

            // Create an account for the new user
            Account account = new Account();

            account.setUserId(user.getId());
            account.setAccountType("CHECKING");
            account.setBalance(deposit);

            accountMapper.insert(account);

            // Create the opening deposit transaction
            Transaction transaction = new Transaction();

            transaction.setAccountId(account.getId());
            transaction.setTransactionType("DEPOSIT");
            transaction.setAmount(deposit);
            transaction.setDescription("Opening deposit.");

            transactionMapper.insert(transaction);

            // Commit all three inserts
            session.commit();

            // Return the new user as JSON
            user.setPassword("");
            ctx.json(user);
        }
    }


    @Override
    public void update(Context ctx, String resourceId) {

        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {

            User user = ctx.bodyAsClass(User.class);

            user.setId(Integer.parseInt(resourceId));

            UserMapper mapper = session.getMapper(UserMapper.class);

            // Hash the password if one was provided
            if (user.getPassword() != null && !user.getPassword().isBlank()) {
                String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
                user.setPassword(hashedPassword);
            }

            mapper.update(user);

            session.commit();

            user.setPassword("");
            ctx.json(user);
        }
    }


    @Override
    public void delete(Context ctx, String resourceId) {

        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {

            UserMapper mapper = session.getMapper(UserMapper.class);

            mapper.delete(Integer.parseInt(resourceId));

            session.commit();

            ctx.json(Map.of("id", resourceId, "deleted", true));
        }
    }


    public User authenticateUser(Context ctx, String username, String password) {

        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {

            UserMapper mapper = session.getMapper(UserMapper.class);

            User user = mapper.getByUsername(username);

            if (user != null) {

                if (BCrypt.checkpw(password, user.getPassword())) {
                    return user;
                }
            }

            return null;
        }
    }

}

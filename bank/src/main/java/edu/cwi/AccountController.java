package edu.cwi;

import io.javalin.http.Context;
import edu.cwi.data.User;
import edu.cwi.data.Account;
import edu.cwi.data.UserMapper;
import edu.cwi.data.AccountMapper;
import edu.cwi.data.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import java.util.List;
import java.util.Map;
import edu.cwi.data.Transaction;
import edu.cwi.data.TransactionMapper;

public class AccountController {

    public static void renderAccounts(Context ctx) {

        int id = ctx.cookieStore().get("user-id");

        try (SqlSession session =
                MyBatisConfig.getSqlSessionFactory().openSession()) {

            UserMapper userMapper =
                session.getMapper(UserMapper.class);

            AccountMapper accountMapper =
                session.getMapper(AccountMapper.class);

            // Retrieve the user
            User user = userMapper.getById(id);

            // Retrieve the user's accounts
            List<Account> accounts =
                accountMapper.getByUserId(id);

            // Display the accounts page
            ctx.render("jte/accountsPage.jte", Map.of(
                "title", "My Accounts",
                "user", user,
                "accounts", accounts
            ));
        }
    }

    public static void renderAccountDetail(Context ctx) {

        int id = ctx.cookieStore().get("user-id");

        // Get the account ID from the URL
        String accountId = ctx.pathParam("id");

        int accountNumber = Integer.parseInt(accountId);

        try (SqlSession session =
                MyBatisConfig.getSqlSessionFactory().openSession()) {

            UserMapper userMapper =
                session.getMapper(UserMapper.class);

            AccountMapper accountMapper =
                session.getMapper(AccountMapper.class);

            TransactionMapper transactionMapper =
                session.getMapper(TransactionMapper.class);

            // Retrieve the user
            User user = userMapper.getById(id);

            // Retrieve the selected account
            Account account = accountMapper.getById(accountNumber);

            // Verify account ownership
            if (account == null || account.getUserId() != id) {
                ctx.status(404).result("Account not found");
                return;
            }

            // Retrieve the account's transactions
            List<Transaction> transactions =
                transactionMapper.getByAccountId(accountNumber);

            // Display the account detail page
            ctx.render("jte/accountDetailPage.jte", Map.of(
                "title", "Account Details",
                "user", user,
                "account", account,
                "transactions", transactions
            ));
        }
    }
}

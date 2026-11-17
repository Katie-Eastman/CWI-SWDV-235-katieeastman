package edu.cwi;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import edu.cwi.data.Account;
import edu.cwi.data.AccountMapper;
import edu.cwi.data.Transaction;
import edu.cwi.data.TransactionMapper;
import edu.cwi.data.MyBatisConfig;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.session.SqlSession;


public class TransactionsController implements CrudHandler {

    @Override
    public void getAll(Context ctx) {

        // Return to the logged-in user's account
        ctx.redirect("/accounts");
    }

    @Override
    public void getOne(Context ctx, String resourceId) {

        try (SqlSession session =
                MyBatisConfig.getSqlSessionFactory().openSession()) {

            TransactionMapper mapper =
                session.getMapper(TransactionMapper.class);

            Transaction transaction =
                mapper.getById(Long.parseLong(resourceId));

            if (transaction != null) {
                ctx.json(transaction);
            } else {
                ctx.status(404).result("Transaction not found");
            }
        }
    }

    @Override
    public void create(Context ctx) {

        String userId = ctx.cookieStore().get("user-id");

        int id = Integer.parseInt(userId);

        String description = ctx.formParam("description");

        if (description != null && !description.isBlank()) {

            try (SqlSession session =
                    MyBatisConfig.getSqlSessionFactory().openSession()) {

                AccountMapper accountMapper =
                    session.getMapper(AccountMapper.class);

                TransactionMapper transactionMapper =
                    session.getMapper(TransactionMapper.class);

                List<Account> accounts =
                    accountMapper.getByUserId(id);

                if (!accounts.isEmpty()) {

                    Transaction transaction = new Transaction();

                    transaction.setAccountId(accounts.get(0).getId());
                    transaction.setTransactionType("DEPOSIT");
                    transaction.setAmount(new BigDecimal("1.00"));
                    transaction.setDescription(description);

                    transactionMapper.insert(transaction);

                    session.commit();
                }
            }
        }

        ctx.redirect("/accounts");
    }

    @Override
    public void update(Context ctx, String resourceId) {
        ctx.status(405).result("Updating transactions is not supported.");
    }

    @Override
    public void delete(Context ctx, String resourceId) {
        ctx.status(405).result("Deleting transactions is not supported.");
    }
}

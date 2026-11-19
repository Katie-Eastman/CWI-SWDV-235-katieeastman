package edu.cwi;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import edu.cwi.data.Account;
import edu.cwi.data.AccountMapper;
import edu.cwi.data.Transaction;
import edu.cwi.data.TransactionMapper;
import edu.cwi.data.MyBatisConfig;
import java.math.BigDecimal;
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

        // Get the logged-in user's ID
        int userId = ctx.cookieStore().get("user-id");

        // Get the account ID from the URL
        int accountId = Integer.parseInt(ctx.formParam("accountId"));

        // Get transaction information from the submitted form
        String transactionType = ctx.formParam("transactionType");
        String amount = ctx.formParam("amount");
        String description = ctx.formParam("description");

        // Validate the form information
        if (transactionType == null || transactionType.isBlank()
                || amount == null || amount.isBlank()
                || description == null || description.isBlank()) {

            ctx.status(400).result("Please complete all transaction fields.");
            return;
        }

        try (SqlSession session =
                MyBatisConfig.getSqlSessionFactory().openSession()) {

            AccountMapper accountMapper =
                session.getMapper(AccountMapper.class);

            TransactionMapper transactionMapper =
                session.getMapper(TransactionMapper.class);

            // Retrieve the selected account
            Account account = accountMapper.getById(accountId);

            // Verify account ownership
            if (account == null || account.getUserId() != userId) {
                ctx.status(404).result("Account not found");
                return;
            }

            // Create a new transaction
            Transaction transaction = new Transaction();

            transaction.setAccountId(accountId);
            transaction.setTransactionType(transactionType);
            transaction.setAmount(new BigDecimal(amount));
            transaction.setDescription(description);

            // Insert the transaction into the database
            transactionMapper.insert(transaction);

            // Save the database changes
            session.commit();
        }

        // Return to the account detail page
        ctx.redirect("/account/" + accountId);
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


package edu.cwi;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import io.javalin.http.UnauthorizedResponse;

public class TransactionsController implements CrudHandler {

    @Override
    public void getAll(Context ctx) {

        // Return to the logged-in user's account
        ctx.redirect("/account");
    }

    @Override
    public void getOne(Context ctx, String resourceId) {

        String userId = ctx.cookieStore().get("user-id");

        UserAccount account = AuthController.getUser(userId)
            .orElseThrow(UnauthorizedResponse::new);

        String transaction = account.transactions().get(resourceId);

        if (transaction != null) {
            ctx.result(transaction);
        } else {
            ctx.status(404).result("Transaction not found");
        }
    }

    @Override
    public void create(Context ctx) {

        // Find the currently logged-in user
        String userId = ctx.cookieStore().get("user-id");

        UserAccount account = AuthController.getUser(userId)
            .orElseThrow(UnauthorizedResponse::new);

        // Get the transaction description from the form
        String description = ctx.formParam("description");

        if (description != null && !description.isBlank()) {

            // Create a new transaction ID
            String id = String.valueOf(
                account.transactions().size() + 1
            );

            // Save the transaction to THIS user's account
            account.transactions().put(id, description);
        }

        // Return to the same user's account
        ctx.redirect("/account");
    }

    @Override
    public void update(Context ctx, String resourceId) {

        String userId = ctx.cookieStore().get("user-id");

        UserAccount account = AuthController.getUser(userId)
            .orElseThrow(UnauthorizedResponse::new);

        if (account.transactions().containsKey(resourceId)) {

            account.transactions().put(
                resourceId,
                ctx.body()
            );

            ctx.redirect("/account");

        } else {
            ctx.status(404).result("Transaction not found");
        }
    }

    @Override
    public void delete(Context ctx, String resourceId) {

        String userId = ctx.cookieStore().get("user-id");

        UserAccount account = AuthController.getUser(userId)
            .orElseThrow(UnauthorizedResponse::new);

        account.transactions().remove(resourceId);

        ctx.redirect("/account");
    }
}

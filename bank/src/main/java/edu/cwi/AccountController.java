package edu.cwi;

import io.javalin.http.Context;
import java.util.Map;

public class AccountController {

    public static void renderAccount(Context ctx) {

        String userId = ctx.cookieStore().get("user-id");

        UserAccount account = AuthController.getUser(userId)
            .orElseThrow();

        
        ctx.render("jte/accountPage.jte", Map.of(
            "title", "My Bank Account",
            "account", account
        ));
    }
}

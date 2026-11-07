package edu.cwi;

import static io.javalin.apibuilder.ApiBuilder.*;

import io.javalin.Javalin;
import io.javalin.http.UnauthorizedResponse;
import io.javalin.rendering.template.JavalinJte;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        var app = Javalin.create(config -> {

            config.fileRenderer(new JavalinJte());

            config.routes.beforeMatched(ctx -> {

                if (ctx.routeRoles().isEmpty()) {
                    return;
                }

                String role = ctx.cookieStore().get("user-role");

                if (role == null) {
                    throw new UnauthorizedResponse();
                }

                AppRole appRole = AppRole.valueOf(role);

                if (!ctx.routeRoles().contains(appRole)) {
                    throw new UnauthorizedResponse();
                }
            });

            config.routes.apiBuilder(() -> {

                // default login page
                get("/", ctx -> ctx.render("jte/loginPage.jte"));

                // Public login route
                post("/login", AuthController::authenticate);

                // Public logout route
                post("/logout", AuthController::logout);

                // Protected account route
                path("/account", List.of(AppRole.CUSTOMER), () -> {
                    get(AccountController::renderAccount);
                });

                // Existing transaction routes
                crud("transactions/{id}", new TransactionsController());

            });

        }).start(7070);
    }
}

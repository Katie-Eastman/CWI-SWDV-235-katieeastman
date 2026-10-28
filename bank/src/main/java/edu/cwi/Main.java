package edu.cwi;
import static io.javalin.apibuilder.ApiBuilder.*;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

public class Main 
{
    public static void main( String[] args )
    {
        var app = Javalin.create(config -> {

            config.fileRenderer(new JavalinJte());

            config.routes.apiBuilder(() -> {
				crud("transactions/{id}", new TransactionsController());
			});
            
        }).start(7070);
    }
}

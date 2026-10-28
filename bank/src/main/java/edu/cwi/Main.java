package edu.cwi;
import static io.javalin.apibuilder.ApiBuilder.*;
import io.javalin.Javalin;

public class Main 
{
    public static void main( String[] args )
    {
        var app = Javalin.create(config -> {

            config.routes.apiBuilder(() -> {
				crud("transactions/{id}", new TransactionsController());
			});
            
        }).start(7070);
    }
}

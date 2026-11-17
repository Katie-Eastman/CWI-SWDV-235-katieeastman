package gg.jte.generated.ondemand.jte;
import edu.cwi.data.User;
import edu.cwi.data.Account;
import java.util.List;
@SuppressWarnings("unchecked")
public final class JteaccountsPageGenerated {
	public static final String JTE_NAME = "jte/accountsPage.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,13,13,13,13,29,29,29,29,29,29,44,44,44,44,50,50,50,55,55,55,60,60,60,64,64,64,64,72,72,72,76,76,84,84,84,4,5,6,6,6,6};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, User user, List<Account> accounts) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("</title>\n\n    <link\n        href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css\"\n        rel=\"stylesheet\"\n    >\n</head>\n\n<body class=\"bg-light\">\n\n<div class=\"container mt-5\">\n\n    <div class=\"d-flex justify-content-between align-items-center mb-4\">\n\n        <div>\n            <h1>My Accounts</h1>\n            <h4>Welcome, ");
		jteOutput.setContext("h4", null);
		jteOutput.writeUserContent(user.getFirstName());
		jteOutput.writeContent(" ");
		jteOutput.setContext("h4", null);
		jteOutput.writeUserContent(user.getLastName());
		jteOutput.writeContent("!</h4>\n        </div>\n\n        <form action=\"/logout\" method=\"post\">\n            <button type=\"submit\" class=\"btn btn-danger\">\n                Log Out\n            </button>\n        </form>\n\n    </div>\n\n    <div class=\"card shadow p-4\">\n\n        <h3 class=\"mb-3\">Your Accounts</h3>\n\n        ");
		boolean __jte_for_loop_entered_1 = false;
		for (Account account : accounts) {
			__jte_for_loop_entered_1 = true;
			jteOutput.writeContent("\n\n            <div class=\"border rounded p-3 mb-3\">\n\n                <p>\n                    <strong>Account Number:</strong>\n                    ");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(account.getId());
			jteOutput.writeContent("\n                </p>\n\n                <p>\n                    <strong>Account Type:</strong>\n                    ");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(account.getAccountType());
			jteOutput.writeContent("\n                </p>\n\n                <p>\n                    <strong>Balance:</strong>\n                    $");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(account.getBalance());
			jteOutput.writeContent("\n                </p>\n\n                <a\n                    href=\"/account/");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(account.getId());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"\n                    class=\"btn btn-primary\"\n                >\n                    View Account Details\n                </a>\n\n            </div>\n\n        ");
		}
		if (!__jte_for_loop_entered_1) {
			jteOutput.writeContent("\n\n            <p>You don't have any accounts yet.</p>\n\n        ");
		}
		jteOutput.writeContent("\n\n    </div>\n\n</div>\n\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.get("title");
		User user = (User)params.get("user");
		List<Account> accounts = (List<Account>)params.get("accounts");
		render(jteOutput, jteHtmlInterceptor, title, user, accounts);
	}
}

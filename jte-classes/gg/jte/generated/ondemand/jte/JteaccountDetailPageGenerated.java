package gg.jte.generated.ondemand.jte;
import edu.cwi.data.User;
import edu.cwi.data.Account;
import edu.cwi.data.Transaction;
import java.util.List;
@SuppressWarnings("unchecked")
public final class JteaccountDetailPageGenerated {
	public static final String JTE_NAME = "jte/accountDetailPage.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,5,5,5,5,16,16,16,16,28,33,33,33,33,33,33,44,51,51,51,56,56,56,60,60,60,65,70,70,76,76,91,91,94,94,94,95,95,95,96,96,96,97,97,97,100,100,106,106,110,121,121,121,5,6,7,8,8,8,8};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, User user, Account account, List<Transaction> transactions) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("</title>\n\n    <link\n        href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css\"\n        rel=\"stylesheet\"\n    >\n</head>\n\n<body class=\"bg-light\">\n\n<div class=\"container mt-5\">\n\n    ");
		jteOutput.writeContent("\n    <div class=\"d-flex justify-content-between align-items-center mb-4\">\n\n        <div>\n            <h1>Account Details</h1>\n            <h4>");
		jteOutput.setContext("h4", null);
		jteOutput.writeUserContent(user.getFirstName());
		jteOutput.writeContent(" ");
		jteOutput.setContext("h4", null);
		jteOutput.writeUserContent(user.getLastName());
		jteOutput.writeContent("</h4>\n        </div>\n\n        <form action=\"/logout\" method=\"post\">\n            <button type=\"submit\" class=\"btn btn-danger\">\n                Log Out\n            </button>\n        </form>\n\n    </div>\n\n    ");
		jteOutput.writeContent("\n    <div class=\"card shadow p-4 mb-4\">\n\n        <h3 class=\"mb-3\">Account Information</h3>\n\n        <p>\n            <strong>Account Number:</strong>\n            ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(account.getId());
		jteOutput.writeContent("\n        </p>\n\n        <p>\n            <strong>Account Type:</strong>\n            ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(account.getAccountType());
		jteOutput.writeContent("\n        </p>\n\n        <h4 class=\"text-success\">\n            Balance: $");
		jteOutput.setContext("h4", null);
		jteOutput.writeUserContent(account.getBalance());
		jteOutput.writeContent("\n        </h4>\n\n    </div>\n\n    ");
		jteOutput.writeContent("\n    <div class=\"card shadow p-4 mb-4\">\n\n        <h3 class=\"mb-3\">Transaction History</h3>\n\n        ");
		if (transactions.isEmpty()) {
			jteOutput.writeContent("\n\n            <p class=\"text-muted\">\n                No transactions to display.\n            </p>\n\n        ");
		} else {
			jteOutput.writeContent("\n\n            <table class=\"table table-striped table-hover\">\n\n                <thead>\n                    <tr>\n                        <th>Transaction Type</th>\n                        <th>Amount</th>\n                        <th>Description</th>\n                        <th>Date</th>\n                    </tr>\n                </thead>\n\n                <tbody>\n\n                    ");
			for (Transaction transaction : transactions) {
				jteOutput.writeContent("\n\n                        <tr>\n                            <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(transaction.getTransactionType());
				jteOutput.writeContent("</td>\n                            <td>$");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(transaction.getAmount());
				jteOutput.writeContent("</td>\n                            <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(transaction.getDescription());
				jteOutput.writeContent("</td>\n                            <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(transaction.getCreatedAt().toString());
				jteOutput.writeContent("</td>\n                        </tr>\n\n                    ");
			}
			jteOutput.writeContent("\n\n                </tbody>\n\n            </table>\n\n        ");
		}
		jteOutput.writeContent("\n\n    </div>\n\n    ");
		jteOutput.writeContent("\n    <a href=\"/accounts\" class=\"btn btn-primary\">\n        Back to Accounts\n    </a>\n\n</div>\n\n<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js\"></script>\n\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.get("title");
		User user = (User)params.get("user");
		Account account = (Account)params.get("account");
		List<Transaction> transactions = (List<Transaction>)params.get("transactions");
		render(jteOutput, jteHtmlInterceptor, title, user, account, transactions);
	}
}

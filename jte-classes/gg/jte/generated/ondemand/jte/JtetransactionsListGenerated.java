package gg.jte.generated.ondemand.jte;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JtetransactionsListGenerated {
	public static final String JTE_NAME = "jte/transactionsList.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,2,7,7,7,7,7,8,8,8,8,8,8,9,9,9,11,11,37,37,37,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Map<String, String> transactions) {
		jteOutput.writeContent("\n<h1>Transactions</h1>\n\n<ul>\n    ");
		boolean __jte_for_loop_entered_1 = false;
		for (var entry : transactions.entrySet()) {
			__jte_for_loop_entered_1 = true;
			jteOutput.writeContent("\n        <li>");
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(entry.getKey());
			jteOutput.writeContent(": ");
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(entry.getValue());
			jteOutput.writeContent("</li>\n    ");
		}
		if (!__jte_for_loop_entered_1) {
			jteOutput.writeContent("\n        <li>You have no transactions to display.</li>\n    ");
		}
		jteOutput.writeContent("\n</ul>\n\n<h2>Add a Transaction</h2>\n\n<form action=\"/transactions\" method=\"post\">\n\n    <div class=\"mb-3\">\n        <label for=\"description\" class=\"form-label\">\n            Transaction Description\n        </label>\n\n        <input\n            type=\"text\"\n            class=\"form-control\"\n            id=\"description\"\n            name=\"description\"\n            placeholder=\"Enter a transaction\"\n            required\n        >\n    </div>\n\n    <button type=\"submit\" class=\"btn btn-primary\">\n        Add Transaction\n    </button>\n\n</form>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Map<String, String> transactions = (Map<String, String>)params.get("transactions");
		render(jteOutput, jteHtmlInterceptor, transactions);
	}
}

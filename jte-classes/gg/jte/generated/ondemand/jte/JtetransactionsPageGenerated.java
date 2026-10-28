package gg.jte.generated.ondemand.jte;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JtetransactionsPageGenerated {
	public static final String JTE_NAME = "jte/transactionsPage.jte";
	public static final int[] JTE_LINE_INFO = {1,1,4,4,4,4,18,18,19,19,20,20,20,20,20,20,21,21,25,25,25,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Map<String, String> transactions) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n  <head>\n    <meta charset=\"utf-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n    <title>Transactions</title>\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n    <link rel=\"stylesheet\" href=\"/css/styles.css\">\n  </head>\n  <body>\n    <h1>Transactions</h1>\n    <ul>\n\t\t");
		jteOutput.writeContent("\n\t\t");
		for (var entry : transactions.entrySet()) {
			jteOutput.writeContent("\n\t\t\t<li>");
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(entry.getKey());
			jteOutput.writeContent(": ");
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(entry.getValue());
			jteOutput.writeContent("</li>\n\t\t");
		}
		jteOutput.writeContent("\n    </ul>\n    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js\"></script>\n  </body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Map<String, String> transactions = (Map<String, String>)params.get("transactions");
		render(jteOutput, jteHtmlInterceptor, transactions);
	}
}

package gg.jte.generated.ondemand.jte;
import gg.jte.Content;
@SuppressWarnings("unchecked")
public final class JteaccountLayoutGenerated {
	public static final String JTE_NAME = "jte/accountLayout.jte";
	public static final int[] JTE_LINE_INFO = {2,2,5,5,5,5,15,15,15,15,37,37,37,41,41,41,51,51,51,5,6,7,7,7,7};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, Content account, Content detail) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"utf-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("</title>\n\n    <link\n        href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css\"\n        rel=\"stylesheet\"\n    >\n</head>\n\n<body>\n\n    <div class=\"container mt-4\">\n\n        <div class=\"d-flex justify-content-end mb-4\">\n            <form action=\"/logout\" method=\"post\">\n                <button type=\"submit\" class=\"btn btn-danger\">\n                    Log Out\n                </button>\n            </form>\n        </div>\n\n        <div class=\"row\">\n            <div class=\"col\">\n                ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(account);
		jteOutput.writeContent("\n            </div>\n\n            <div class=\"col\">\n                ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(detail);
		jteOutput.writeContent("\n            </div>\n        </div>\n\n    </div>\n\n    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js\"></script>\n\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.getOrDefault("title", "My Bank");
		Content account = (Content)params.get("account");
		Content detail = (Content)params.get("detail");
		render(jteOutput, jteHtmlInterceptor, title, account, detail);
	}
}

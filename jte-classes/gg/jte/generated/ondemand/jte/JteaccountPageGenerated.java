package gg.jte.generated.ondemand.jte;
import edu.cwi.UserAccount;
@SuppressWarnings("unchecked")
public final class JteaccountPageGenerated {
	public static final String JTE_NAME = "jte/accountPage.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,2,5,5,9,9,12,12,12,12,14,14,14,14,14,2,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, UserAccount account) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.jte.JteaccountLayoutGenerated.render(jteOutput, jteHtmlInterceptor, title, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				gg.jte.generated.ondemand.jte.JteuserAccountGenerated.render(jteOutput, jteHtmlInterceptor, account.name(), account.formatBalance());
			}
		}, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				gg.jte.generated.ondemand.jte.JtetransactionsListGenerated.render(jteOutput, jteHtmlInterceptor, account.transactions());
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.get("title");
		UserAccount account = (UserAccount)params.get("account");
		render(jteOutput, jteHtmlInterceptor, title, account);
	}
}

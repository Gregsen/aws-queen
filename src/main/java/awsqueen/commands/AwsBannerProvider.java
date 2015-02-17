package awsqueen.commands;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultBannerProvider;
import org.springframework.shell.support.util.OsUtils;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AwsBannerProvider extends DefaultBannerProvider  {

	public String getBanner() {
		StringBuffer buf = new StringBuffer();
		buf.append("==================================================================" + OsUtils.LINE_SEPARATOR);
		buf.append("|                                                                |"+ OsUtils.LINE_SEPARATOR);
		buf.append("|                           awsqueen                             |" +OsUtils.LINE_SEPARATOR);
		buf.append("|                                                                |"+ OsUtils.LINE_SEPARATOR);
		buf.append("==================================================================" + OsUtils.LINE_SEPARATOR);
		buf.append("Version:" + this.getVersion());
		return buf.toString();
	}

	public String getVersion() {
		return "0.0.1-alpha";
	}

	public String getWelcomeMessage() {
		return "Welcome awsqueen CLI";
	}

	@Override
	public String getProviderName() {
		return "Awsqueen";
	}
}
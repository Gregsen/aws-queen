package awsqueen.commands;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultPromptProvider;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AwsPromptProvider extends DefaultPromptProvider {

	@Override
	public String getPrompt() {
		return "aws-shell>";
	}


	@Override
	public String getProviderName() {
		return "Aws prompt provider";
	}

}

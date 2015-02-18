package awsqueen.commands;

import awsqueen.aws.AwsConnector;
import com.amazonaws.auth.AWSCredentials;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;

import org.springframework.stereotype.Component;


@Component
public class AwsCommands implements CommandMarker {
    AwsConnector awsConnector = new AwsConnector();

    @CliCommand(value = "awq", help = "Print information for this context")
    public String list(@CliOption(key = {"test"}, mandatory = false, help = "as list") final String asList) {
        return "here should we run a ls for the context requested";
    }

    @CliCommand(value = "awcredentials", help = "Print AWS Crendentials")
    public String credentials(){
        AWSCredentials awsCredentials = awsConnector.getAwsCredentials();
        String output = awsCredentials.getAWSAccessKeyId() + " - " + awsCredentials.getAWSSecretKey();
        return output;
    }

}

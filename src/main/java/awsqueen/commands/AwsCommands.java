package awsqueen.commands;

import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;

import org.springframework.stereotype.Component;

@Component
public class AwsCommands implements CommandMarker {

    @CliCommand(value = "awq", help = "Print information for this context")
    public String list(@CliOption(key = {"test"}, mandatory = false, help = "as list") final String asList) {
        return "here should we run a ls for the context requested";
    }

}

package awsqueen.commands;

import awsqueen.aws.AwsConnector;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;

import org.springframework.stereotype.Component;


@Component
public class AwsCommands implements CommandMarker {
    AwsConnector awsConnector = new AwsConnector();

    @Autowired
    private Ec2cli ec2cli;

    public AwsCommands(Regions reg) {
        ec2cli.setre
    }

    @Async
    @CliCommand(value = "awq", help = "Print information for this context")
    public String list(@CliOption(key = {"test"}, mandatory = false, help = "as list") final String asList) {
        AmazonEC2Client amazonEC2Client = new AmazonEC2Client(new AwsConnector().getAwsCredentials());
        for (Regions region : Regions.values()) {
            amazonEC2Client.setRegion(region);
            DescribeInstancesResult describeInstancesResult = amazonEC2Client.describeInstances();
//            if (describeInstancesResult.getReservations().get(0).getInstances().size()
            if (describeInstancesResult.getReservations().size() >0 ){

            }
        }

        return "here should we run a ls for the context requested";
    }

    @CliCommand(value = "awcredentials", help = "Print AWS Crendentials")
    public String credentials(){
        AWSCredentials awsCredentials = awsConnector.getAwsCredentials();
        String output = awsCredentials.getAWSAccessKeyId() + " - " + awsCredentials.getAWSSecretKey();
        return output;
    }



}

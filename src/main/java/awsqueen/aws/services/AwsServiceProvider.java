package awsqueen.aws.services;

import awsqueen.aws.AwsConnector;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2Client;

/**
 * Created by greg on 19.02.15.
 */
public class AwsServiceProvider {
    private AwsConnector awsConnector;
    private AWSCredentials awsCredentials;

    public AwsServiceProvider() {
        awsConnector = new AwsConnector();
        awsCredentials = awsConnector.getAwsCredentials();
    }

    public AmazonEC2Client getEc2(){
        return new AmazonEC2Client(awsCredentials);
    }
}

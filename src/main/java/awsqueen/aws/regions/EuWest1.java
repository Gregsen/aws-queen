package awsqueen.aws.regions;

import awsqueen.aws.AwsConnector;
import awsqueen.aws.services.AwsServiceProvider;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2Client;

/**
 * Created by greg on 19.02.15.
 */
public class EuWest1 {
    private AWSCredentials awsCredentials;

    public EuWest1() {
        AwsConnector awsConnector = new AwsConnector();
        awsCredentials = awsConnector.getAwsCredentials();
    }

    public boolean hasEc2(){
        AmazonEC2Client amazonEC2Client = new AwsServiceProvider().getEc2();
        try {
            amazonEC2Client.setRegion(Region.getRegion(Regions.EU_WEST_1));
        } catch (java.lang.IllegalArgumentException ex){
            return false;
        }
        return true;
    }


}

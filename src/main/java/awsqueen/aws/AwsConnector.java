package awsqueen.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;

/**
 * Created by greg on 17.02.15.
 */
public class AwsConnector {
    private AWSCredentials awsCredentials;

    public AwsConnector(){
        setAwsCredentials();
    }

    public void setAwsCredentials() {
        this.awsCredentials = new ProfileCredentialsProvider().getCredentials();
    }

    public AWSCredentials getAwsCredentials() {
        return awsCredentials;
    }
}

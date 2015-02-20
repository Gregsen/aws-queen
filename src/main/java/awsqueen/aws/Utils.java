package awsqueen.aws;

import awsqueen.aws.services.AwsServiceProvider;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by greg on 19.02.15.
 */
public class Utils {
    private AWSCredentials awsCredentials;

    public Utils() {
        AwsConnector awsConnector = new AwsConnector();
        awsCredentials = awsConnector.getAwsCredentials();
    }

    public List<Regions> findUsedRegions(){
        List<Regions> regionsList = new ArrayList<Regions>();
        for (Regions region : Regions.values()){
            try {
                new AwsServiceProvider().getEc2().setRegion(region);
                regionsList.add(region);
            } catch (java.lang.IllegalArgumentException ex){
                break;
            }
        }

        return regionsList;
    }
}

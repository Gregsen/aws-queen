package awsqueen.aws.services;

import java.util.Map;

import com.amazonaws.regions.Region;

/**
 * Created by gkneitschel on 27/02/15.
 */
public interface ClientService {

    String BEAN_NAME = "ClientService";

    Map<String, Object> getAllServices(final Region region);
}

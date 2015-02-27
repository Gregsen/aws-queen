package awsqueen.aws.services.impl;

import static awsqueen.aws.domain.Service.*;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.amazonaws.regions.Region;

import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingClient;
import com.amazonaws.services.route53.AmazonRoute53Client;

import com.google.common.collect.Maps;

import awsqueen.aws.services.ClientService;

/**
 * Created by gkneitschel on 27/02/15.
 */
@Service(ClientService.BEAN_NAME)
public class ClientServiceImpl implements ClientService {

    @Autowired
    private AmazonEC2Client amazonEC2Client;

    @Autowired
    private AmazonElasticLoadBalancingClient amazonElasticLoadBalancingClient;

    @Autowired
    private AmazonRoute53Client amazonRoute53Client;

    private Map<String, Object> awsServices = Maps.newHashMap();

    public Map<String, Object> getAllServices(final Region region) {

        amazonEC2Client.setRegion(region);
        awsServices.put(EC_2.name(), amazonEC2Client);

        amazonElasticLoadBalancingClient.setRegion(region);
        awsServices.put(ELB.name(), amazonElasticLoadBalancingClient);

        amazonRoute53Client.setRegion(region);
        awsServices.put(ROUTE_53.name(), amazonRoute53Client);

        return awsServices;
    }
}

package awsqueen.aws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingClient;
import com.amazonaws.services.route53.AmazonRoute53Client;

/**
 * Created by gkneitschel.
 */
@Configuration
public class AWSConfig {

    @Bean(ec2bla)
    AmazonEC2Client amazonEC2Client() {

        // set region bla
        return new AmazonEC2Client();
    }

    @Bean(ec2blub)
    AmazonEC2Client amazonEC2Client() {

        // set region blub
        return new AmazonEC2Client();
    }

    @Bean
    AmazonElasticLoadBalancingClient amazonElasticLoadBalancingClient() {
        return new AmazonElasticLoadBalancingClient();
    }

    @Bean
    AmazonRoute53Client amazonRoute53Client() {
        return new AmazonRoute53Client();
    }

}

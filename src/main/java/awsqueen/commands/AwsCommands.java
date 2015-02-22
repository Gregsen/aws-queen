/*
 * Copyright (C) 2015 aws-queen team
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; either version 2 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program; if not, see <http://www.gnu.org/licenses>.
 */

package awsqueen.commands;

import awsqueen.aws.AwsConnector;
import awsqueen.aws.Utils;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;



@Component
public class AwsCommands implements CommandMarker {
    private final AwsConnector awsConnector = new AwsConnector();

   /* @Autowired
    private Ec2cli ec2cli;

    public AwsCommands(Regions reg) {
        ec2cli.setre
    }*/


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

    @CliCommand(value = "awsinit", help = "Initialise a AWS based directory structure. Run this before everything else")
    public void awsInit(){
        new Utils().initDirs();
    }

    @CliCommand(value = "awsrm", help = "removes folders created by awsinit. By default, only empty folders will be deleted")
    public String awsRm(
            @CliOption(key = {"force"}, mandatory = false, help = "force deletion of non-empty folders", specifiedDefaultValue= "true", unspecifiedDefaultValue = "")
                final String force){
        return new Utils().rmDirs(force);

    }

    @CliCommand(value = "awscredentials", help = "Print AWS Credentials")
    public String credentials(){
        AWSCredentials awsCredentials = awsConnector.getAwsCredentials();
        String output = awsCredentials.getAWSAccessKeyId() + " - " + awsCredentials.getAWSSecretKey();
        return output;
    }

    @CliCommand(value = "awsls", help = "List services within a region")
    public String lsEc2(){
        AmazonEC2Client amazonEC2Client = new AmazonEC2Client(awsConnector.getAwsCredentials());
        amazonEC2Client.setRegion(Region.getRegion(Regions.EU_CENTRAL_1));
        DescribeInstancesResult result = amazonEC2Client.describeInstances();
        if (result.getReservations().size() > 0){
            return "yay";
        }
        return result.getReservations().get(0).toString();
        //return output;
        /*EuWest1 euWest1  = new EuWest1();
        if (euWest1.hasEc2()){
            return "yeah";
        }
        return "nope";*/
    }



}

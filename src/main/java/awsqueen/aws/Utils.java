/*
 * Copyright (C) 2015 aws-queen team
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; either version 2 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program; if not, see <http://www.gnu.org/licenses>.
 */

package awsqueen.aws;

import awsqueen.aws.services.AwsServiceProvider;
import awsqueen.aws.services.ClientService;
import awsqueen.aws.services.impl.ClientServiceImpl;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ecs.AmazonECSClient;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public void initDirs(){
        for (Regions region : Regions.values()) {
            File directory = new File(region.getName());
            if(!directory.exists()){
                try {
                    directory.mkdir();
                } catch (SecurityException se){
                    System.out.println("Cannot create directory:" + se);
                }
            }
        }

    }

    public void test(){
        ClientServiceImpl clientService = new ClientServiceImpl();
        Map<String, Object> allServices = clientService.getAllServices(Regions.AP_NORTHEAST_1);

        for (Object o : allServices.values()) {
            if ((String) o )

                if o instanceof AmazonEc2Client

                    if string equals ec2
                    dann (AmazonECSClient) o
        }

    }

    public String rmDirs(String force) {
        if (!force.isEmpty() && !force.equals("true")){
            return "Unknown sequence: "+force;
        }
        for (Regions region : Regions.values()) {
            File directory = new File(region.getName());
            if(force.isEmpty()){
                try { //TODO deletes non-emtpy directories...should not work, works anyway
                    FileUtils.deleteDirectory(directory);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
              FileUtils.deleteQuietly(directory);
            }
        }
        return "";
    }
}

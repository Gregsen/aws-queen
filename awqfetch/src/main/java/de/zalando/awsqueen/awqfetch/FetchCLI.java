/*
 * Copyright (C) 2015 aws-queen team
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; either version 2 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program; if not, see <http://www.gnu.org/licenses>.
 */

package de.zalando.awsqueen.awqfetch;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

@Component
public class FetchCLI implements CommandLineRunner {

    public static final String USER_DIR = "user.dir";

    private String currentDir = System.getProperty(USER_DIR);

    @Override
    public void run(final String... args) {

        try {
            checkArgument(args.length == 1, "Number of arguments must be exactly 1");
        } catch (final IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Usage:\n" //
                    + "run.sh <service>");
        }

        final String service = args[0];
        Path currentDirPath = Paths.get(currentDir);
        Region region = null;

        try {
            region = Region.getRegion(Regions.fromName(currentDirPath.toFile().getName()));
        } catch (final IllegalArgumentException e) {
            System.out.println("Region " + currentDir + " not found in AWS");
        }

        if (region == null) {
            System.exit(1);
        }

        try {
            switch (service) {

                case "ec2" :
                    fetchEC2(region);
                    break;

                case "elb" :
                    System.out.println("elb");
                    break;

                default :

                    break;
            }
        } catch (final IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Usage:\n" //
                    + "run.sh <service>");
        }
    }

    private void fetchEC2(final Region region) {
        Path ec2Path = Paths.get(currentDir, "ec2");
        ec2Path.toFile().mkdir();

        AmazonEC2Client amazonEC2Client = new AmazonEC2Client();
        amazonEC2Client.setRegion(region);

        DescribeInstancesResult describeInstancesResult = amazonEC2Client.describeInstances();
        List<Reservation> reservations = describeInstancesResult.getReservations();
        for (Reservation reservation : reservations) {
            List<Instance> instances = reservation.getInstances();
            for (Instance instance : instances) {
                System.out.println("instance id: " + instance.getInstanceId());
            }
        }

    }

}

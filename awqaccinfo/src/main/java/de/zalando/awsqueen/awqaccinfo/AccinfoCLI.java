/*
 * Copyright (C) 2015 aws-queen team
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; either version 2 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program; if not, see <http://www.gnu.org/licenses>.
 */

package de.zalando.awsqueen.awqaccinfo;

import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.AccountAttribute;
import com.amazonaws.services.ec2.model.DescribeAccountAttributesResult;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by greg
 */
@Component
public class AccinfoCLI implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {

        AmazonEC2Client amazonEC2Client = new AmazonEC2Client();
        DescribeAccountAttributesResult describeAccountAttributesResult = amazonEC2Client.describeAccountAttributes();
        List<AccountAttribute> accountAttributes = describeAccountAttributesResult.getAccountAttributes();
        //System.out.println(accountAttributes.toString());
        for (AccountAttribute accountAttribute : accountAttributes) {
            System.out.println(accountAttribute);
        }

    }
}

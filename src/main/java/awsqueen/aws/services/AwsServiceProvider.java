/*
 * Copyright (C) 2015 aws-queen team
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; either version 2 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program; if not, see <http://www.gnu.org/licenses>.
 */

package awsqueen.aws.services;

import awsqueen.aws.AwsConnector;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2Client;

/**
 * Created by greg on 19.02.15.
 */
/**
 * Enumerate the available functions. Although an enum may define
 * <i>constant-specific</i> methods, an included adpter or interface
 * is perhaps easier to read, initialize and maintain.
 */
/*enum Function {
    E    (new E()),
    PI   (new Pi()),
    LN   (new Ln()),
    EXP  (new Exp()),
    SIN  (new Sin()),
    COS  (new Cos()),
    TAN  (new Tan()),
    ATAN (new Atan()),
    SQRT (new Sqrt()),
    MAX  (new Max()),
    MIN  (new Min()),
    POW  (new Pow());

    private FunctionAdapter fa;

    *//** Construct a Function with the specified adapter. **//*
    private Function(FunctionAdapter fa) {
        this.fa = fa;
    }

    *//** Return a Function's adapter by name; null if unknown. *//*
    public static FunctionAdapter lookup(String name) {
        Function f;
        try {
            f = Enum.valueOf(Function.class, name.toUpperCase());
        } catch (RuntimeException e) {
            return null;
        }
        return f.fa;
    }
}*/
public class AwsServiceProvider {
    private AwsConnector awsConnector;
    private AWSCredentials awsCredentials;

    public AwsServiceProvider() {
        awsConnector = new AwsConnector();
        awsCredentials = awsConnector.getAwsCredentials();
    }

    public AmazonEC2Client getEc2(){
        return new AmazonEC2Client(awsCredentials);
    }
}

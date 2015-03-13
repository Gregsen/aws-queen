package de.zalando.awsqueen.awqregion;

import java.io.File;

import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import com.amazonaws.regions.Regions;

@Component
public class RegionCLI implements CommandLineRunner {

    public static final String USER_DIR = "user.dir";

    private String currentDir = System.getProperty(USER_DIR);

    @Override
    public void run(final String... args) {

        new File(currentDir).mkdir(); // TODO mkdir is not mkdir -p

        for (Regions region : Regions.values()) {

            File directory = new File(currentDir + "/" + region.getName());
            System.out.println(directory);
            if (!directory.exists()) {
                try {
                    boolean result = directory.mkdir();
                    System.out.println(result);
                } catch (SecurityException se) {
                    System.out.println("Cannot create directory:" + se);
                }
            }
        }
    }
}

package de.zalando.awsqueen.awqregion;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class RegionApplication {

    public static void main(final String[] args) {
        final SpringApplicationBuilder app = new SpringApplicationBuilder(RegionApplication.class);
        app.showBanner(false);
        app.properties("spring.cloud.bootstrap.enabled=false", "logging.level.ROOT=WARN");
        app.run(args);
    }
}

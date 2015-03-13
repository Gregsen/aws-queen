package de.zalando.awsqueen.awqfetch;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class FetchApplication {

    public static void main(final String[] args) {
        final SpringApplicationBuilder app = new SpringApplicationBuilder(FetchApplication.class);
        app.showBanner(false);
        app.properties("spring.cloud.bootstrap.enabled=false", "logging.level.ROOT=WARN");
        app.run(args);
    }
}

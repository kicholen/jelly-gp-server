package jelly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.net.URISyntaxException;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) throws URISyntaxException {
        SpringApplication.run(Application.class, args);
    }
}

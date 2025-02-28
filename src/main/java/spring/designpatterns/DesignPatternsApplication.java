package spring.designpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DesignPatternsApplication {

    // this app covers various design patterns in java applications.
    // the main types of patterns are
    //  creational patterns: focus on object creation
    //  behavioral patterns: focus on the communication/ behaviour between objects
    //  structural patterns: Focus on object composition and interfaces, the structure of the objects we use

    /*
    some of the design patterns used in spring are:
        Inversion of Control Pattern
        Proxy Pattern
        Factory Pattern (the IoC container itself is self a factory)
        Singleton and Prototype Patterns
        Template Pattern
        MVC Pattern
     */
    public static void main(String[] args) {
        SpringApplication.run(DesignPatternsApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}

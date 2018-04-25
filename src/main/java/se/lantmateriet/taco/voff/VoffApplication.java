package se.lantmateriet.taco.voff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("se.lantmateriet.taco")
public class VoffApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoffApplication.class, args);
    }
}

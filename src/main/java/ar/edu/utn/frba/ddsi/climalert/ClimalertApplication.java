package ar.edu.utn.frba.ddsi.climalert;

import ar.edu.utn.frba.ddsi.climalert.config.WeatherApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(WeatherApiProperties.class)
public class ClimalertApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClimalertApplication.class, args);
    }

}

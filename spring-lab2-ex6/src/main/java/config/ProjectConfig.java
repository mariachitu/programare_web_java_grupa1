package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "beans")
@PropertySource("classpath:/application.properties")
public class ProjectConfig {

    @Bean
    public String name()    {
        return "Gigel";
    }

}

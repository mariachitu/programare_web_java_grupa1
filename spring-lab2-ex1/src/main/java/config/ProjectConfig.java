package config;

import model.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

//    @Bean
    @Bean("tom")
//    @Bean(value = "tom")
//    @Bean(name = "tom")
    @Primary
    public Cat cat() {
        Cat cat = new Cat();
        cat.setName("Tom");
        return cat;
    }

    @Bean
    public Cat cat2() {
        Cat cat = new Cat();
        cat.setName("Fluffy");
        return cat;
    }

    @Bean
    public String hello()   {
        return "Hello!";
    }
}

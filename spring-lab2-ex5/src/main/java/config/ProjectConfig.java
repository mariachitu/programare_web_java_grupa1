package config;

import beans.Cat;
import beans.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Cat cat() {
        Cat cat = new Cat();
        cat.setName("Tom");
        return cat;
    }

    @Bean("leo")
    public Cat catSecond() {
        Cat cat = new Cat();
        cat.setName("leo");
        return cat;
    }

//    @Bean
//    public Person person(Cat cat)   { //by type
//        Person person = new Person();
//        person.setCat(cat);
//        person.setName("Jan");
//        return person;
//    }

//    @Bean
//    public Person person()   {
//        Person person = new Person();
//        person.setCat(cat());
//        person.setName("Jan");
//        return person;
//    }

    @Bean
    public Person person(@Qualifier("leo") Cat cat) { //by name
        Person person = new Person();
        person.setCat(cat);
        person.setName("Dan");
        return person;
    }
}

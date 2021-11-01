package main;

import beans.Cat;
import beans.Person;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

//        Cat cat = context.getBean(Cat.class);
//        System.out.println(cat);

        Cat cat = context.getBean("leo", Cat.class);
        System.out.println(cat);

        Person person = context.getBean(Person.class);
        System.out.println(person);

        cat.setName("Test");
        System.out.println(cat);
        System.out.println(person);
    }
}

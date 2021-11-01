package main;

import beans.Cat;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            System.out.println("Context was created");

            Cat cat = context.getBean(Cat.class);
            cat.sayMeow();
        }

//        context.close();
    }
}

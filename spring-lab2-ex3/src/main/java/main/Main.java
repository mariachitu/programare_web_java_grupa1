package main;

import bean.Cat;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        context.registerBean("cat", Cat.class);

        Cat cat = context.getBean("cat", Cat.class);
        System.out.println(cat);

        context.registerBean("fluffy", Cat.class, () -> new Cat("Fluffy"));
        Cat fluffy = context.getBean("fluffy", Cat.class);
        System.out.println(fluffy);
    }
}

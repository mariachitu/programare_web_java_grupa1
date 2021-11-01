package main;


import config.ProjectConfig;
import model.Cat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
- @Bean
- @component
- programtic
- xml
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Cat cat = context.getBean(Cat.class);  //by type
        System.out.println(cat);

        Cat catSecond = context.getBean("cat2", Cat.class);  //by name and type
        System.out.println(catSecond);

        Cat catFirst = context.getBean("tom", Cat.class);
        System.out.println(catFirst);

        Cat catThird = (Cat) context.getBean("tom"); // by type
        System.out.println(catThird);

        String hello = context.getBean(String.class);
        System.out.println(hello);

    }
}

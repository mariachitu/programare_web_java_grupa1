package main;

import bean.Cat;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        //FileSystemXmlApplicationContext
        //ClassPathXmlApplicationContext

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");

//        Cat cat = context.getBean(Cat.class);
//        System.out.println(cat);

        Cat cat = context.getBean("cat", Cat.class);
        System.out.println(cat);
    }
}

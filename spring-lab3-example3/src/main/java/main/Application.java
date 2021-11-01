package main;

import beans.Student;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            Student student1 = context.getBean(Student.class);
            Student student2 = context.getBean(Student.class);

            student1.setName("Jane");

            if(student1.getName().equals(student2.getName()))   {
                System.out.println("Singleton");
            } else {
                System.out.println("Prototype");
            }

            if(student1 == student2)   {
                System.out.println("Singleton");
            } else {
                System.out.println("Prototype");
            }
        }
    }
}

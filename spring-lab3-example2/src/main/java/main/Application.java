package main;

import beans.EagerComponent;
import beans.LazyComponent;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class))  {
            EagerComponent eagerComponent = context.getBean(EagerComponent.class);
            System.out.println(eagerComponent);

            LazyComponent lazyComponent = context.getBean(LazyComponent.class);
            System.out.println(lazyComponent);
        }
    }
}

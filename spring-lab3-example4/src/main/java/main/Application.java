package main;

import config.ProjectConfig;
import model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserService;

public class Application {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            UserService service = context.getBean(UserService.class);
            User user = service.createUser("Maria", 26);
            System.out.println(user.getName());

//            service.hello();

            User user2 = service.createNewUser("Jane");
            System.out.println(user2.getName());

            service.bye();
        }
    }
}

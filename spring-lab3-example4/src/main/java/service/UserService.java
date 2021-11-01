package service;

import aspects.MarkedForLogging;
import model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> users = new ArrayList<>();

    public User createUser(String name, int age) {
        System.out.println(String.format("Request to create user %s", name));

        User.UserBuilder builder = new User.UserBuilder();
        User user = builder.name(name)
                .surname("Unknown")
                .age(age)
                .information("demo")
                .build();

        System.out.println(String.format("User %s created", name));
        users.add(user);

//        throw new RuntimeException("User not created");

        return user;
    }

    public void hello()   {
        System.out.println("Hi");
    }

    public User createNewUser(String name) {
        System.out.println(String.format("Request to create user %s", name));

        User.UserBuilder builder = new User.UserBuilder();
        User user = builder.name(name)
                .surname("Unknown")
                .age(30)
                .information("demo")
                .build();

        System.out.println(String.format("User %s created", name));
        users.add(user);

        return user;
    }

    @MarkedForLogging
    public void bye()   {
        System.out.println("Bye");
    }
}

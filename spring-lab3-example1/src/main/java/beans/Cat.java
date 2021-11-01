package beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Cat {

    public Cat() {
        System.out.println("Inside the constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("Inside PostConstruct");
    }

    public void sayMeow() {
        System.out.println("Meow!");
    }

    @PreDestroy
    public void destroy()   {
        System.out.println("Inside PreDestroy");
    }
}

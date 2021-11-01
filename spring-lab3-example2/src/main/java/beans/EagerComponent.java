package beans;

import org.springframework.stereotype.Component;

@Component
public class EagerComponent {

    public EagerComponent() {
        System.out.println("EagerComponent was created!");
    }
}

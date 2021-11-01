package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Owner {

    @Autowired
    private Cat cat;

    public Owner() {
//        cat.sayMeow(); //java.lang.NullPointerException
    }

//    private Cat cat;
//
//    @Autowired
//    public Owner(Cat cat) {
//        this.cat = cat;
//        cat.sayMeow();
//    }

    @PostConstruct
    public void init()  {
        cat.sayMeow();
    }
}

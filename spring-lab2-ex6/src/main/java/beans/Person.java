package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

//    @Autowired
    @Value("${person.name}")
    private String name;

    @Autowired
    private Cat cat;

//    @Autowired
//    public Person(String name, Cat cat) {
//        this.name = name;
//        this.cat = cat;
//    }


    public String getName() {
        return name;
    }

//    @Autowired
    public void setName(String name) {
        this.name = name;
    }

    public Cat getCat() {
        return cat;
    }

//    @Autowired
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cat=" + cat +
                '}';
    }
}

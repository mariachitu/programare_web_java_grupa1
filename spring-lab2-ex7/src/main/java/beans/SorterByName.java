package beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class SorterByName implements SorterCriteria {
    @Override
    public void sort() {
        System.out.println("Sort by name");
    }
}

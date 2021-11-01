package beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("grade")
public class SorterByGrade implements SorterCriteria {
    @Override
    public void sort() {
        System.out.println("Sort by grade");
    }
}

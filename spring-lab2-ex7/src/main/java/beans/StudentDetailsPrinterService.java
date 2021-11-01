package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentDetailsPrinterService {

    private final SorterCriteria sorter;

//    @Autowired
//    public StudentDetailsPrinterService(SorterCriteria sorter) {
//        this.sorter = sorter;
//    }

    @Autowired
    public StudentDetailsPrinterService(@Qualifier("grade") SorterCriteria sorter) {
        this.sorter = sorter;
    }


    public void printSortedDetails() {
        sorter.sort();
    }
}

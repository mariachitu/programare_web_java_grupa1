package main;

import beans.StudentDetailsPrinterService;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        StudentDetailsPrinterService service = context.getBean(StudentDetailsPrinterService.class);
        service.printSortedDetails();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author udube
 */
@Configuration
public class LoadDatabase {
    
    private static final Logger log =
            LoggerFactory.getLogger(LoadDatabase.class);
    
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepo,
                                    OrderRepository orderRepo){
        return args -> {
            
                    employeeRepo.save(new Employee("Bilbo", "Baggins", "Burglar"));
                    employeeRepo.save(new Employee("Frodo", "Barggins", "Thief"));
                    employeeRepo.save(new Employee("Bernard", "Udu", "President"));
                    
                    employeeRepo.findAll().forEach(
                    employee -> log.info("Preloading " + employee));
                    
                    orderRepo.save(new Order("MacBook Pro", Status.COMPLETED));
                    orderRepo.save(new Order("iPhone 10", Status.IN_PROGRESS));
                    orderRepo.findAll().forEach(order -> 
                    log.info("Preloaded " + order));
        };
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 *
 * @author udube
 */
interface EmployeeRepository extends 
        JpaRepositoryImplementation<Employee, Long>{
        
}

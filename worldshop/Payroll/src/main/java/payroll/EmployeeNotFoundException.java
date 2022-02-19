/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

/**
 *
 * @author udube
 */
public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("could not find employee id: " + id);
    }
}

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
public class OrderNotFoundException extends RuntimeException{
    
    OrderNotFoundException(Long id){
        super("order not found: " + id);
    }
}

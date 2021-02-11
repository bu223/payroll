/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author udube
 */
public class ShoppingCart {
    
    public static void main(String[] args){
        double price = 76.99, tax = 1.06, total;
        int quantity = 2;
        boolean outOfStock = false;
        String message, custName = "Alex",custDescription = "wants to purchase " + quantity +" shirt";
        
        if(quantity > 1){
           custDescription = custDescription + "s"; 
        }
        total = quantity * price * tax;
        
        message = custName + " " + custDescription;
        if(outOfStock == false){
            System.out.println(message);
            System.out.println("Your total with tax is: " + total);
        }else{
            System.out.println("This item is unavailable");
        }
        
        String[] names = {"Bernard", "Bernard", "Norishia", "Tim", "Aboli"};
        
        for(String name: names){
            System.out.println("Awesome names::::"+name);
        }
    }
    
}

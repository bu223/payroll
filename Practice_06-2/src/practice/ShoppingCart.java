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
        Item item1 = new Item();
        Item item2 = new Item();

        item1.descr = "my shirt";
        item2.descr = "your shirt";
        
        item1 = item2;
        
        System.out.println("Item 1 is: "+item1.descr);
        System.out.println("Item 2 is: "+item2.descr);
    }

    private static class Item {
        private int id;                                 
        private String descr;
        private double price;
        private int quantity;                                       
        public Item() {
        }
    }
    
}

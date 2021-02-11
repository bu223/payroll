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
        String customerName = "Bernard Udu";
        String firstName;
        int spaceIdx;
        
        long l1 = 99_000_000_00L;
        float f1 = 13.7F;
        char c1 = 'U';
        
        Item it = new Item();
        
        it.setItemFields("These shirts", 3, 150);
        it.display();
        
        int res = it.setFields("More shirts ",4, 250, c1);
        if(res < 0){
            System.out.println("Invalid color code.");
        }else{
            it.display();
        }
        
        System.out.println("Long1 "+l1);
        int i1 = (int)l1;
        System.out.println("long assigned to int "+i1);
        spaceIdx = customerName.indexOf(" ");
        System.out.println(spaceIdx);
        
        firstName = customerName.substring(0, spaceIdx);
        System.out.println("First name is: "+firstName);
        
        StringBuilder sb = new StringBuilder(firstName);
        //System.out.println(sb.append(" Udu"));
        System.out.println(sb.append(customerName.substring(spaceIdx)));
        
        System.out.println(5/2.0);
        
    }
    
}

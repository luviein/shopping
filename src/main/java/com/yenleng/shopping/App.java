package com.yenleng.shopping;

import java.io.Console;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<String> shoppingList = new LinkedList<>(); // keep track of items in shopping card
        HashSet<String> set = new HashSet<>(); // ensure no duplicates
        //print welcome message
        System.out.println("Welcome to your shopping cart");


        //ask for user input
        Console cons = System.console();
  
        String input = "";
        while (!"stop".equals(input)){
            input = cons.readLine(">"); //puts > at user input

            if (input.equals("list")){
                if (shoppingList.size() == 0){ //cart is empty if size is 0
                    System.out.println("Cart is empty");
                }else{
                    for (int i = 1; i <= shoppingList.size(); i++){ //loops through list size to print 1. 2. 3.
                        System.out.println(i + ". " + shoppingList.get(i - 1));// -1 from get as index starts from zero
                    }
                }
            } else if (input.startsWith("add")) {
                
                String cmdValue = input.substring(3); //takes everything after 3
                String[] items = cmdValue.split(","); //splits by comma. pear ,orange, apple
                for (String item : items) {
                    item = item.trim(); //trims away any empty space if present
                    if (set.contains(item)){
                        System.out.println("You have " + item + " in your cart");
                    } else {
                        set.add(item);
                        shoppingList.add(item);
                        System.out.println(item + " added to cart");
                    }
                }
            } else if (input.startsWith("delete")) {
                String cmdValueStr = input.substring(6);//takes everything after 6
                int cmdValueInt = Integer.parseInt(cmdValueStr) - 1; //changes str to int, -1 to match the index
                if (cmdValueInt > shoppingList.size()-1 || cmdValueInt < 0){
                    System.out.println("Incorrect item index");
                }else{
                    String itemToDelete = shoppingList.remove(cmdValueInt);
                    set.remove(itemToDelete);
                }
            }
        }

    }
}

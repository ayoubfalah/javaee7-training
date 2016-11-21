package de.softunivers.javaee7.ebj.stateful;

import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author ayoubfalah
 */
@Model
public class CartClient
{
    @Inject
    Cart cart;
    
    public void shop()
    {
        // Adding the first item
        addItem("apple");
        // Adding the second item
        addItem("banana");
        // Adding the third item
        addItem("mango");
        
        // Removing the third item
        removeItem("banana");
        
        // Removing the second item
        removeItem("apple");
        
        // Removing the first item
        removeItem("mango");
    }
    
    public void addItem(String item)
    {
        cart.addItem(item);
        printItems();
    }
    
    public void removeItem(String item)
    {
        cart.removeItem(item);
        printItems();
    }

    private void printItems() 
    {
        List<String> cartItems = cart.getItems();
        System.out.println("---------- The items in the shopping cart: " );
        for (String cartItem : cartItems) 
        {
            System.out.println("----------++" + cartItem);
        }
    }
    
    
    
    
    
}

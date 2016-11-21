package de.softunivers.javaee7.ebj.stateful;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author ayoubfalah
 */
@Stateful
public class Cart 
{
    List<String> items;

    public Cart() 
    {
        items = new ArrayList<>();
    }

    public void addItem(String item)
    {
        items.add(item);
    }
    
    public void removeItem(String item)
    {
        items.remove(item);
    }
    
    public List<String> getItems()
    {
        return items;
    }
    
    public void purchase(){}
    
    @Remove
    public void remove()
    {
        items = null;
    }    
}

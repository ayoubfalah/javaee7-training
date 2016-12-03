package de.softunivers.javaee7.cdi;

import java.util.List;

/**
 *
 * @author ayoubfalah
 */
public class CustomersManager 
{
    private final CustomersProvider customerProvider;

    // According to the statement of Dependency Injection is it invalid to instantiate
    // the class CustomersProvider in the constructor of CustomersManager
    public CustomersManager() 
    {
        this.customerProvider = new CustomersProvider();
    }
    
    public List<String> getCustomersNames()
    {
        return customerProvider.getCustomersNames();
    }
    
    

}

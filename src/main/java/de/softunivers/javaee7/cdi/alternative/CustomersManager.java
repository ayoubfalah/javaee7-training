package de.softunivers.javaee7.cdi.alternative;

import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author ayoubfalah
 */
public class CustomersManager 
{
    @Inject
    private CustomersProvider customerProvider;
    
    public List<String> getCustomersNames()
    {
        return customerProvider.getCustomersNames();
    }
}
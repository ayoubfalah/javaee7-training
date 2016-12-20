
package de.softunivers.javaee7.cdi.producer_disposer;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ayoubfalah
 */
@Named
public class CustomersManager 
{
    @Inject 
    String[] customersNames;
    
    public String[] getCustomersNames()
    {
        return customersNames;
    }

}

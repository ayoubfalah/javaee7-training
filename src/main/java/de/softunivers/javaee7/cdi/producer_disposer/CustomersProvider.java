
package de.softunivers.javaee7.cdi.producer_disposer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.inject.Produces;

/**
 *
 * @author ayoubfalah
 */
public class CustomersProvider 
{
    @Produces
    public String[] getCustomersNames()
    {
        String[] customersNames = { "John Smith", "Franklin Wong", "Alicia Zelaya",
                    "Jennifer Wallace", "Ramesh Narayan", "Joyce English",
                    "Ahmed Jabbar", "James Borg"};
        
        return customersNames;
    }

}

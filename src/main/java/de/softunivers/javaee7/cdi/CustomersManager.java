package de.softunivers.javaee7.cdi;

import de.softunivers.javaee7.cdi.qualifiers.CurrentImpl;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author ayoubfalah
 */
public class CustomersManager 
{
    @Inject
    @CurrentImpl
    private CustomersProvider customerProvider;
    
    public List<String> getCustomersNames()
    {
        return customerProvider.getCustomersNames();
    }
}


package de.softunivers.javaee7.cdi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.inject.Vetoed;

/**
 *
 * @author ayoubfalah
 */
@Vetoed
public class ExtendedCustomersProvider extends CustomersProvider
{

    @Override
    public List<String> getCustomersNames()
    {
        ArrayList customernames = new ArrayList(Arrays.asList(
                new String[]{ "John Smith", "James Borg"}));
        
        return customernames;
    }
    

}

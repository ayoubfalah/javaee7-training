
package de.softunivers.javaee7.cdi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.Dependent;

/**
 *
 * @author ayoubfalah
 */
@Dependent
public class CustomersProvider 
{
    public List<String> getCustomersNames()
    {
        ArrayList customernames = new ArrayList(Arrays.asList(
                new String[]{ "John Smith", "Franklin Wong", "Alicia Zelaya",
                    "Jennifer Wallace", "Ramesh Narayan", "Joyce English",
                    "Ahmed Jabbar", "James Borg"}));
        
        return customernames;
    }

}

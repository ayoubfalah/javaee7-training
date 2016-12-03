
package de.softunivers.javaee7.cdi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ayoubfalah
 */
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

package de.softunivers.javaee7.cdi.alternative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;

/**
 *
 * @author ayoubfalah
 */
@Dependent
@Alternative
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

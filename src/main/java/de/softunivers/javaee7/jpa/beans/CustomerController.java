package de.softunivers.javaee7.jpa.beans;

import de.softunivers.javaee7.jpa.ejbs.CustomerFacade;
import de.softunivers.javaee7.jpa.entities.Customer;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ayoubfalah
 */
@Named(value = "customerController")
@SessionScoped
public class CustomerController implements Serializable
{
    @EJB
    CustomerFacade customerFacade;
    
    @Inject
    CustomerBean customerBean;
    
    // Select all customers in the DB
    public List<Customer> getAll()
    {
        return customerFacade.findAll();
    }
    
    // Delete a customer from the DB
    public String delete(Customer c)
    {
        customerFacade.remove(c);
        return null;
    }
    
    // Compute the number of customer in the DB
    public int count()
    {
        return customerFacade.count();
    }    
}

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
    
    // Insert a new customer to the DB
    public String add()
    {
        Customer customer = new Customer();
        customer.setCustno(customerBean.getCustNo());
        customer.setCustname(customerBean.getCustName());
        customer.setCity(customerBean.getCity());
        
        customerFacade.create(customer);
        
        return "index";
    }
    
    // Select all customers in the DB
    public List<Customer> getAll()
    {
        return customerFacade.findAll();
    }
    
    // Update a customer
    public String edit(Customer customer)
    {
        // TODO use the method edit directly
        //customerFacade.edit(c);
        customerBean.setCustNo(customer.getCustno());
        customerBean.setCustName(customer.getCustname());
        customerBean.setCity(customer.getCity());
        
        return "update";
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
    
    // Save a modification
    public String save()
    {
        System.out.println("######");
        Customer customer = new Customer(customerBean.getCustNo());
        customer.setCustname(customerBean.getCustName());
        customer.setCity(customerBean.getCity());
        
        customerFacade.edit(customer);
        
        return "index";        
    }
}

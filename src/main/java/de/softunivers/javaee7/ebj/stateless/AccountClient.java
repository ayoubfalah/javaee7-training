package de.softunivers.javaee7.ebj.stateless;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;

/**
 *
 * @author ayoubfalah
 */
@Model
public class AccountClient 
{
    @EJB
    Account account;
    
    public void update()
    {
        // Print the actual balance
        account.print();
        
        // Increasing the actual balance by amount
        account.deposit(2);
        account.print();
        
        // withdraw amount from the current balance
        account.withdraw(1);
        account.print();        
    }    
}

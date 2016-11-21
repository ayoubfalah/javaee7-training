package de.softunivers.javaee7.ebj.stateless;

import java.time.LocalDate;
import javax.ejb.Stateless;

/**
 *
 * @author ayoubfalah
 */
@Stateless
public class Account 
{
    
    private float balance = 0;
    
    public void withdraw(float amount)
    {
        balance -= amount;
    }
    
    public void deposit(float amount)
    {
        balance += amount;
    }
    
    public void print()
    {
        System.out.println("Your balance at " + LocalDate.now() 
                + " is " + balance);
    }
}

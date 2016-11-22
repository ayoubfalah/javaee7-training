package de.softunivers.javaee7.ebj.stateless;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nowDate = LocalDate.now();
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime nowTime = LocalTime.now();
        System.out.println("Your balance on the " + df.format(nowDate)
                + " at " + tf.format(nowTime) + " is " + balance);
    }
}

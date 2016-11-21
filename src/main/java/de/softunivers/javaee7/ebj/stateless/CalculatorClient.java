package de.softunivers.javaee7.ebj.stateless;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;

/**
 *
 * @author ayoubfalah
 */
@Model
public class CalculatorClient 
{
    @EJB
    Calculator calculator;
    
    public void compute()
    {
        int x = 3;
        int y = 2;
        
        System.out.println("The sum of " + x + " and " + y + ": "
                + calculator.add(x, y));
        
        System.out.println("The subtraction of " + x + " from " + y + ": "
                + calculator.substract(x, y));
        
        System.out.println("The multiplication of " + x + " with " + y + ": "
                + calculator.multiply(x, y));
        
        System.out.println("The division of " + x + " by " + y + ": "
                + calculator.divide(x, y));
    }    
}

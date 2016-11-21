package de.softunivers.javaee7.ebj.stateless;

import javax.ejb.Stateless;

/**
 *
 * @author ayoubfalah
 */
@Stateless
public class Calculator 
{
    public int add(int x, int y)
    {
        return x + y;
    }
    
    public int substract(int x, int y)
    {
        return x - y;
    }
    
    public int multiply(int x, int y)
    {
        return x * y;
    }
    
    /**
     * 
     * @param x an integer
     * @param y an integer
     * @precondition y != 0
     * @return 
     */
    public float divide(int x, int y)
    {
        return (float)x / y;
    }
    
}
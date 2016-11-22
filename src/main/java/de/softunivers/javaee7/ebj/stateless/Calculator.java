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
        return Math.addExact(x, y);
    }
    
    public int substract(int x, int y)
    {
        return Math.subtractExact(x, y);
    }
    
    public int multiply(int x, int y)
    {
        return Math.multiplyExact(x, y);
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
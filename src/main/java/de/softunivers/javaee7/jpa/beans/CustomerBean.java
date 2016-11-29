package de.softunivers.javaee7.jpa.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ayoubfalah
 */
@Named(value = "custBean")
@SessionScoped
@Getter
@Setter
class CustomerBean implements Serializable
{
    private int custNo;
    private String custName;
    private String city;    
}

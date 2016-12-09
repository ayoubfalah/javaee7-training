
package de.softunivers.javaee7.jaxrs.client;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ayoubfalah
 */
@Getter
@Setter
@Named
@RequestScoped
public class ItemBackingBean implements Serializable
{
    int itemno;
    String itemname;
    Float unitprice;
}

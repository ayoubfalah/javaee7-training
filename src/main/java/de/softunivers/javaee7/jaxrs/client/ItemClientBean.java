
package de.softunivers.javaee7.jaxrs.client;

import de.softunivers.javaee7.entities.Item;
import de.softunivers.javaee7.jaxrs.json.ItemWriter;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ayoubfalah
 */
@Named
@RequestScoped
public class ItemClientBean 
{
    Client client;
    WebTarget target;
    
    @Inject
    HttpServletRequest httpServletRequest;
    
    @Inject
    ItemBackingBean itemBackingBean;
    
    @PostConstruct
    public void init()
    {
        client = ClientBuilder.newClient();
        String uri = "http://"+ 
                    httpServletRequest.getLocalName() +
                    ":" +
                    httpServletRequest.getLocalPort() +
                    httpServletRequest.getContextPath() +
                    "/webresources/item/";
        target = client.target(uri);
    }
    
    public Item[] getItems()
    {
        Builder request = target.request();
        Item[] response = request.get(Item[].class);
        return response;
    }
    
    public Item getItem()
    {
        Item item = target
                .path("{item}")
                .resolveTemplate("item", itemBackingBean.getItemno())
                .request()
                .get(Item.class);
        return item;
    }
    
    public void addItem() 
    {
        Item item = new Item();
        item.setItemname(itemBackingBean.getItemname());
        item.setUnitprice(itemBackingBean.getUnitprice());
        target.register(ItemWriter.class)
                .request()
                .post(Entity.entity(item, MediaType.APPLICATION_JSON));
    }
    
    public void deleteItem()
    {
        target.path("{itemNo}")
              .resolveTemplate("itemNo", itemBackingBean.getItemno())
              .request().delete();
        
    }
    
    @PreDestroy
    public void destroy()
    {
        client.close();
    }
}


package de.softunivers.javaee7.jaxrs.client;

import de.softunivers.javaee7.entities.Item;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

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
    
    @PreDestroy
    public void destroy()
    {
        client.close();
    }

}

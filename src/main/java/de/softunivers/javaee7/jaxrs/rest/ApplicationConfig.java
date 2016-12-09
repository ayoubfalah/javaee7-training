
package de.softunivers.javaee7.jaxrs.rest;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author ayoubfalah
 */
@ApplicationPath("webresources") 
public class ApplicationConfig extends Application 
{

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(de.softunivers.javaee7.jaxrs.json.ItemReader.class);
        resources.add(de.softunivers.javaee7.jaxrs.json.ItemWriter.class);
        resources.add(de.softunivers.javaee7.jaxrs.rest.CustomerFacadeREST.class);
        resources.add(de.softunivers.javaee7.jaxrs.rest.ItemFacadeREST.class);
        resources.add(de.softunivers.javaee7.jaxrs.rest.PurchaseOrderFacadeREST.class);
        resources.add(de.softunivers.javaee7.jaxrs.rest.WarehouseFacadeREST.class);
    }

}

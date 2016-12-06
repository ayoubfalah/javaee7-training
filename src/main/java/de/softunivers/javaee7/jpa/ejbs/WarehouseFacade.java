package de.softunivers.javaee7.jpa.ejbs;

import de.softunivers.javaee7.entities.Warehouse;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ayoubfalah
 */
@Stateless
public class WarehouseFacade extends AbstractFacade<Warehouse> {

    @PersistenceContext(unitName = "orderPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WarehouseFacade() {
        super(Warehouse.class);
    }
    
}

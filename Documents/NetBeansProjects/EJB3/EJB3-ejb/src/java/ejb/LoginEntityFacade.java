/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aymeric
 */
@Stateless
public class LoginEntityFacade extends AbstractFacade<LoginEntity> {
    @PersistenceContext(unitName = "EJB3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoginEntityFacade() {
        super(LoginEntity.class);
    }
    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aymeric
 * invoque une named Querry pour verifier que le login et le password rentrés correspondent bien
 */
@Stateful
public class loginFacade extends AbstractFacade<login> {
    private long id;

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    @PersistenceContext(unitName = "projet_2.2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public loginFacade() {
        super(login.class);
    }
    /**parametre 1 : le login
     * parametre 2 : le password que l'on veut verifier
     *verifierlogin regarde le password et determine s'il correspond bien au login rentré retourne 0 si le password est juste
     *1 s'il ne l'est pas
     *et attribu l'id généré par l'entité qui restera en mémoire (EJB stateful)*/
    public int verifierlogin(String login,String password){
        String Password;
        Password = (String)em.createNamedQuery("verifierlogin").setParameter("login", login).getSingleResult();
        
        if(Password.equals(password)){
            long id=0;
        em.createNamedQuery("getid").setParameter("login", login).getSingleResult();
        this.setId(id);
            return 0;}
        else{return 1;}
        
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aymeric
 * utilise une namdequerry pour encoder en JSON l'ensemble des notes qui appartiennent à un parcours
 */
@Stateless
public class parcoursFacade extends AbstractFacade<parcours> {
    @PersistenceContext(unitName = "projet_2.2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public parcoursFacade() {
        super(parcours.class);
    }
    /**
     *parametre : l'id du parcours pour lequel on veut avoir la liste des notes
     * s'appuie sur les namedquerries pour récupérer cette liste des notes correspondants à un parcours, puis 
     * encode le tout en JSON 
     */
    public String getnoteparcours(String idparcours){
        String result="[";
        ArrayList<String> arrList=(ArrayList<String>) em.createNamedQuery("getnoteparcours").setParameter("idparcours", idparcours).getResultList();
        for(int i=1; i< arrList.size();i++){
            result+="[";
        result+=arrList.get(i);
        result+="],";
        }
        result+="]";
    return result;
    
    }
    
}

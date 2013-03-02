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
 * utilise une namedQuerry pour encoder l'ensemble des notes d'un utilisateur en JSON
 */
@Stateless
public class noteFacade extends AbstractFacade<note> {
    private loginFacade lo= new loginFacade();
    @PersistenceContext(unitName = "projet_2.2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public noteFacade() {
        super(note.class);
    }
    /**
     *cette méthode utilise les namedqueries pour determiner quelle sont les notes
     * qui appartienent à l'utilisateur, tous les parametres de ses notes sont encodé sous forme d'un
     * document JSON dans un String pour qu'il soit directement utilisable cote client
     */
    public String getnotes(){
        String result="[";
        ArrayList<String> arrList=(ArrayList<String>) em.createNamedQuery("getnotes").setParameter("id",lo.getId() ).getResultList();
        for(int i=1; i< arrList.size();i++){
            result+="[";
        result+=arrList.get(i);
        result+="],";
        }
        result+="]";
    return result;
    }
    
    
}

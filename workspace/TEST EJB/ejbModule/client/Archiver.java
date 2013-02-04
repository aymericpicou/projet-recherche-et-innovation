package client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless(name="archiver", mappedName="Archiver")
public class Archiver implements ArchiverRemote  {
    
    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("login");
    @PersistenceContext(unitName = "login")
   EntityManager stockage;
    
    
    
    
    public String enregistrer()  {
        //login log = new login("aymeric", "aymeric");
        //stockage.persist(log);
       // return log.getPassword();
    	return "hello you!!!";
    }
}
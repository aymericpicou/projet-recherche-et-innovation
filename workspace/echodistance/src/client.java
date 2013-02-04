import java.rmi.NotBoundException;
//import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class client{
public static void main(String[] args){
	try{
	int port=18500;
	Registry registry = LocateRegistry.getRegistry("192.168.56.1", port);//on se place sur le port 18500 de localhost
	//remoteecho echo=(remoteecho)registry.lookup("name");//on regarde ce qu'il y a sur ce port
	
	Annuaire annuaire=(Annuaire) registry.lookup("name");
	System.out.println(annuaire.test());//affiche la m�thode hello : on verifie que l'on a bien r�cup�r� l'objet
	annuaire.ajouterPersonne("Aymeric");
	annuaire.ajouterPersonne("julien");
	annuaire.ajouterPersonne("pierre");
	annuaire.ajouterPersonne("paul");
	annuaire.ajouterPersonne("jacques");
	System.out.println("1ere modification : \n"+annuaire.listePersonnes());
	
	System.out.println("on va modifier la liste :  on va enlever julien");
	annuaire.suppr("julien");
	System.out.println("voici la liste apr�s la deuxieme modification" + annuaire.listePersonnes());
	System.out.println("fin des modifications a priris le systeme s'est bien execut�");
	}
	catch(RemoteException e){
		System.out.println("probleme de remote");
		e.printStackTrace();
	} catch (NotBoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

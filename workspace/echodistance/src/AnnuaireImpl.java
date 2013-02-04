import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class AnnuaireImpl  extends UnicastRemoteObject implements Annuaire{

	ArrayList<String> Personnes;
	
	private static final long serialVersionUID = 1084121748989994034L;
	protected AnnuaireImpl() throws RemoteException {
		super();
		Personnes = new ArrayList<String>();
	}
	
	public String listePersonnes() throws RemoteException{
		String liste=" ";
		for(String personne : Personnes)
		{
			liste+= personne +"\n";
		}
		System.out.println("vous avez récuéré la liste des personnes");
		return liste;
	}
	public String recherchePersonnes(String nom) throws RemoteException{
		return "uhuhih";
	}
	public void ajouterPersonne (String nom)throws RemoteException{
		System.out.println("ajout de la personne :" + nom);
		Personnes.add(nom);
	}
	public String test() throws RemoteException{
		return "bonjour, juste pour verifier que le transfert se passe bien";
		
	}
	public void suppr(String nom)throws RemoteException{
		for(String personne : Personnes){
			if(personne.equalsIgnoreCase(nom)==true){
				Personnes.remove(personne);
			}
		}
	}
	
	
}

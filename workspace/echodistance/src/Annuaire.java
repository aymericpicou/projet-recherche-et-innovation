import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Annuaire extends Remote{
	String listePersonnes() throws RemoteException;
	String recherchePersonnes(String nom) throws RemoteException;
	void ajouterPersonne (String nom)throws RemoteException;
	String test() throws RemoteException;
	void suppr(String nom) throws RemoteException;
}

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class client{
public static void main(String[] args){
	try{
	int port=1088;
	Registry registry = LocateRegistry.getRegistry("localhost", port);
	remoteecho s=(remoteecho)registry.lookup("name");
	System.out.println(s.toString());
	System.out.println("ok");
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

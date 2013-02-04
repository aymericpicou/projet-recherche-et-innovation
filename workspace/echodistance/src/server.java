import java.rmi.RemoteException;
//import java.rmi.AccessException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
//import java.io.*;

public class server{
	public static void main(String[] args){
		Registry registry=null;
		try{
			int port=18500;

			registry=LocateRegistry.createRegistry(port);//création du registre
			
			/*RemoteEchoImpl R;
			R=new RemoteEchoImpl();//création de l'objet*/
			AnnuaireImpl A;
			A=new AnnuaireImpl();
			//System.out.println(R.toString());
			
			System.out.println(A.test());
			registry.rebind("name",A);//on met l'objet sur le port
			
		}catch(RemoteException e){
			e.printStackTrace();
		}catch(/*Access*/Exception e){
			e.printStackTrace();
		}
	}
}

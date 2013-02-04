import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.*;

public class server{
	public static void main(String[] args){
		try{
			int port=1088;
			RemoteEchoImpl R=new RemoteEchoImpl();
			System.out.println(R.toString());
			Registry registry=LocateRegistry.createRegistry(1088);
			registry.rebind("name",R);
			System.out.println("ca foire");
		}catch(RemoteException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

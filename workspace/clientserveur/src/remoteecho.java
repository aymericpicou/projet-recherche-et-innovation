import java.rmi.Remote;
import java.rmi.RemoteException;
public interface remoteecho extends Remote {
	String hello() throws RemoteException;
	String echo(String s) throws RemoteException;
	
	

}

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class RemoteEchoImpl extends UnicastRemoteObject implements remoteecho {
	private static final long serialVersionUID = 1L;
	protected RemoteEchoImpl()throws RemoteException{
		super();
	}
	public String hello()throws RemoteException{//implementation des methodes de remoteecho
		return "bonjour";
	}
	public String echo(String s)throws RemoteException{
		return "voici le message :" +s;
	}
}

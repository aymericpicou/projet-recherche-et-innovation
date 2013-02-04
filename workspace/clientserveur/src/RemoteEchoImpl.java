
public class RemoteEchoImpl implements remoteecho {
	public RemoteEchoImpl(){
		super();
	}
	public String hello(){
		return "bonjour";
	}
	public String echo(String s){
		return "voici le message :" +s;
	}
}

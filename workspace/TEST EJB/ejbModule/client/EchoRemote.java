package client;

import java.util.ArrayList;

import javax.ejb.Remote;

@Remote
public interface EchoRemote {//interface
	public String hello();
	public String echo(String string);
	public void login(String log);
	public ArrayList<String> getnote(int id);
}

package client;

import java.util.*;
import javax.naming.*;
import java.util.ArrayList;
public class Client {

public static void main(String[] args) {
	Properties ppt = null;
	Context ctx = null;
	EchoRemote bean = null;

try {
ppt = new Properties();
ppt.put(Context.PROVIDER_URL, "localhost:4848");
ctx = new InitialContext(ppt); 

	
	bean =(EchoRemote) ctx.lookup("LoginRemote");
bean.login("aymeric");
String result = bean.hello();
System.out.println(result);
result = bean.echo("billy jean");
System.out.println(result);
ArrayList<String> note=new ArrayList<String>();
note=bean.getnote(1);
System.out.println(note.get(0));
}
catch (Exception e) {
e.printStackTrace();
}
}
}

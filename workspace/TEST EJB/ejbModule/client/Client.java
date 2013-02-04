package client;

import javax.naming.InitialContext;


public class Client {
	public static void main(String[] args){
		try{
			String result;
			InitialContext ctx = new InitialContext();
			EchoRemote bean = (EchoRemote) ctx.lookup("LoginRemote");
			//System.out.println(" EJB stateful...");
			bean.login("aymeric");
			result = bean.hello();
			System.out.println(result);
			result = bean.echo("billy jean");
			System.out.println(result);

			ArchiverRemote A= (ArchiverRemote) ctx.lookup("Archiver");
			result=A.enregistrer();
			System.out.println(result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

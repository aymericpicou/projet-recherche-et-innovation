package client;

import javax.ejb.Stateless;
//import javax.ejb.Stateful;
import java.util.ArrayList;

@Stateless(name="Bonjour", mappedName="LoginRemote")
//@Stateful(description="blablaba", name="Bonjour", mappedName="LoginRemote")
public class EchoBean implements EchoRemote {
	String login=null;
	public void login(String log){
		login=log;
	}
	public String hello() {
		return "hello " + login;
	}
	
	public String echo(String string) {
		
		return "le parametre est :" + string;
	}
	public ArrayList<String> getnote(int id){
		ArrayList<note> notes=new ArrayList<note> ();
		notes.add( new note("saint pat","sweet!!!!","1"));
		notes.add( new note("saint pat","sweet!!!!","2"));
		notes.add( new note("saint pat","sweet!!!!","3"));
		
		ArrayList<String> lanote=new ArrayList<String>();
		lanote.add(notes.get(id).getLieu());
		lanote.add(notes.get(id).getDesc());
		lanote.add(notes.get(id).getId());
		return lanote;}//il faut transferer toutes les infos en  String,  

}

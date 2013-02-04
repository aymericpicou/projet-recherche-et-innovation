 package servlet;


import java.util.*;

import javax.naming.*;
//import relatifs à la servlet
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.EchoRemote;


public class projetservlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    
    /*declaration des objets servant au client des ejb*/
    private Properties ppt = null;
    private Context ctx = null;
    private EchoRemote bean = null;
    
    public projetservlet() {
          super();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        
        
    	try{
    	ppt = new Properties();
    	ppt.put(Context.PROVIDER_URL, "localhost:4848");
    	ctx = new InitialContext(ppt); 
    	bean =(EchoRemote) ctx.lookup("LoginRemote");
    	}
    	catch(NamingException e){
    		e.printStackTrace();    		
    	}
    	
    	
          response.setContentType("text/html");
          String type=request.getHeader("type");
          out.println("bienvenu dans le servlet version 2 ha");
          out.println("type de la requete get :"+ type);
          
          
          if(type.equals("getnote")){
              String id=request.getHeader("idnote");
          	out.println("l'id de la note demandée est : " + id);
          	bean.login("aym");
          	/*String s=bean.hello();
          	out.println(s);*/
          }
          if(type.equals("synch")){
          	out.println("synchronisation du serveur et de l'application...");
          }
          if(type.equals("login")){
          	String log=request.getHeader("login");
          	String pass=request.getHeader("pass");
          	out.println("voici le login de l'utilisateur :" + log);;
          	out.println("et son mot de passe est : " + pass);
          	
          }
          out.println("\n");
    }
}


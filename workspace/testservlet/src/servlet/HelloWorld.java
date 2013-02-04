package servlet;


//import relatifs à la servlet
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class HelloWorld extends HttpServlet{
      private static final long serialVersionUID = 1L;
 
      public HelloWorld() {
            super();
      }
 
      public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String type=request.getHeader("type");
            out.println("\n");
            out.println("type de la requete get :"+ type);
            if(type.equals("getnote")){
                String id=request.getHeader("idnote");
            	out.println("l'id de la note demandée est : " + id);
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

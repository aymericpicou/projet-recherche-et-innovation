/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.login;
import ejb.note;
import ejb.noteFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aymeric
 */
@WebServlet(name = "noteservlet", urlPatterns = {"/noteservlet"})
public class noteservlet extends HttpServlet {
@Resource(mappedName="jms/NewMessage3Factory")
    private  ConnectionFactory connectionFactory;

    @Resource(mappedName="jms/NewMessage3")
    private  Destination queue;
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * quand l'utilisateur fait un get la servlet va s'appuyer sur le service fourni par noteFacade pour 
     * qu'il lui retourne l'ensemble des notes de l'utilisateur le tout encodé en format JSON
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Connection connection = connectionFactory.createConnection();
                 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                 MessageProducer messageProducer = session.createProducer(queue);

                 ObjectMessage message = session.createObjectMessage();
                 noteFacade n=    new noteFacade();
                 String result=n.getnotes();
                 response.getWriter().write(result);
                               
        messageProducer.send(message);
        messageProducer.close();
        connection.close();
        } catch (JMSException ex) {
            Logger.getLogger(noteservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *Cette fonction va prendre les champs remplis dans la page de création des notes et va
     * remplir la base de données en utilisant les Set de l'entité note
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String titre=request.getParameter("titre");
    String comentaire=request.getParameter("commentaire");
    String adresse=request.getParameter("adresse");
    Connection connection = null;

                connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);

            ObjectMessage message = session.createObjectMessage();
            note e=new note();
            e.setTitre(titre);
            e.setAdresse(adresse);
            e.setCommentaire(comentaire);
            message.setObject(e);                
        messageProducer.send(message);
        messageProducer.close();
        connection.close();
        response.sendRedirect("mes_notes.html");
        } catch (JMSException ex) {
            Logger.getLogger(noteservlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

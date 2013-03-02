package web;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.noteFacade;
import ejb.parcours;
import ejb.parcoursFacade;
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
@WebServlet(name = "parcoursservlet", urlPatterns = {"/parcoursservlet"})
public class parcoursservlet extends HttpServlet {
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
     * recupere la valeur de l'identifiant du parcours pour s'appuyer sur les services de parcoursFacade
     * et ainsi récupérer un document JSON qui décrit l'ensemble des notes du parcours
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             String idparcours= (String)request.getParameter("idparcours");
            Connection connection = connectionFactory.createConnection();
                 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                 MessageProducer messageProducer = session.createProducer(queue);

                 ObjectMessage message = session.createObjectMessage();
                 parcoursFacade p=new parcoursFacade();
                 String result=p.getnoteparcours(idparcours);
                 response.getWriter().write(result);
                               
        messageProducer.send(message);
        messageProducer.close();
        connection.close();
        } catch (JMSException ex) {
            Logger.getLogger(noteservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * permet d'ajouter une note dans un parcours
     * pour cela, on se sert des Set de l'entité parcours pour creer la correspondance entre un parcours et des notes
     * voir d'une note avec plusieurs parcours  
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String idparcours=request.getParameter("idparcours");
            String idnote=request.getParameter("idnote");
            request.getParameter("idnote");
            Connection connection = connectionFactory.createConnection();
                     Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                     MessageProducer messageProducer = session.createProducer(queue);

                     ObjectMessage message = session.createObjectMessage();
                     parcours p=new parcours();
                     p.setIdparcours(idparcours);
                     p.setIdnote(idnote);
                     message.setObject(p);                
        messageProducer.send(message);
        messageProducer.close();
        connection.close();
        response.sendRedirect("mes_parcours.html");
        } catch (JMSException ex) {
            Logger.getLogger(parcoursservlet.class.getName()).log(Level.SEVERE, null, ex);
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

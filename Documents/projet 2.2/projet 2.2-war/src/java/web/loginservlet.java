/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.login;
import ejb.loginFacade;
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
@WebServlet(name = "loginservlet", urlPatterns = {"/loginservlet"})
public class loginservlet extends HttpServlet {
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
     
     * récupère les parametre password et login, et appelle la fonction verifierlogin de logininterface
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
String login=request.getParameter("login");
String password=request.getParameter("password");
if ((login!=null) && (password!=null)) {
    try {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(queue);

        ObjectMessage message = session.createObjectMessage();
        
        loginFacade e = new loginFacade();
        e.verifierlogin(login, password);

                       
        messageProducer.send(message);
        messageProducer.close();
        connection.close();
        response.sendRedirect("ListNews");

    } catch (JMSException ex) {
        ex.printStackTrace();
    }
}
    }   

    /**
     *récupère les valeur necessaire pour faire un autre utilisateur, et creer une ligne dans la table login
     * grace aux set.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login=request.getParameter("login");
String password=request.getParameter("password");
String pseudo=request.getParameter("pseudo");
String adresse=request.getParameter("adresse");
String code=request.getParameter("code");
if ((login!=null) && (password!=null)) {
    try {
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
        } catch (JMSException ex) {
            Logger.getLogger(noteservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(queue);

        ObjectMessage message = session.createObjectMessage();
        // here we create NewsEntity, that will be sent in JMS message
        login e = new login();
        e.setLogin(login);
        e.setPassword(password);
        e.setAdresse(adresse);
        e.setPseudo(pseudo);
        e.setCode(code);
        message.setObject(e);                
        messageProducer.send(message);
        messageProducer.close();
        connection.close();
        response.sendRedirect("mes_notes.html");

    } catch (JMSException ex) {
        ex.printStackTrace();
    }
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

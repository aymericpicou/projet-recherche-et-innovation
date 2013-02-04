/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsoap;

import java.io.IOException;
import java.net.MalformedURLException;
//import javax.xml.soap.soapexception;
import javax.xml.soap.*;

/**
 *
 * @author asmaabouanane
 */
public class ClientSoap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException, SOAPException {
        
        int result = 0;
        
        // TODO code application logic here
        
        
          try {
        int i = 3;
        int j = 4;
        result = add(i, j);
        System.out.println("Result = " + result);
    } catch (Exception ex) {
        System.out.println("Exception: " + ex);
    }
       
          
    
    
       System.out.println("resultat ecrit dans la requete Soap : "+requestSoap(result));
        
    }

    private static int add(int i, int j) {
        org.me.calculator.SoapWS_Service service = new org.me.calculator.SoapWS_Service();
        org.me.calculator.SoapWS port = service.getSoapWSPort();
        return port.add(i, j);
    }

    private static String hello(java.lang.String name) {
        org.me.calculator.SoapWS_Service service = new org.me.calculator.SoapWS_Service();
        org.me.calculator.SoapWS port = service.getSoapWSPort();
        return port.hello(name);
    }

    private static int requestSoap(int arg0) throws MalformedURLException_Exception, IOException_Exception, SOAPException_Exception {
        org.me.calculator.SoapWS_Service service = new org.me.calculator.SoapWS_Service();
        org.me.calculator.SoapWS port = service.getSoapWSPort();
        return arg0;
    }
    
    
    
    
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.calculator;

import java.io.IOException;
import java.net.MalformedURLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.soap.*;
import javax.xml.namespace.QName;
import java.util.Iterator;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author asmaabouanane
 */
@WebService(serviceName = "soapWS")
public class soapWS {

    /** This is a sample web service operation */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    
    @WebMethod(operationName = "requestSoap")
    public int requestSoap(int i) throws SOAPException, MalformedURLException, IOException{
   
        
                
                int result=-1;
                result=i;
                
                
                 SOAPConnectionFactory scf = SOAPConnectionFactory.newInstance();
                 SOAPConnection connection = scf.createConnection();
                 SOAPFactory sf = SOAPFactory.newInstance();
	      
	    
	         MessageFactory mf = MessageFactory.newInstance();
	         SOAPMessage message = mf.createMessage();
	    
	         
	         
	         SOAPPart soapPart = message.getSOAPPart();
	         SOAPEnvelope envelope = soapPart.getEnvelope();
	         SOAPBody body = envelope.getBody();
	      
                 QName bodyName = new QName("org.me.calculator","add", "ns2");
                 SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
   
	         
                 QName name = new QName("resultat");
	         SOAPElement isbn = bodyElement.addChildElement(name);
                 isbn.addTextNode("addition:"+ i );
                 
                 
                 //Message envoyé :
	         System.out.println("SOAP Request Sent:");
	         message.writeTo(System.out);
                 
             
              
	      
	         //informations générals à propos du message:
                 System.out.println(message.toString());
		  

 
                 
           
                 
      return  result;
              
    }
    
    
    
    
    @WebMethod(operationName = "add")
    public int add(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        //TODO write your implementation code here:
        
        int k = i + j;
        
        return k;
    }
    
    
    
}

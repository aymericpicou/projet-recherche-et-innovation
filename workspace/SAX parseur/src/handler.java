import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
 
 
public class handler extends DefaultHandler{
 
    protected String nomFichierXML;
    int cptTag = 0;
    String chaine=new String();
    boolean fintitre=true;
    boolean findate=true;
    boolean findesc=true;
    boolean b=false;
 
    /** Cree une nouvelle instance de Sax_Parser */
    public handler() {
        setNomFichierXML(null);
    }
    public handler(String nfx) {
        setNomFichierXML(nfx);
    }
 
    /** Methodes get et set */
    public String getNomFichierXML() { return nomFichierXML; }
    public void setNomFichierXML(String nfx) { nomFichierXML = nfx; }
 
    /** Methodes d'affichage */
    static protected void trace (String s) {
        System.out.println(s);
    }
    static protected void trace (String Comment, String s) {
        System.out.println(Comment + " : " + s);
    }
    static protected void trace (String s, int i) {
        System.out.println(s + " : " + i);
    }
 
    /** Methodes du ContentHandler */
    public void characters(char[] ch, int start, int length) throws SAXException 
    {
    	if(fintitre==true)
    	{
    		if(chaine.length()>0) trace(chaine);
    		chaine="";
        	if(findate==true)
        	{
        		if(chaine.length()>0) trace(chaine);
        		chaine="";
        		 if(findesc==true)
             	{
             		if(chaine.length()>0) trace(chaine);
             		chaine="";
             	}
             	if(findesc==false){
             		if(b==false){
             			trace("description:");
             			b=true;
             		}
                 chaine = chaine + new String(ch,start,length).trim();
                 }
        	}
        	if(findate==false){
        		if(b==false){
        			trace("date de publication:");
        			b=true;
        		}
            chaine = chaine + new String(ch,start,length).trim();
           
            }
    	}
    	if(fintitre==false){
    		if(cptTag==1 && b==false) {
    			trace("voici le titre :");
    			b=true;
    		}
    		if(cptTag==2 && b==false ){
    			trace("voici le titre du channel :");
    			b=true;
    		}
    		else if(b==false){
    			trace("titre du document n°"+ (cptTag-2)+ ":");
    			b=true;
    		}
        chaine = chaine + new String(ch,start,length).trim();
        }

    }
    public void startDocument() throws SAXException
    {
        trace("** Debut du document **");
    }
    public void endDocument() throws SAXException
    {
        trace("** Fin du document **");
    }
    public void startElement(java.lang.String uri, java.lang.String localName,java.lang.String qName,Attributes attr) throws SAXException
    {
    	if(qName=="title"){
    		fintitre=false;
    		b=false;
    		cptTag++;
    	}
    	if(qName=="pubDate"){
    		findate=false;
    		b=false;
    	}
    	if(qName=="description"){
    		findesc=false;
    		b=false;
    	}
    }
    public void endElement(java.lang.String uri, java.lang.String localName,java.lang.String qName) throws SAXException 
    {
    	if(qName=="title"){
    		fintitre=true;
        }
    	if(qName=="pubDate"){
    		findate=true;
        }
    	if(qName=="description"){
    		findesc=true;
    	}
    }

 
}
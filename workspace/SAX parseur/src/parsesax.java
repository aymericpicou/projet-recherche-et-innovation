
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.*;
 
public class parsesax {
 
    /** Creates a new instance of Applic_Analyse */
    public parsesax() {
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       handler sp = new handler(".\\src\\docny.xml");
       SAXParserFactory spf = SAXParserFactory.newInstance();
 
       try
       {
           System.out.println("Creation du parser");
           SAXParser parser = spf.newSAXParser();
           parser.parse(new File(sp.getNomFichierXML()),sp);//on associe le fichier au créateur d'evenement qui va permetre de parser
       }
       catch(ParserConfigurationException e)
       {
           System.out.println("Erreur de configuration du parser :" + e.getMessage());
       }
       catch(SAXException e)
       {
           System.out.println("Erreur SAX :" + e.getMessage());
       }
       catch(IOException e)
       {
           System.out.println("Erreur IO :" + e.getMessage());
       }
    }
 
}
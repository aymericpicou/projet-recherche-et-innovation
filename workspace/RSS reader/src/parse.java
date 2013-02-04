import javax.xml.parsers.*; 
import org.w3c.dom.*; 
import java.io.*; 
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class parse {
	
public article[] getLinks(String xhtmlUrl) throws Exception{

	try{
	
		DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
		fabrique.setValidating(true);
		
		DocumentBuilder constructeur = fabrique.newDocumentBuilder();
		
		URL url = new URL(xhtmlUrl);
		
		InputStream stream= url.openStream();//ouverture du flux
		
		
		
		Document document = constructeur.parse(stream);
		/*File xml = new File(".\\src\\docny.xml");
		Document document = (Document) constructeur.parse(xml);*/
		Element racine = document.getDocumentElement();//definition de l'élément racine
		
		
		String tag = "title";
		NodeList listetitle = racine.getElementsByTagName(tag);//trouver la liste des noeuds dont la balise est <title>

		tag = "pubDate";
		NodeList pubdate = racine.getElementsByTagName(tag);//trouver la liste des noeuds dont la balise est <pubdate>
		
		tag = "description";
		NodeList desc = racine.getElementsByTagName(tag);//trouver la liste des noeuds dont la balise est <description>
		
		tag = "link";
		NodeList Link = racine.getElementsByTagName(tag);//trouver la liste des noeuds dont la balise est <link>
		
		article[] tab=new article[listetitle.getLength()];
		tab[0]=new article(listetitle.item(0).getFirstChild().getNodeValue(),null,null,null);// article 0 : information sur le flux
		
		for(int i=2; i<listetitle.getLength(); i++){//on parcours les noeuds des differentes listes et on les stock dans un tableau d'article
			tab[i-1]=new article(listetitle.item(i).getFirstChild().getNodeValue(),this.GMTDateToFrench(pubdate.item(i-2).getFirstChild().getNodeValue()),desc.item(i-1).getFirstChild().getNodeValue(),Link.item(i).getFirstChild().getNodeValue());
		}
		return tab;
		
	}catch(IOException e){ 
	System.out.println("probleme de connexion"); 
	article[] tab= new article[2];
	tab[0]=new article("erreur 404","erreur 404","erreur 404","erreur 404");//s'il y a erreur de connexion, on affiche "erreur 404" à la place des informations
	tab[1]=new article("erreur 404","erreur 404","erreur 404","erreur 404");
	return tab;
	}
	catch(Exception e){

		throw e;
	}	
	
	
	}
public String GMTDateToFrench(String gmtDate) {//traduction des date en fancais
	try{
		SimpleDateFormat dfGMT = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
				dfGMT.parse(gmtDate);
				 SimpleDateFormat dfFrench = new SimpleDateFormat("EEEE, d MMMM yyyy HH:mm:ss", Locale.FRANCE);
				 return dfFrench.format(dfGMT.getCalendar().getTime());
				} catch (ParseException ex) {
			  
					System.out.println("erreur de conversion de la date");
			 }
			 return "";
				 }
}

	

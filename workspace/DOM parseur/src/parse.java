import javax.xml.parsers.*; 
import org.w3c.dom.*;  
import java.io.*; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class parse {
	public static void main(String[] args)throws Exception{
		parse p=new parse();
		p.getLinks();
		}
public  void getLinks() throws Exception{
	try{
	
		DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();//création de la fabrique
		fabrique.setValidating(true);
		
		DocumentBuilder constructeur = fabrique.newDocumentBuilder();//constructeur de document
		
		/*URL url = new URL(xhtmlUrl);
		stream = url.openStream();
		Document document = constructeur.parse(stream);*/
		File xml = new File(".\\src\\docny.xml");
		Document document = (Document) constructeur.parse(xml);
		Element racine = document.getDocumentElement();
		
		
		String tag = "title";
		NodeList listetitle = racine.getElementsByTagName(tag);
		System.out.println("voici le titre :" + listetitle.item(0).getFirstChild().getNodeValue());//recherche du titre et du titre du chanel
		System.out.println("voici le titre du channel :" + listetitle.item(1).getFirstChild().getNodeValue());
		
		tag = "lastBuildDate";
		NodeList lastbuilddate = racine.getElementsByTagName(tag);
		System.out.println("derniere publication :" + this.GMTDateToFrench(lastbuilddate.item(0).getFirstChild().getNodeValue()));//recherche de la date de la derniere publication
		
		tag = "pubDate";
		NodeList pubdate = racine.getElementsByTagName(tag);//recherche de la date de publication des articles -> création d'une liste de noeuds
		
		tag = "description";
		NodeList desc = racine.getElementsByTagName(tag);//recherche de la description-> création de la liste de noeuds
		
		for(int i=2; i<listetitle.getLength(); i++){
			System.out.println("article n°" + (i-1) + ": titre :" + listetitle.item(i).getFirstChild().getNodeValue());// affiche les differentes listes de noeuds sur la sortie standard
			System.out.println("date de publication :" + this.GMTDateToFrench(pubdate.item(i-2).getFirstChild().getNodeValue()));
			System.out.println("description :" + desc.item(i-1).getFirstChild().getNodeValue());
		}
	}catch(Exception e){
		throw e;
	}	
	
	}
public String GMTDateToFrench(String gmtDate) {
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

	

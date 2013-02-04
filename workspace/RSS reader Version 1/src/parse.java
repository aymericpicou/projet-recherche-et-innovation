import javax.xml.parsers.*; 
import org.w3c.dom.*; 
import org.xml.sax.*; 
import java.awt.List;
import java.io.*; 
import java.net.URL;
import java.util.*;

public class parse {
	
public article[] getLinks(String xhtmlUrl) throws Exception{

	try{
	
		DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
		fabrique.setValidating(true);
		
		DocumentBuilder constructeur = fabrique.newDocumentBuilder();
		
		/*URL url = new URL(xhtmlUrl);
		stream = url.openStream();
		Document document = constructeur.parse(stream);*/
		File xml = new File("C:\\Users\\aymeric\\workspace\\RSS reader\\src\\docny.xml");
		Document document = (Document) constructeur.parse(xml);
		Element racine = document.getDocumentElement();
		
		
		String tag = "title";
		NodeList listetitle = racine.getElementsByTagName(tag);
		//System.out.println("voici le titre :" + listetitle.item(0).getFirstChild().getNodeValue());
		//System.out.println("voici le titre du channel :" + listetitle.item(1).getFirstChild().getNodeValue());
		
		tag = "lastBuildDate";
		NodeList lastbuilddate = racine.getElementsByTagName(tag);
		//System.out.println("derniere publication :" + lastbuilddate.item(0).getFirstChild().getNodeValue());
		
		tag = "pubDate";
		NodeList pubdate = racine.getElementsByTagName(tag);
		
		tag = "description";
		NodeList desc = racine.getElementsByTagName(tag);
		article[] tab=new article[listetitle.getLength()];
		tab[0]=new article(listetitle.item(0).getFirstChild().getNodeValue(),null,null);
		for(int i=2; i<listetitle.getLength(); i++){
			/*System.out.println("article n°" + (i-1) + ": titre :" + listetitle.item(i).getFirstChild().getNodeValue());
			System.out.println("date de publication :" + pubdate.item(i-2).getFirstChild().getNodeValue());
			System.out.println("description :" + desc.item(i-1).getFirstChild().getNodeValue());*/
			tab[i-1]=new article(listetitle.item(i).getFirstChild().getNodeValue(),pubdate.item(i-2).getFirstChild().getNodeValue(),desc.item(i-1).getFirstChild().getNodeValue());
		}
		//System.out.println("voici le titre dans le tableau d'article :"+tab[0].gettitre());
		return tab;
	}catch(Exception e){
		throw e;
	}	
	
	}
}

	

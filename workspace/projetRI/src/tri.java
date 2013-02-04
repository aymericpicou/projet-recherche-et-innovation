
import java.io.*;
public class tri {
	public tri()
	{
		String fichier ="C:\\Users\\aymeric\\workspace\\projetRI\\src\\fichiertexte.txt";
		String chaine=ouvrir(fichier);
		System.out.println(chaine);
		
	}
	private String ouvrir(String fichier){
		String chaine="";

		
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				chaine+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		return chaine;
	}
}

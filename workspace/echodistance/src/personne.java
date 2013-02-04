
public class personne implements Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nom;
	String prenom;
	String adresse;
	public personne(String Prenom,String Nom){
		prenom=Prenom;
		nom=Nom;
	}
	public String getprenom(){
		return prenom;
	}
	public String getnom(){
		return nom;
	}
	public String getadresse(){
		return adresse;
	}
	
	
	
	
	
	public void setprenom(String Prenom){
		prenom=Prenom;
	}
	public void setnom(String Nom){
		nom=Nom;
	}
	public void setadresse(String Adresse){
		adresse=Adresse;
	}
	@Override
	public void person(String Prenom, String Nom) {
		// TODO Auto-generated method stub
		
	}
}

import java.io.Serializable;


public interface Person extends Serializable{
	
	public void person(String Prenom,String Nom);
	public String getnom();
	public String getprenom();
	public String getadresse();
	
	public void setnom(String nom);
	public void setprenom(String prenom);
	public void setadresse(String adresse);
}

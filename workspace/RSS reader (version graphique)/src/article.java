
public class article {// stock les informations d'un article : le titre, sa date de publication, ca description, et le lien vers l'article
	private String titre;
	private String date;
	private String description;
	private String link;
	public article(){
		this.titre=null;
		this.date=null;
		this.description=null;
		this.link=null;
	}
	public article (String Titre,String Date,String Description, String Auteur){
		this.titre=Titre;
		this.date=Date;
		this.description=Description;
		this.link=Auteur;
	}
	public String gettitre(){
		return this.titre;
	}
	public String getdate(){
		return this.date;
	}
	public String getdescription(){
		return this.description;
	}
	public String getlink(){
		return this.link;
	}
}

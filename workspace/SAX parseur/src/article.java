
public class article {
	private String titre;
	private String date;
	private String description;
	public article(){
		this.titre=null;
		this.date=null;
		this.description=null;
	}
	public article (String Titre,String Date,String Description){
		this.titre=Titre;
		this.date=Date;
		this.description=Description;
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
}

package client;
import java.util.Vector;

public class annuaire {
	private Vector<personne> Personnes=new Vector<personne>();
	public void ajouterpersonne(String nom,String prenom,String mdp, String notes){
		personne P=new personne();
		P.setNom(nom);
		P.setPrenom(prenom);
		P.setMdp(mdp);
		P.setNotes(null);//on creer une personne en initialisant tous ses champs
		Personnes.add(P);//puis on ajoute cette personne à la liste
		
	}
	public void chargerannuaire(){
		//inserer le code permettant de mettre en memoire l'annuaire
	}
	
	
	
}

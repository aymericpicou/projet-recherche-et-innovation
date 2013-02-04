package client;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import org.apache.openjpa.persistence.*;

/**
 * Entity implementation class for Entity: login
 *
 */
@Entity

public class login implements Serializable {

	
	private String nom;   
	@GeneratedValue
	@Id
	private Integer id;
	private static final long serialVersionUID = 1L;

	public login() {
		super();
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
   
}

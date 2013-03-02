/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author aymeric
 * decrit la structure de la table note : 6 parametres : id titre commentaire adresse iduser idparcours
 */
@Entity
@NamedQueries({
    @NamedQuery(name="getnotes", query="select * from note n where n.iduser=:id"),
    //@NamedQuery(name="getid",query="SELECT l.id from login l where l.login=:login"),
})
public class note implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titre;
    private String commentaire;
    private String adresse;
    private long iduser;
    private long idparcours;

    public long getIdparcours() {
        return idparcours;
    }

    public void setIdparcours(long idparcours) {
        this.idparcours = idparcours;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof note)) {
            return false;
        }
        note other = (note) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.note[ id=" + id + " ]";
    }
    
}

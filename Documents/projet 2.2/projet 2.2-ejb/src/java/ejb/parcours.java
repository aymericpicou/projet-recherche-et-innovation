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
 * decrit la structure de la table parcours : deux champs : idparcours et idnote 
 */
@Entity
@NamedQueries({
    @NamedQuery(name="getnoteparcours", query="select p.idnote from parcours p where p.idparcours=:idparcours"),
    //@NamedQuery(name="getid",query="SELECT l.id from login l where l.login=:login"),
})
public class parcours implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idparcours;
    private String idnote;

    public String getIdparcours() {
        return idparcours;
    }

    public void setIdparcours(String idparcours) {
        this.idparcours = idparcours;
    }

    public String getIdnote() {
        return idnote;
    }

    public void setIdnote(String idnote) {
        this.idnote = idnote;
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
        if (!(object instanceof parcours)) {
            return false;
        }
        parcours other = (parcours) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.parcours[ id=" + id + " ]";
    }
    
}

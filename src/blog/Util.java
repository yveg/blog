/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author admin
 */
@Entity
public class Util implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*@OneToOne(mappedBy = "utilisateur")
    private List<Numsecu> numerosecu = new ArrayList<>();
    */
    @OneToMany(mappedBy = "utilisateur")
    private List<Page> pages = new ArrayList<>();
    
    @OneToMany(mappedBy = "utilisateur")
    private List<Article> articles = new ArrayList<>();
    
    @OneToMany(mappedBy = "utilisateur")
    private List<Commentaire> commmentaires = new ArrayList<>();
    
    @OneToMany(mappedBy = "expediteur")
    private List<Message> messagesE = new ArrayList<>();
    
    @ManyToMany(mappedBy = "destinataire") //jointure avec table commande
    private List<Message> messages =new  ArrayList<>();
    
    
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
        if (!(object instanceof Util)) {
            return false;
        }
        Util other = (Util) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "blog.Util[ id=" + id + " ]";
    }
    
}

package domaine;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vente {
    private int id;
    private Date dateVente;
    private int quantite;
    private Produit produit;
    private Utilisateur utilisateur;
    
    // Constructors
    public Vente() {}
    
    public Vente(int id, Date dateVente, int quantite, Produit produit, Utilisateur utilisateur) {
        this.id = id;
        this.dateVente = dateVente;
        this.quantite = quantite;
        this.produit = produit;
        this.utilisateur = utilisateur;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Date getDateVente() {
        return dateVente;
    }
    
    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }
    
    public int getQuantite() {
        return quantite;
    }
    
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public Produit getProduit() {
        return produit;
    }
    
    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
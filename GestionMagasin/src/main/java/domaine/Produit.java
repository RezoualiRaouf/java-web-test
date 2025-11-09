package domaine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produit {
    private int id;
    private String code;
    private String designation;
    private int quantite;
    private double prix;
    private Fournisseur fournisseur;
    private Categorie categorie;
    
    // Constructors
    public Produit() {}
    
    public Produit(int id, String code, String designation, int quantite, 
                   double prix, Fournisseur fournisseur, Categorie categorie) {
        this.id = id;
        this.code = code;
        this.designation = designation;
        this.quantite = quantite;
        this.prix = prix;
        this.fournisseur = fournisseur;
        this.categorie = categorie;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public int getQuantite() {
        return quantite;
    }
    
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public double getPrix() {
        return prix;
    }
    
    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public Fournisseur getFournisseur() {
        return fournisseur;
    }
    
    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
    
    public Categorie getCategorie() {
        return categorie;
    }
    
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
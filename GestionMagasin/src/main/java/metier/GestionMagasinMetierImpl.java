package metier;

import domaine.*;
import java.util.*;

public class GestionMagasinMetierImpl implements GestionMagasinMetier {
    
    // Simulated database
    private static Map<Integer, Produit> produits = new HashMap<>();
    private static Map<Integer, Categorie> categories = new HashMap<>();
    private static Map<Integer, Fournisseur> fournisseurs = new HashMap<>();
    private static Map<Integer, Vente> ventes = new HashMap<>();
    private static int nextProduitId = 1;
    private static int nextVenteId = 1;
    
    // Initialize with sample data
    static {
        // Categories
        categories.put(1, new Categorie(1, "CAT001", "Électronique"));
        categories.put(2, new Categorie(2, "CAT002", "Informatique"));
        categories.put(3, new Categorie(3, "CAT003", "Accessoires"));
        
        // Fournisseurs
        fournisseurs.put(1, new Fournisseur(1, "F001", "Tech Supplies SA"));
        fournisseurs.put(2, new Fournisseur(2, "F002", "Global Electronics"));
        fournisseurs.put(3, new Fournisseur(3, "F003", "Computer World"));
        
        // Produits
        Produit p1 = new Produit(1, "P001", "Laptop Dell", 10, 1500.0, 
                                fournisseurs.get(1), categories.get(2));
        Produit p2 = new Produit(2, "P002", "Souris Logitech", 50, 25.0, 
                                fournisseurs.get(2), categories.get(3));
        Produit p3 = new Produit(3, "P003", "Clavier Mécanique", 30, 75.0, 
                                fournisseurs.get(1), categories.get(3));
        
        produits.put(1, p1);
        produits.put(2, p2);
        produits.put(3, p3);
        nextProduitId = 4;
        
        // Ventes
        Utilisateur user = new Utilisateur(1, "Dupont", "Jean", "jdupont", "pass123");
        ventes.put(1, new Vente(1, new Date(), 2, p1, user));
        ventes.put(2, new Vente(2, new Date(), 5, p2, user));
        nextVenteId = 3;
    }
    
    @Override
    public Produit ajouterProduit(int id, String code, String designation, 
                                  int quantite, double prix, int idFournisseur, int idCategorie) {
        Fournisseur fournisseur = fournisseurs.get(idFournisseur);
        Categorie categorie = categories.get(idCategorie);
        
        if (fournisseur == null || categorie == null) {
            throw new RuntimeException("Fournisseur ou Catégorie introuvable");
        }
        
        int newId = (id > 0) ? id : nextProduitId++;
        Produit produit = new Produit(newId, code, designation, quantite, prix, 
                                     fournisseur, categorie);
        produits.put(newId, produit);
        return produit;
    }
    
    @Override
    public boolean supprimerProduit(int idProduit) {
        if (produits.containsKey(idProduit)) {
            produits.remove(idProduit);
            return true;
        }
        return false;
    }
    
    @Override
    public Produit modifierProduit(Produit p) {
        if (produits.containsKey(p.getId())) {
            produits.put(p.getId(), p);
            return p;
        }
        return null;
    }
    
    @Override
    public Produit getProduit(int idProduit) {
        return produits.get(idProduit);
    }
    
    @Override
    public List<Produit> getAllProduits() {
        return new ArrayList<>(produits.values());
    }
    
    @Override
    public List<Vente> getAllVentes() {
        return new ArrayList<>(ventes.values());
    }
    
    @Override
    public List<Produit> listeProduitsParFournisseur(int idFournisseur) {
        // WITHOUT LAMBDA - Using traditional for loop
        List<Produit> result = new ArrayList<>();
        for (Produit p : produits.values()) {
            if (p.getFournisseur() != null && p.getFournisseur().getId() == idFournisseur) {
                result.add(p);
            }
        }
        return result;
    }
    
    @Override
    public Produit modifierCategorieProduit(int idProduit, int idCategorie) {
        Produit produit = produits.get(idProduit);
        Categorie categorie = categories.get(idCategorie);
        
        if (produit != null && categorie != null) {
            produit.setCategorie(categorie);
            return produit;
        }
        return null;
    }
    
    @Override
    public int getQuantiteVendue(int idProduit) {
        // WITHOUT LAMBDA - Using traditional for loop
        int totalQuantite = 0;
        for (Vente v : ventes.values()) {
            if (v.getProduit() != null && v.getProduit().getId() == idProduit) {
                totalQuantite += v.getQuantite();
            }
        }
        return totalQuantite;
    }
}
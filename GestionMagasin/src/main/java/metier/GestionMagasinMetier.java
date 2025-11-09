package metier;

import domaine.Produit;
import domaine.Vente;
import java.util.List;

public interface GestionMagasinMetier {
    Produit ajouterProduit(int id, String code, String designation, 
                          int quantite, double prix, int idFournisseur, int idCategorie);
    boolean supprimerProduit(int idProduit);
    Produit modifierProduit(Produit p);
    Produit getProduit(int idProduit);
    List<Produit> getAllProduits();
    List<Vente> getAllVentes();
    List<Produit> listeProduitsParFournisseur(int idFournisseur);
    Produit modifierCategorieProduit(int idProduit, int idCategorie);
    int getQuantiteVendue(int idProduit);
}
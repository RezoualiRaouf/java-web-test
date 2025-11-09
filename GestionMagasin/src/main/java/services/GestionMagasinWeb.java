package services;

import domaine.Produit;
import java.util.List;

public interface GestionMagasinWeb {
    Produit ajouterProduit(Produit p);
    String supprimerProduit(Produit p);
    Produit modifierCategorieProduit(int idProduit, int idCategorie);
    List<Produit> listeProduitsParFournisseur(int idFournisseur);
    int getQuantiteVendue(int idProduit);
}
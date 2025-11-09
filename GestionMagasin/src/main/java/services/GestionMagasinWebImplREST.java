package services;

import domaine.Produit;
import metier.GestionMagasinMetier;
import metier.GestionMagasinMetierImpl;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/produits")
public class GestionMagasinWebImplREST implements GestionMagasinWeb {
    
    private GestionMagasinMetier metier;
    
    public GestionMagasinWebImplREST() {
        this.metier = new GestionMagasinMetierImpl();
    }
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Produit ajouterProduit(Produit p) {
        return metier.ajouterProduit(
            p.getId(),
            p.getCode(),
            p.getDesignation(),
            p.getQuantite(),
            p.getPrix(),
            p.getFournisseur().getId(),
            p.getCategorie().getId()
        );
    }
    
    @DELETE
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String supprimerProduit(Produit p) {
        boolean resultat = metier.supprimerProduit(p.getId());
        if (resultat) {
            return "{\"message\":\"Produit supprimé avec succès\"}";
        } else {
            return "{\"message\":\"Échec de suppression du produit\"}";
        }
    }
    
    @PUT
    @Path("/update/{idP}/{idC}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Produit modifierCategorieProduit(
            @PathParam("idP") int idProduit,
            @PathParam("idC") int idCategorie) {
        return metier.modifierCategorieProduit(idProduit, idCategorie);
    }
    
    @GET
    @Path("/fournisseur/{idF}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Produit> listeProduitsParFournisseur(
            @PathParam("idF") int idFournisseur) {
        return metier.listeProduitsParFournisseur(idFournisseur);
    }
    
    @GET
    @Path("/quantite/{idP}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public int getQuantiteVendue(@PathParam("idP") int idProduit) {
        return metier.getQuantiteVendue(idProduit);
    }
    
    // Bonus: Get all products
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produit> getAllProduits() {
        return metier.getAllProduits();
    }
}
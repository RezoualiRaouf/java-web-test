package services;

import domaine.Produit;
import metier.GestionMagasinMetier;
import metier.GestionMagasinMetierImpl;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "gm")
public class GestionMagasinWebSOAPImpl implements GestionMagasinWeb {
    
    private GestionMagasinMetier metier;
    
    public GestionMagasinWebSOAPImpl() {
        this.metier = new GestionMagasinMetierImpl();
    }
    
    @WebMethod(operationName = "add")
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
    
    @WebMethod(exclude = true)
    @Override
    public String supprimerProduit(Produit p) {
        boolean resultat = metier.supprimerProduit(p.getId());
        return resultat ? "Succès" : "Échec";
    }
    
    @WebMethod(exclude = true)
    @Override
    public Produit modifierCategorieProduit(int idProduit, int idCategorie) {
        return metier.modifierCategorieProduit(idProduit, idCategorie);
    }
    
    @WebMethod(operationName = "getALLProductsByProvider")
    @Override
    public List<Produit> listeProduitsParFournisseur(
            @WebParam(name = "id") int idFournisseur) {
        return metier.listeProduitsParFournisseur(idFournisseur);
    }
    
    @WebMethod(exclude = true)
    @Override
    public int getQuantiteVendue(int idProduit) {
        return metier.getQuantiteVendue(idProduit);
    }
}
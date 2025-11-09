package domaine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Fournisseur {

    private int id;
    private String code;
    private String raisonSociale;

    // Constructors
    public Fournisseur() {
    }

    public Fournisseur(int id, String code, String raisonSociale) {
        this.id = id;
        this.code = code;
        this.raisonSociale = raisonSociale;
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

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }
}

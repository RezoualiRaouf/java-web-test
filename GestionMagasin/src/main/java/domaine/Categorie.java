package domaine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Categorie {

    private int id;
    private String code;
    private String designation;

    // Constructors
    public Categorie() {
    }

    public Categorie(int id, String code, String designation) {
        this.id = id;
        this.code = code;
        this.designation = designation;
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
}

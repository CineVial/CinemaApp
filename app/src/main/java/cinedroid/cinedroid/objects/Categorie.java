package cinedroid.cinedroid.objects;

import org.json.JSONObject;

import java.io.Serializable;

public class Categorie implements Serializable {
    private String codeCat;
    private String libelleCat;

    public Categorie(){

    }

    public Categorie(JSONObject jsonRea) {
        this.codeCat = jsonRea.optString("codeCat");
        this.libelleCat = jsonRea.optString("libelleCat");
    }

    public String getCodeCat() {
        return codeCat;
    }

    public void setCodeCat(String codeCat) {
        this.codeCat = codeCat;
    }

    public String getLibelleCat() {
        return libelleCat;
    }

    public void setLibelleCat(String libelleCat) {
        this.libelleCat = libelleCat;
    }
}

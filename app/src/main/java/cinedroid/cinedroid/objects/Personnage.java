package cinedroid.cinedroid.objects;

import org.json.JSONObject;

import java.io.Serializable;

public class Personnage implements Serializable {
    private Integer noFilm;
    private Integer noAct;
    private String nomPers;

    public Personnage(){

    }

    public Personnage(JSONObject jsonRea) {
        this.noFilm = jsonRea.optInt("noFilm");
        this.noAct = jsonRea.optInt("noAct");
        this.nomPers = jsonRea.optString("nomPers");
    }

    public Integer getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(Integer noFilm) {
        this.noFilm = noFilm;
    }

    public Integer getNoAct() {
        return noAct;
    }

    public void setNoAct(Integer noAct) {
        this.noAct = noAct;
    }

    public String getNomPers() {
        return nomPers;
    }

    public void setNomPers(String nomPers) {
        this.nomPers = nomPers;
    }
}

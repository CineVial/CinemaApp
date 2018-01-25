package cinedroid.cinedroid.objects;

import org.json.JSONObject;

import java.io.Serializable;

public class Film implements Serializable {

    private Integer noFilm;
    private String titre;
    private Integer duree;
    private String dateSortie;
    private Integer budget;
    private Integer montantRecette;
    private Integer noRea;
    private String codeCat;


    public Film() {

    }

    public Film(JSONObject jsonFilm) {
        this.noFilm = jsonFilm.optInt("noFilm");
        this.titre = jsonFilm.optString("titre");
        this.duree = jsonFilm.optInt("duree");
        this.dateSortie = jsonFilm.optString("dateSortie");
        this.budget = jsonFilm.optInt("budget");
        this.montantRecette = jsonFilm.optInt("montantRecette");
        this.noRea = jsonFilm.optInt("noRea");
        this.codeCat = jsonFilm.optString("codeCat");

    }

    public Integer getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(Integer noFilm) {
        this.noFilm = noFilm;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getMontantRecette() {
        return montantRecette;
    }

    public void setMontantRecette(Integer montantRecette) {
        this.montantRecette = montantRecette;
    }

    public Integer getNoRea() {
        return noRea;
    }

    public void setNoRea(Integer noRea) {
        this.noRea = noRea;
    }

    public String getCodeCat() {
        return codeCat;
    }

    public void setCodeCat(String codeCat) {
        this.codeCat = codeCat;
    }
}


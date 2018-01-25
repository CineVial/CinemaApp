package cinedroid.cinedroid.objects;

import org.json.JSONObject;

import java.io.Serializable;

public class Acteur implements Serializable {
    private String noAct;
    private String nomAct;
    private String prenAct;
    private String dateNaiss;
    private String dateDeces;

    public Acteur(){

    }

    public Acteur(JSONObject jsonRea) {
        this.noAct = jsonRea.optString("noAct");
        this.nomAct = jsonRea.optString("nomAct");
        this.prenAct = jsonRea.optString("prenAct");
        this.dateNaiss = jsonRea.optString("dateNaiss");
        this.dateDeces = jsonRea.optString("dateDeces");
    }

    public String getNoAct() {
        return noAct;
    }

    public void setNoAct(String noAct) {
        this.noAct = noAct;
    }

    public String getNomAct() {
        return nomAct;
    }

    public void setNomAct(String nomAct) {
        this.nomAct = nomAct;
    }

    public String getPrenAct() {
        return prenAct;
    }

    public void setPrenAct(String prenAct) {
        this.prenAct = prenAct;
    }

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(String dateDeces) {
        this.dateDeces = dateDeces;
    }
}

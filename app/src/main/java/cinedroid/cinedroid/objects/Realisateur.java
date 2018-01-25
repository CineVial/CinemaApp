package cinedroid.cinedroid.objects;

import org.json.JSONObject;

import java.io.Serializable;

public class Realisateur implements Serializable {
    private int noRea;
    private String nomRea;
    private String prenRea;

    public Realisateur(){

    }

    public Realisateur(JSONObject jsonRea) {
        this.noRea = jsonRea.optInt("noRea");
        this.nomRea = jsonRea.optString("nomRea");
        this.prenRea = jsonRea.optString("prenRea");
    }

    public int getNoRea() {
        return noRea;
    }

    public void setNoRea(int noRea) {
        this.noRea = noRea;
    }

    public String getNomRea() {
        return nomRea;
    }

    public void setNomRea(String nomRea) {
        this.nomRea = nomRea;
    }

    public String getPrenRea() {
        return prenRea;
    }

    public void setPrenRea(String prenRea) {
        this.prenRea = prenRea;
    }
}

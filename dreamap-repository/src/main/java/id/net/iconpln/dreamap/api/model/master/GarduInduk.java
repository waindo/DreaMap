package id.net.iconpln.dreamap.api.model.master;

import java.io.Serializable;

/**
 * Created by UwieSilent on 1/16/2015.
 */
public class GarduInduk implements Serializable {

    private String idFGI;
    private String kdPemilik;
    private String kdPengelola;
    private String tingkatResiko;
    private String namaGI;
    private String namaSingkatan;
    private float x;
    private float y;

    public String getIdFGI() {
        return idFGI;
    }

    public void setIdFGI(String idFGI) {
        this.idFGI = idFGI;
    }

    public String getKdPemilik() {
        return kdPemilik;
    }

    public void setKdPemilik(String kdPemilik) {
        this.kdPemilik = kdPemilik;
    }

    public String getKdPengelola() {
        return kdPengelola;
    }

    public void setKdPengelola(String kdPengelola) {
        this.kdPengelola = kdPengelola;
    }

    public String getTingkatResiko() {
        return tingkatResiko;
    }

    public void setTingkatResiko(String tingkatResiko) {
        this.tingkatResiko = tingkatResiko;
    }

    public String getNamaGI() {
        return namaGI;
    }

    public void setNamaGI(String namaGI) {
        this.namaGI = namaGI;
    }

    public String getNamaSingkatan() {
        return namaSingkatan;
    }

    public void setNamaSingkatan(String namaSingkatan) {
        this.namaSingkatan = namaSingkatan;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}

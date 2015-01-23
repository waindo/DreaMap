package id.net.iconpln.dreamap.api.model.master;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by UwieSilent on 1/16/2015.
 */
public class BangunanSipilGardu implements Serializable {

    private String idBangunanGardu;
    private String idJTM;
    private String kodePeralatan;
    private String kdPemilik;
    private String kdPengelola;
    private String kodeKonstruksi;
    private String tingkatResiko;
    private int jumlahTrafo;
    private String status;
    private Date tglPasang;
    private Date tglOperasi;
    private int umurEkonomis;
    private int umurManfaat;
    private float nilaiPerolehan;
    private float nilaiBuku;
    private String noBangunanGardu;
    private String typeGardu;
    private String typeBangunanGardu;
    private float x;
    private float y;

    public String getIdBangunanGardu() {
        return idBangunanGardu;
    }

    public void setIdBangunanGardu(String idBangunanGardu) {
        this.idBangunanGardu = idBangunanGardu;
    }

    public String getIdJTM() {
        return idJTM;
    }

    public void setIdJTM(String idJTM) {
        this.idJTM = idJTM;
    }

    public String getKodePeralatan() {
        return kodePeralatan;
    }

    public void setKodePeralatan(String kodePeralatan) {
        this.kodePeralatan = kodePeralatan;
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

    public String getKodeKonstruksi() {
        return kodeKonstruksi;
    }

    public void setKodeKonstruksi(String kodeKonstruksi) {
        this.kodeKonstruksi = kodeKonstruksi;
    }

    public String getTingkatResiko() {
        return tingkatResiko;
    }

    public void setTingkatResiko(String tingkatResiko) {
        this.tingkatResiko = tingkatResiko;
    }

    public int getJumlahTrafo() {
        return jumlahTrafo;
    }

    public void setJumlahTrafo(int jumlahTrafo) {
        this.jumlahTrafo = jumlahTrafo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTglPasang() {
        return tglPasang;
    }

    public void setTglPasang(Date tglPasang) {
        this.tglPasang = tglPasang;
    }

    public Date getTglOperasi() {
        return tglOperasi;
    }

    public void setTglOperasi(Date tglOperasi) {
        this.tglOperasi = tglOperasi;
    }

    public int getUmurEkonomis() {
        return umurEkonomis;
    }

    public void setUmurEkonomis(int umurEkonomis) {
        this.umurEkonomis = umurEkonomis;
    }

    public int getUmurManfaat() {
        return umurManfaat;
    }

    public void setUmurManfaat(int umurManfaat) {
        this.umurManfaat = umurManfaat;
    }

    public float getNilaiPerolehan() {
        return nilaiPerolehan;
    }

    public void setNilaiPerolehan(float nilaiPerolehan) {
        this.nilaiPerolehan = nilaiPerolehan;
    }

    public float getNilaiBuku() {
        return nilaiBuku;
    }

    public void setNilaiBuku(float nilaiBuku) {
        this.nilaiBuku = nilaiBuku;
    }

    public String getNoBangunanGardu() {
        return noBangunanGardu;
    }

    public void setNoBangunanGardu(String noBangunanGardu) {
        this.noBangunanGardu = noBangunanGardu;
    }

    public String getTypeGardu() {
        return typeGardu;
    }

    public void setTypeGardu(String typeGardu) {
        this.typeGardu = typeGardu;
    }

    public String getTypeBangunanGardu() {
        return typeBangunanGardu;
    }

    public void setTypeBangunanGardu(String typeBangunanGardu) {
        this.typeBangunanGardu = typeBangunanGardu;
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

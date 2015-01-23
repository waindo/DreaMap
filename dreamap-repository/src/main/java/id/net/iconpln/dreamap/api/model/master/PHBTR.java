package id.net.iconpln.dreamap.api.model.master;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by UwieSilent on 1/19/2015.
 */
public class PHBTR implements Serializable {

    private String idPHBTR;
    private String idKelas;
    private String lokasiPenempatan;
    private String kdPemilik;
    private String kdPengelola;
    private String kodeResiko;
    private String kodePeralatan;
    private String merk;
    private String type;
    private String jenisPemutus;
    private String status;
    private Date tglPasang;
    private Date tglOperasi;
    private int nilaiPerolehan;
    private int nilaiBuku;
    private int umurEkonomis;
    private int umurManfaat;
    private float shapeArea;

    public String getIdPHBTR() {
        return idPHBTR;
    }

    public void setIdPHBTR(String idPHBTR) {
        this.idPHBTR = idPHBTR;
    }

    public String getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(String idKelas) {
        this.idKelas = idKelas;
    }

    public String getLokasiPenempatan() {
        return lokasiPenempatan;
    }

    public void setLokasiPenempatan(String lokasiPenempatan) {
        this.lokasiPenempatan = lokasiPenempatan;
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

    public String getKodeResiko() {
        return kodeResiko;
    }

    public void setKodeResiko(String kodeResiko) {
        this.kodeResiko = kodeResiko;
    }

    public String getKodePeralatan() {
        return kodePeralatan;
    }

    public void setKodePeralatan(String kodePeralatan) {
        this.kodePeralatan = kodePeralatan;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJenisPemutus() {
        return jenisPemutus;
    }

    public void setJenisPemutus(String jenisPemutus) {
        this.jenisPemutus = jenisPemutus;
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

    public int getNilaiPerolehan() {
        return nilaiPerolehan;
    }

    public void setNilaiPerolehan(int nilaiPerolehan) {
        this.nilaiPerolehan = nilaiPerolehan;
    }

    public int getNilaiBuku() {
        return nilaiBuku;
    }

    public void setNilaiBuku(int nilaiBuku) {
        this.nilaiBuku = nilaiBuku;
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

    public float getShapeArea() {
        return shapeArea;
    }

    public void setShapeArea(float shapeArea) {
        this.shapeArea = shapeArea;
    }
}

package id.net.iconpln.dreamap.api.model.master;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by UwieSilent on 1/19/2015.
 */
public class MVCable implements Serializable {

    private String idMVCable;
    private String idKelas;
    private String kodePeralatan;
    private String kdPemilik;
    private String kdPengelola;
    private String tingkatResiko;
    private String status;
    private Date tglPasang;
    private Date tglOperasi;
    private int umurEkonomis;
    private int umurManfaat;
    private int nilaiPerolehan;
    private int nilaiBuku;
    private String merk;
    private int panjang;
    private String jenis;
    private String fungsi;
    private float x;
    private float y;

    public String getIdMVCable() {
        return idMVCable;
    }

    public void setIdMVCable(String idMVCable) {
        this.idMVCable = idMVCable;
    }

    public String getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(String idKelas) {
        this.idKelas = idKelas;
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

    public String getTingkatResiko() {
        return tingkatResiko;
    }

    public void setTingkatResiko(String tingkatResiko) {
        this.tingkatResiko = tingkatResiko;
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

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getPanjang() {
        return panjang;
    }

    public void setPanjang(int panjang) {
        this.panjang = panjang;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getFungsi() {
        return fungsi;
    }

    public void setFungsi(String fungsi) {
        this.fungsi = fungsi;
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

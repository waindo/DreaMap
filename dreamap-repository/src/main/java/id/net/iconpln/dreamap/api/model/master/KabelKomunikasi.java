package id.net.iconpln.dreamap.api.model.master;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by UwieSilent on 1/19/2015.
 */
public class KabelKomunikasi implements Serializable {

    private String idKabel;
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
    private float nilaiPerolehan;
    private float nilaiBuku;
    private String jenisKabel;
    private String merk;
    private String noSeri;
    private String jumlahCore;
    private float titikAwal;
    private float titikAkhir;
    private int panjangHantaran;
    private float shapeLength;

    public String getIdKabel() {
        return idKabel;
    }

    public void setIdKabel(String idKabel) {
        this.idKabel = idKabel;
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

    public String getJenisKabel() {
        return jenisKabel;
    }

    public void setJenisKabel(String jenisKabel) {
        this.jenisKabel = jenisKabel;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getNoSeri() {
        return noSeri;
    }

    public void setNoSeri(String noSeri) {
        this.noSeri = noSeri;
    }

    public String getJumlahCore() {
        return jumlahCore;
    }

    public void setJumlahCore(String jumlahCore) {
        this.jumlahCore = jumlahCore;
    }

    public float getTitikAwal() {
        return titikAwal;
    }

    public void setTitikAwal(float titikAwal) {
        this.titikAwal = titikAwal;
    }

    public float getTitikAkhir() {
        return titikAkhir;
    }

    public void setTitikAkhir(float titikAkhir) {
        this.titikAkhir = titikAkhir;
    }

    public int getPanjangHantaran() {
        return panjangHantaran;
    }

    public void setPanjangHantaran(int panjangHantaran) {
        this.panjangHantaran = panjangHantaran;
    }

    public float getShapeLength() {
        return shapeLength;
    }

    public void setShapeLength(float shapeLength) {
        this.shapeLength = shapeLength;
    }
}

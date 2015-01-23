package id.net.iconpln.dreamap.api.model.master;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by UwieSilent on 1/19/2015.
 */
public class SKUTR implements Serializable {

    private String idSKUTR;
    private String idJTM;
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
    private int frasaJaringan;
    private String hantaranNetral;
    private String namaJurusan;
    private int panjangHantaran;
    private float shapeLength;

    public String getIdSKUTR() {
        return idSKUTR;
    }

    public void setIdSKUTR(String idSKUTR) {
        this.idSKUTR = idSKUTR;
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

    public int getFrasaJaringan() {
        return frasaJaringan;
    }

    public void setFrasaJaringan(int frasaJaringan) {
        this.frasaJaringan = frasaJaringan;
    }

    public String getHantaranNetral() {
        return hantaranNetral;
    }

    public void setHantaranNetral(String hantaranNetral) {
        this.hantaranNetral = hantaranNetral;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
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

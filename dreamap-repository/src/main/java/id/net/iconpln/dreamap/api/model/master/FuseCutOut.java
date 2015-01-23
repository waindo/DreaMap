package id.net.iconpln.dreamap.api.model.master;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by UwieSilent on 1/16/2015.
 */
public class FuseCutOut implements Serializable {

    private String idKelas;
    private String idCutOut;
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
    private String lokasiPenempatan;
    private String merk;
    private String type;
    private String noSeri;
    private String jenis;

    public String getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(String idKelas) {
        this.idKelas = idKelas;
    }

    public String getIdCutOut() {
        return idCutOut;
    }

    public void setIdCutOut(String idCutOut) {
        this.idCutOut = idCutOut;
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

    public String getLokasiPenempatan() {
        return lokasiPenempatan;
    }

    public void setLokasiPenempatan(String lokasiPenempatan) {
        this.lokasiPenempatan = lokasiPenempatan;
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

    public String getNoSeri() {
        return noSeri;
    }

    public void setNoSeri(String noSeri) {
        this.noSeri = noSeri;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}

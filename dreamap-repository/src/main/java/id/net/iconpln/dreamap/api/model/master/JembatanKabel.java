package id.net.iconpln.dreamap.api.model.master;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by UwieSilent on 1/19/2015.
 */
public class JembatanKabel implements Serializable {

    private String idJembatanKabel;
    private String idKelas;
    private String kdPemilik;
    private String kdPengelola;
    private String kodeKonstruksi;
    private String tingkatResiko;
    private String status;
    private Date tglPasang;
    private Date tglOperasi;
    private int umurEkonomis;
    private int umurManfaat;
    private float nilaiPerolehan;
    private float nilaiBuku;
    private int pjgBentang;
    private int kapasitasJembatan;
    private float shapeArea;
    private float shapeLength;

    public String getIdJembatanKabel() {
        return idJembatanKabel;
    }

    public void setIdJembatanKabel(String idJembatanKabel) {
        this.idJembatanKabel = idJembatanKabel;
    }

    public String getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(String idKelas) {
        this.idKelas = idKelas;
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

    public int getPjgBentang() {
        return pjgBentang;
    }

    public void setPjgBentang(int pjgBentang) {
        this.pjgBentang = pjgBentang;
    }

    public int getKapasitasJembatan() {
        return kapasitasJembatan;
    }

    public void setKapasitasJembatan(int kapasitasJembatan) {
        this.kapasitasJembatan = kapasitasJembatan;
    }

    public float getShapeArea() {
        return shapeArea;
    }

    public void setShapeArea(float shapeArea) {
        this.shapeArea = shapeArea;
    }

    public float getShapeLength() {
        return shapeLength;
    }

    public void setShapeLength(float shapeLength) {
        this.shapeLength = shapeLength;
    }
}

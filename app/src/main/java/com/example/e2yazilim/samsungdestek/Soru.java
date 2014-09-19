package com.example.e2yazilim.samsungdestek;

import java.io.Serializable;
import java.util.Date;

public class Soru implements Serializable {

    private int id;
    private String baslik;
    private String icerik;
    private int uyeId;
    private Date tarih;
    private int puan;
    private int goruntulenme;
    private String uyeAd;
    private int cevapSayi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public int getUyeId() {
        return uyeId;
    }

    public void setUyeId(int uyeId) {
        this.uyeId = uyeId;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public int getGoruntulenme() {
        return goruntulenme;
    }

    public void setGoruntulenme(int goruntulenme) {
        this.goruntulenme = goruntulenme;
    }

    public String getUyeAd() {
        return uyeAd;
    }

    public void setUyeAd(String uyeAd) {
        this.uyeAd = uyeAd;
    }

    public int getCevapSayi() {
        return cevapSayi;
    }

    public void setCevapSayi(int cevapSayi) {
        this.cevapSayi = cevapSayi;
    }
}

package com.tutorial;

public class Tiket {
    public String name;
    private String[] kode;
    private int harga;
    private String[] jam;

    Tiket(String name) {
        this.name = name;
    }

    public String[] getKode() {
        return this.kode;
    }

    public void setKode(String[] k) {
        this.kode = k;
    }

    public int getHarga() {
        return this.harga;
    }

    public void setHarga(int hg) {
        this.harga = hg;
    }

    public String[] getJam() {
        return this.jam;
    }

    public void setJam(String[] waktu) {
        this.jam = waktu;
    }
}

package com.tutorial;

public class Cust extends Tiket {
    private String nama;
    private String telp;
    private Tiket tiket;

    Cust(String name) {
        super(name);
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String n) {
        this.nama = n;
    }

    public String getTelp() {
        return this.telp;
    }

    public void setTelp(String n) {
        this.telp = n;
    }
}

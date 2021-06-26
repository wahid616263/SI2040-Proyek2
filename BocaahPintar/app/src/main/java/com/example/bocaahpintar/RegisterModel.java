package com.example.bocaahpintar;

public class RegisterModel {

    String id;
    String namaAnak;
    String usiaAnak;
    String jk;

    public RegisterModel(String id, String namaAnak, String usiaAnak, String jk) {
        this.id = id;
        this.namaAnak = namaAnak;
        this.usiaAnak = usiaAnak;
        this.jk = jk;
    }

    public String getId() {
        return id;
    }

    public String getNamaAnak() {
        return namaAnak;
    }

    public String getUsiaAnak() {
        return usiaAnak;
    }

    public String getJk() {
        return jk;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNamaAnak(String namaAnak) {
        this.namaAnak = namaAnak;
    }

    public void setUsiaAnak(String usiaAnak) {
        this.usiaAnak = usiaAnak;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }
}

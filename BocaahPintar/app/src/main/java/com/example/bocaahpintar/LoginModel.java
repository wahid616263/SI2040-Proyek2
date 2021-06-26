package com.example.bocaahpintar;

public class LoginModel {

    String id;
    String namaAnak;
    String usiaAnak;

    public LoginModel(String id, String namaAnak, String usiaAnak) {
        this.id = id;
        this.namaAnak = namaAnak;
        this.usiaAnak = usiaAnak;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setNamaAnak(String namaAnak) {
        this.namaAnak = namaAnak;
    }

    public void setUsiaAnak(String usiaAnak) {
        this.usiaAnak = usiaAnak;
    }
}

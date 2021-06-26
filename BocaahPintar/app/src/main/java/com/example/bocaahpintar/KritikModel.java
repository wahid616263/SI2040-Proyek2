package com.example.bocaahpintar;

public class KritikModel {

    String id;
    String kritikan;

    public KritikModel(String id, String kritikan) {
        this.id = id;
        this.kritikan = kritikan;
    }

    public String getId() {
        return id;
    }

    public String getKritikan() {
        return kritikan;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setKritikan(String kritikan) {
        this.kritikan = kritikan;
    }
}

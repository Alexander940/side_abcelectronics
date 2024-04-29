package com.icesi.ABCElectronics.entity.mongo;

public class CivilStatus {

    private String date;
    private String status;
    private Couple couple;

    public CivilStatus(String date, String status, Couple couple) {
        this.date = date;
        this.status = status;
        this.couple = couple;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Couple getCouple() {
        return couple;
    }

    public void setCouple(Couple couple) {
        this.couple = couple;
    }
}

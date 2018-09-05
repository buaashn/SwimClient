package model.DO;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class AirportData extends RecursiveTreeObject<AirportData> {
    private String ID;
    private String codeICAO;
    private String nameEn;
    private String controlType;
    private String designatorIATA;
    private String city;
    private String latitude;
    private String longtitude;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCodeICAO() {
        return codeICAO;
    }

    public void setCodeICAO(String codeICAO) {
        this.codeICAO = codeICAO;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getControlType() {
        return controlType;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    public String getDesignatorIATA() {
        return designatorIATA;
    }

    public void setDesignatorIATA(String designatorIATA) {
        this.designatorIATA = designatorIATA;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }
}

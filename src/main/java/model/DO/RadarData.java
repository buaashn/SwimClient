package model.DO;

public class RadarData {
    private String ID;
    private String newID;
    private String SSR;
    private String flightTag;
    private String lontitude;
    private String latitude;
    private String storeTime;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNewID() {
        return newID;
    }

    public void setNewID(String newID) {
        this.newID = newID;
    }

    public String getSSR() {
        return SSR;
    }

    public void setSSR(String SSR) {
        this.SSR = SSR;
    }

    public String getFlightTag() {
        return flightTag;
    }

    public void setFlightTag(String flightTag) {
        this.flightTag = flightTag;
    }

    public String getLontitude() {
        return lontitude;
    }

    public void setLontitude(String lontitude) {
        this.lontitude = lontitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getStoreTime() {
        return storeTime;
    }

    public void setStoreTime(String storeTime) {
        this.storeTime = storeTime;
    }
}

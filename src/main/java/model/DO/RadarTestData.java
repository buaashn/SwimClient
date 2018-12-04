package model.DO;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class RadarTestData extends RecursiveTreeObject<RadarTestData>  {
    private String flightTag;
    private String lontitude;
    private String latitude;
    private String storeTime;
    private String direction;

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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}

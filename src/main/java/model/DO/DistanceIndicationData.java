package model.DO;

public class DistanceIndicationData {
    private String ID;
    private String distance;
    private String distanceUOM;
    private String fix;
    private String pointChoiceNavaidSystem;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDistanceUOM() {
        return distanceUOM;
    }

    public void setDistanceUOM(String distanceUOM) {
        this.distanceUOM = distanceUOM;
    }

    public String getFix() {
        return fix;
    }

    public void setFix(String fix) {
        this.fix = fix;
    }

    public String getPointChoiceNavaidSystem() {
        return pointChoiceNavaidSystem;
    }

    public void setPointChoiceNavaidSystem(String pointChoiceNavaidSystem) {
        this.pointChoiceNavaidSystem = pointChoiceNavaidSystem;
    }
}

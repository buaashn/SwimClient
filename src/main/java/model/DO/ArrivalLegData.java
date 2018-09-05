package model.DO;

public class ArrivalLegData {
    private String ID;
    private String upperLimitAltitude;
    private String upperLimitAltitudeUOM;
    private String lowerLimitAltitude;
    private String lowerLimitAltitudeUOM;
    private String startPointChoice;
    private String startPoint;
    private String endPointChoice;
    private String endPoint;
    private String arrival;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUpperLimitAltitude() {
        return upperLimitAltitude;
    }

    public void setUpperLimitAltitude(String upperLimitAltitude) {
        this.upperLimitAltitude = upperLimitAltitude;
    }

    public String getUpperLimitAltitudeUOM() {
        return upperLimitAltitudeUOM;
    }

    public void setUpperLimitAltitudeUOM(String upperLimitAltitudeUOM) {
        this.upperLimitAltitudeUOM = upperLimitAltitudeUOM;
    }

    public String getLowerLimitAltitude() {
        return lowerLimitAltitude;
    }

    public void setLowerLimitAltitude(String lowerLimitAltitude) {
        this.lowerLimitAltitude = lowerLimitAltitude;
    }

    public String getLowerLimitAltitudeUOM() {
        return lowerLimitAltitudeUOM;
    }

    public void setLowerLimitAltitudeUOM(String lowerLimitAltitudeUOM) {
        this.lowerLimitAltitudeUOM = lowerLimitAltitudeUOM;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getStartPointChoice() {
        return startPointChoice;
    }

    public void setStartPointChoice(String startPointChoice) {
        this.startPointChoice = startPointChoice;
    }

    public String getEndPointChoice() {
        return endPointChoice;
    }

    public void setEndPointChoice(String endPointChoice) {
        this.endPointChoice = endPointChoice;
    }
}

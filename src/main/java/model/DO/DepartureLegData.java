package model.DO;

public class DepartureLegData {
    private String ID;
    private String upperLimitAltitude;
    private String upperLimitAltitudeUOM;
    private String lowerLimitAltitude;
    private String lowerLimitAltitudeUOM;
    private String startPointChoice;
    private String startPoint;
    private String endPointChoice;
    private String endPoint;
    private String departure;

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

    public String getStartPointChoice() {
        return startPointChoice;
    }

    public void setStartPointChoice(String startPointChoice) {
        this.startPointChoice = startPointChoice;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPointChoice() {
        return endPointChoice;
    }

    public void setEndPointChoice(String endPointChoice) {
        this.endPointChoice = endPointChoice;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }
}

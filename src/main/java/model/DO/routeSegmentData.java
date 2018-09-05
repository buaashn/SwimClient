package model.DO;

public class routeSegmentData {

    private String ID;
    private String upperLimit;
    private String upperLimitUOM;
    private String lowerLimit;
    private String lowerLimitUOM;
    private String startPointChoice;
    private String startPoint;
    private String endPointChoice;
    private String endPoint;
    private String routeFormed;

    public routeSegmentData(String ID, String upperLimit, String upperLimitUOM, String lowerLimit, String lowerLimitUOM, String startPointChoice, String startPoint, String endPointChoice, String endPoint, String routeFormed) {
        this.ID = ID;
        this.upperLimit = upperLimit;
        this.upperLimitUOM = upperLimitUOM;
        this.lowerLimit = lowerLimit;
        this.lowerLimitUOM = lowerLimitUOM;
        this.startPointChoice = startPointChoice;
        this.startPoint = startPoint;
        this.endPointChoice = endPointChoice;
        this.endPoint = endPoint;
        this.routeFormed = routeFormed;
    }

    public routeSegmentData() {

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(String upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getUpperLimitUOM() {
        return upperLimitUOM;
    }

    public void setUpperLimitUOM(String upperLimitUOM) {
        this.upperLimitUOM = upperLimitUOM;
    }

    public String getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(String lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public String getLowerLimitUOM() {
        return lowerLimitUOM;
    }

    public void setLowerLimitUOM(String lowerLimitUOM) {
        this.lowerLimitUOM = lowerLimitUOM;
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

    public String getRouteFormed() {
        return routeFormed;
    }

    public void setRouteFormed(String routeFormed) {
        this.routeFormed = routeFormed;
    }
}

package model.DO;

/**
 * 简单Java类，数据对象，对应数据表 flight_data
 */
@SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
public class FlightData {

    private String flightID ;
    private String aircraftType ;
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    private String airport1 ;
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    private String airport2;
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    private String airport3 ;
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    private String airport4 ;
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    private String airport5 ;
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    private String arrivalTime1;
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    private String arrivalTime2;
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    private String arrivalTime3 ;
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    private String arrivalTime4;
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    private String departureTime1;
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    private String departureTime2;
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    private String departureTime3;
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    private String departureTime4;
    private String flightDays;
    private String route ;
    private String effectiveTimeBegin ;
    private String effectiveTimeEnd ;
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    private Integer ID;

    public String getFlightID() {
        return flightID;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public String getAirport1() {
        return airport1;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public String getAirport2() {
        return airport2;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public String getAirport3() {
        return airport3;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public String getAirport4() {
        return airport4;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public String getAirport5() {
        return airport5;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public String getArrivalTime1() {
        return arrivalTime1;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public String getArrivalTime2() {
        return arrivalTime2;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public String getArrivalTime3() {
        return arrivalTime3;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public String getArrivalTime4() {
        return arrivalTime4;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public String getDepartureTime1() {
        return departureTime1;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public String getDepartureTime2() {
        return departureTime2;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public String getDepartureTime3() {
        return departureTime3;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public String getDepartureTime4() {
        return departureTime4;
    }

    public String getFlightDays() {
        return flightDays;
    }

    public String getRoute() {
        return route;
    }

    public String getEffectiveTimeBegin() {
        return effectiveTimeBegin;
    }

    public String getEffectiveTimeEnd() {
        return effectiveTimeEnd;
    }

    public Integer getID() {
        return ID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void setAirport1(String airport1) {
        this.airport1 = airport1;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void setAirport2(String airport2) {
        this.airport2 = airport2;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void setAirport3(String airport3) {
        this.airport3 = airport3;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void setAirport4(String airport4) {
        this.airport4 = airport4;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void setAirport5(String airport5) {
        this.airport5 = airport5;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void setArrivalTime1(String arrivalTime1) {
        this.arrivalTime1 = arrivalTime1;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void setArrivalTime2(String arrivalTime2) {
        this.arrivalTime2 = arrivalTime2;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void setArrivalTime3(String arrivalTime3) {
        this.arrivalTime3 = arrivalTime3;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void setArrivalTime4(String arrivalTime4) {
        this.arrivalTime4 = arrivalTime4;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void setDepartureTime1(String departureTime1) {
        this.departureTime1 = departureTime1;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void setDepartureTime2(String departureTime2) {
        this.departureTime2 = departureTime2;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void setDepartureTime3(String departureTime3) {
        this.departureTime3 = departureTime3;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void setDepartureTime4(String departureTime4) {
        this.departureTime4 = departureTime4;
    }

    public void setFlightDays(String flightDays) {
        this.flightDays = flightDays;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public void setEffectiveTimeBegin(String effectiveTimeBegin) {
        this.effectiveTimeBegin = effectiveTimeBegin;
    }

    public void setEffectiveTimeEnd(String effectiveTimeEnd) {
        this.effectiveTimeEnd = effectiveTimeEnd;
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void setID(Integer ID) {
        this.ID = ID;
    }
}

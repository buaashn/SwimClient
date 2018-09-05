package model.service.impl;


import model.DO.FlightData;
import model.service.ICreateFPLService;
import model.service.factory.FlightDataServiceFactory;

public class CreateFPLServiceImpl implements ICreateFPLService {

    @Override
    public String getFPLByDatabase(Integer id) {
        String stringFPL = null;
        FlightData flightData = null;
        try {
            flightData = FlightDataServiceFactory.getIFlightDataServiceInstance().getFlightData(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(flightData != null){
            stringFPL = "(FPL-" + flightData.getFlightID() + "\r\n-" +flightData.getAircraftType() + "\n\r-" +
                    flightData.getAirport1() +  flightData.getDepartureTime1() + "\n\r-" +
                    flightData.getRoute() + "\n\r-" +flightData.getAirport2() + flightData.getArrivalTime1() + ")";
        }
        return stringFPL;
    }
}

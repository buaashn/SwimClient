package model.service.factory;


import model.service.IAirportDataService;
import model.service.impl.AirportDataServiceImpl;

public class AirportDataServiceFactory {
    public static IAirportDataService getAirportDataServiceInstance(){
        return new AirportDataServiceImpl();
    }
}

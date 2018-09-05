package model.service.factory;


import model.service.IAirTrafficManagementServiceDataService;
import model.service.impl.AirTrafficManagementServiceDataServiceImpl;

public class AirTrafficManagementServiceDataServiceFactory {
    public static IAirTrafficManagementServiceDataService getAirTrafficManagementServiceDataServiceInstance(){
        return new AirTrafficManagementServiceDataServiceImpl();
    }
}

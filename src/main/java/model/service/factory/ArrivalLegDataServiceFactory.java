package model.service.factory;


import model.service.IArrivalLegDataService;
import model.service.impl.ArrivalLegDataServiceImpl;

public class ArrivalLegDataServiceFactory {
    public static IArrivalLegDataService getArrivalLegDataServiceInstance(){
        return new ArrivalLegDataServiceImpl();
    }
}

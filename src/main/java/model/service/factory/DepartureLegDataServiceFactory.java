package model.service.factory;


import model.service.IDepartureLegDataService;
import model.service.impl.DepartureLegDataServiceImpl;

public class DepartureLegDataServiceFactory {
    public static IDepartureLegDataService getDepartureLegDataServiceInstance(){
        return new DepartureLegDataServiceImpl();
    }

}

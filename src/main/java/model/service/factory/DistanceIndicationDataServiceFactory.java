package model.service.factory;


import model.service.IDistanceIndicationDataService;
import model.service.impl.DistanceIndicationDataServiceImpl;

public class DistanceIndicationDataServiceFactory {
    public static IDistanceIndicationDataService getDistanceIndicationDataServiceInstance(){
        return new DistanceIndicationDataServiceImpl();
    }
}

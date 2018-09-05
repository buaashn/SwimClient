package model.service.factory;


import model.service.IAngleIndicationDataService;
import model.service.impl.AngleIndicationDataServiceImpl;

public class AngleIndicationDataServiceFactory {
    public static IAngleIndicationDataService getAngleIndicationDataServiceInstance(){
        return new AngleIndicationDataServiceImpl();
    }
}

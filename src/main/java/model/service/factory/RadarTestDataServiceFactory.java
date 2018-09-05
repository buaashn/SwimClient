package model.service.factory;


import model.service.IRadarTestDataService;
import model.service.impl.RadarTestDataServiceImpl;

public class RadarTestDataServiceFactory {
    public static IRadarTestDataService getRadarTestDataServiceInstance() {
        return new RadarTestDataServiceImpl();
    }
}

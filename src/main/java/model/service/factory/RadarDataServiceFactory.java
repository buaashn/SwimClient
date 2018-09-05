package model.service.factory;


import model.service.IRadarDataService;
import model.service.impl.RadarDataServiceImpl;

public class RadarDataServiceFactory {
    public static IRadarDataService getRadarDataServiceInstance() {
        return new RadarDataServiceImpl();
    }
}

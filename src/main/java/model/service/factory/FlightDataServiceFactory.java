package model.service.factory;


import model.service.IFlightDataService;
import model.service.impl.FlightDataServiceImpl;

/**
 * service层工厂类
 * 返回FlightData服务层对象
 */
public class FlightDataServiceFactory {
    public static IFlightDataService getIFlightDataServiceInstance() {
        return new FlightDataServiceImpl();
    }
}

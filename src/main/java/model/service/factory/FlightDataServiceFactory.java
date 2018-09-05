package model.service.factory;


import model.service.IFlightDataService;
import model.service.impl.FlightDataServiceImpl;

/**
 * service�㹤����
 * ����FlightData��������
 */
public class FlightDataServiceFactory {
    public static IFlightDataService getIFlightDataServiceInstance() {
        return new FlightDataServiceImpl();
    }
}

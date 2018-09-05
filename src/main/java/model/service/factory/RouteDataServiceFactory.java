package model.service.factory;


import model.service.IRouteDataService;
import model.service.impl.RouteDataServiceImpl;

public class RouteDataServiceFactory {
    public static IRouteDataService getRouteDataServiceInstance(){
        return new RouteDataServiceImpl();
    }
}

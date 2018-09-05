package model.service.factory;

import model.service.IRouteSegmentDataService;
import model.service.impl.RouteSegmentDataServiceImpl;

public class RouteSegmentDataServiceFactory {
    public static IRouteSegmentDataService getRouteSegmentDataDAOServiceInstance (){
        return new RouteSegmentDataServiceImpl();
    }
}

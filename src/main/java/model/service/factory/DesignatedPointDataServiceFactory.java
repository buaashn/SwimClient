package model.service.factory;


import model.service.IDesignatedPointDataService;
import model.service.impl.DesignatedPointDataServiceImpl;

public class DesignatedPointDataServiceFactory {
    public static IDesignatedPointDataService getDesignatedPointDataServiceInstance(){
        return new DesignatedPointDataServiceImpl();
    }
}

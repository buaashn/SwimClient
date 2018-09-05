package model.service.factory;


import model.service.INavaidDataService;
import model.service.impl.NavaidDataServiceImpl;

public class NavaidDataServiceFactory {
    public static INavaidDataService getNavaidDataServiceIntance(){
        return new NavaidDataServiceImpl();
    }
}

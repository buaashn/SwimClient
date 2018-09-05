package model.service.factory;


import model.service.IFaaPointDataService;
import model.service.impl.FaaPointDataServiceImpl;

public class FaaPointDataServiceFactory {
    public static IFaaPointDataService getFaaPointDataServiceInstance (){
        return new FaaPointDataServiceImpl();
    }
}

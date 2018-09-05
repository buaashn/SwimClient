package model.service.factory;


import model.service.IFlowDataService;
import model.service.impl.FlowDataServiceImpl;

public class FlowDataServiceFactory {
    public static IFlowDataService getFlowDataServiceInstance (){
        return new FlowDataServiceImpl();
    }
}

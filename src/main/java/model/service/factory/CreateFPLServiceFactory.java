package model.service.factory;


import model.service.ICreateFPLService;
import model.service.impl.CreateFPLServiceImpl;

public class CreateFPLServiceFactory {
    public static ICreateFPLService getICreateFPLServiceInstance(){
        return new CreateFPLServiceImpl();
    }
}

package model.service.factory;


import model.service.ISendFPLService;
import model.service.impl.SendFPLServiceImpl;

public class SendFPLServiceFactory {
    public static ISendFPLService getSendFPLService(){
        return new SendFPLServiceImpl();
    }
}

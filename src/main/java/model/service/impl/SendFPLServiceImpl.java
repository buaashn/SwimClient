package model.service.impl;


import model.service.ISendFPLService;

public class SendFPLServiceImpl implements ISendFPLService {
    @Override
    public boolean sendFPL(String fplString) {
        //MQConnection mqConnection = new MQConnection();
        //
        //if (MqDAOFactory.getIMqDAOInstance(mqConnection).sendMessageByMq(fplString)){
        //    return true;
        //} else {
        //    return false;
        //}
return false;
    }
}

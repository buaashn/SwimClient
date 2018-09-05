//package model.dao.impl;
//
//
//import model.dao.IMqDAO;
//
///**
// * @author sdushn
// */
//public class MqDAOImpl implements IMqDAO {
//
//    private MQConnection mqConnection;
//
//    public MqDAOImpl(MQConnection mqConnection){
//        this.mqConnection = mqConnection;
//    }
//
//    @Override
//    public boolean sendMessageByMq(String messageString) {
//
//        try {
//            MQMessage message;
//            message = new MQMessage();
//            message.format = MQC.MQFMT_STRING;
//            message.characterSet = MQConnection.CCSID;
//            message.encoding = MQConnection.CCSID;
//            message.writeString(messageString);
//            // 设置消息用不过期
//            message.expiry = MQC.MQCOMPRESS_NOT_AVAILABLE;
//            //MQPutMessageOptions pmo = new MQPutMessageOptions();
//            mqConnection.getQueue().put(message);
//        } catch(Exception e){
//            e.printStackTrace();
//            return false;
//        } finally {
//            mqConnection.close();
//            return true;
//        }
//
//    }
//}

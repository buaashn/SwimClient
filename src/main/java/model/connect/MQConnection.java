//package model.connect;
//
//import com.ibm.mq.*;
//
///**
// * @author sdush
// */
//public class MQConnection {
//    public static final int CCSID = 1381;
//    private static final String QUEUE_MANNAGER_NAME = "QM_APPLE";
//    private static final String QUEUE_NAME = "Q1";
//    private static final String HOSTNAME = "127.0.0.1";
//    private static final String CHANNEL_NAME = "SERVERCONN";
//    private static final int PORT = 1415;
//    private static final int OPEN_OPTIONS = MQC.MQOO_INPUT_AS_Q_DEF | MQC.MQOO_OUTPUT | MQC.MQOO_INQUIRE;
//
//    private MQQueueManager queueManager;
//    private MQQueue queue = null;
//
//    public MQConnection(){
//        MQEnvironment.hostname = HOSTNAME;
//        MQEnvironment.channel = CHANNEL_NAME;
//        MQEnvironment.port = PORT;
//        MQEnvironment.CCSID = CCSID;
//        try {
//            this.queueManager = new MQQueueManager(QUEUE_MANNAGER_NAME);
//            this.queue = queueManager.accessQueue(QUEUE_NAME, OPEN_OPTIONS, null, null, null);
//        } catch (MQException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public MQQueue getQueue(){
//        return queue;
//    }
//
//    public MQQueueManager getQueueManager(){
//        return queueManager;
//    }
//
//    public void close(){
//        if(queue != null){
//            try {
//                queue.close();
//            } catch (MQException e){
//                e.printStackTrace();
//            }
//        }
//    }
//}

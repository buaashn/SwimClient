package model.dao.factory;


import model.dao.IFlightDataDAO;
import model.dao.impl.FlightDataDAOImpl;

import java.sql.Connection;

/**
 * ���ݲ����ӿڹ����࣬�����ݲ����ӿڱ�¶���������ʵ�ֲ��ᱩ¶
 * @author sdushn
 */
public class FlightDataDAOFactory {
    public static IFlightDataDAO getIFlightDataDAOInstance(Connection connection){
        return new FlightDataDAOImpl(connection);
    }
}

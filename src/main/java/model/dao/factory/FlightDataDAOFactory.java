package model.dao.factory;


import model.dao.IFlightDataDAO;
import model.dao.impl.FlightDataDAOImpl;

import java.sql.Connection;

/**
 * 数据操作接口工厂类，将数据操作接口暴露，而其具体实现不会暴露
 * @author sdushn
 */
public class FlightDataDAOFactory {
    public static IFlightDataDAO getIFlightDataDAOInstance(Connection connection){
        return new FlightDataDAOImpl(connection);
    }
}

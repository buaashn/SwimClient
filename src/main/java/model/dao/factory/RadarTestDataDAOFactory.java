package model.dao.factory;


import model.dao.IRadarTestDataDAO;
import model.dao.impl.RadarTestDataDAOImpl;

import java.sql.Connection;

public class RadarTestDataDAOFactory {
    public static IRadarTestDataDAO getRadarDataDAOInstance(Connection connection){
        return new RadarTestDataDAOImpl(connection);
    }

    //public static IRadarTestDataDAO getRadarTestDataDAOInstance(Connection connection, String nameOfDataTable){
    //    return new RadarTestDataDAOImpl(connection, nameOfDataTable);
    //}
}

package model.dao.factory;


import model.dao.IRadarDataDAO;
import model.dao.impl.RadarDataDAOImpl;

import java.sql.Connection;

public class RadarDataDAOFactory {
    public static IRadarDataDAO getRadarDataDAOInstance(Connection connection){
        return new RadarDataDAOImpl(connection);
    }

    public static IRadarDataDAO getRadarDataDAOInstance(Connection connection, String nameOfDataTable){
        return new RadarDataDAOImpl(connection, nameOfDataTable);
    }
}

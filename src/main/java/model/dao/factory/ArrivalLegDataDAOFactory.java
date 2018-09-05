package model.dao.factory;


import model.dao.IArrivalLegDataDAO;
import model.dao.impl.ArrivalLegDataDAOImpl;

import java.sql.Connection;

public class ArrivalLegDataDAOFactory {
    public static IArrivalLegDataDAO getArrivalLegDataDAOInstance(Connection connection){
        return new ArrivalLegDataDAOImpl(connection);
    }
}

package model.dao.factory;


import model.dao.IAirTrafficManagementServiceDataDAO;
import model.dao.impl.AirTrafficManagementServiceDataDAOImpl;

import java.sql.Connection;

public class AirTrafficManagementServiceDataDAOFactory {
    public static IAirTrafficManagementServiceDataDAO getAirTrafficManagementServiceDataDAOInstance(Connection connection){
        return new AirTrafficManagementServiceDataDAOImpl(connection);
    }
}

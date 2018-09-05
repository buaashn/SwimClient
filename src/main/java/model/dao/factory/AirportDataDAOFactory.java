package model.dao.factory;


import model.dao.IAirportDataDAO;
import model.dao.impl.AirportDataDAOImpl;

import java.sql.Connection;

public class AirportDataDAOFactory {
    public static IAirportDataDAO getIAirportDataDAOInstance(Connection connection){
        return  new AirportDataDAOImpl(connection);
    }
}

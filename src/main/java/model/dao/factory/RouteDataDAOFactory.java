package model.dao.factory;


import model.dao.IRouteDataDAO;
import model.dao.impl.RouteDataDAOImpl;

import java.sql.Connection;

public class RouteDataDAOFactory {
    public static IRouteDataDAO getRouteDataDAOInstance (Connection connection){
        return new RouteDataDAOImpl(connection);
    }
}

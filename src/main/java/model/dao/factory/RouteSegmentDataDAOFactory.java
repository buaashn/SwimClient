package model.dao.factory;


import model.dao.IRouteSegmentDataDAO;
import model.dao.impl.RouteSegmentDataDAOImpl;

import java.sql.Connection;

public class RouteSegmentDataDAOFactory {
    public static IRouteSegmentDataDAO getRouteSegmentDataDAOInstance (Connection connection) {
        return new RouteSegmentDataDAOImpl(connection);
    }
}

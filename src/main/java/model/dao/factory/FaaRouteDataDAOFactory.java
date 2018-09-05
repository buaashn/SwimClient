package model.dao.factory;

import model.dao.IFaaRouteDataDAO;
import model.dao.impl.FaaRouteDataDAOImpl;

import java.sql.Connection;

public class FaaRouteDataDAOFactory {
    public static IFaaRouteDataDAO getFaaRouteDataDAOInstance(Connection connection){
        return new FaaRouteDataDAOImpl(connection);
    }
}

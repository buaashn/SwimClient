package model.dao.factory;


import model.dao.IFaaRouteSegmentDataDAO;
import model.dao.impl.FaaRouteSegmentDataDAOImpl;

import java.sql.Connection;

public class FaaRouteSegmentDataDAOFactory {
    public static IFaaRouteSegmentDataDAO getFaaRouteSegmentDataDAOInstance(Connection connection){
        return new FaaRouteSegmentDataDAOImpl(connection);
    }
}

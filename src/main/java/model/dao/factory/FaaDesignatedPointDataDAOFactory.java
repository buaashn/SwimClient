package model.dao.factory;


import model.dao.IFaaDesignatedPointDataDAO;
import model.dao.impl.FaaDesignatedPointDataDAOImpl;

import java.sql.Connection;

public class FaaDesignatedPointDataDAOFactory {
    public static IFaaDesignatedPointDataDAO getFaaDesignatedPointDataDAOInstance(Connection connection){
        return new FaaDesignatedPointDataDAOImpl(connection);
    }
}

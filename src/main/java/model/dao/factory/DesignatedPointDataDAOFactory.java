package model.dao.factory;


import model.dao.IDesignatedPointDataDAO;
import model.dao.impl.DesignatedPointDataDAOImpl;

import java.sql.Connection;

public class DesignatedPointDataDAOFactory {
    public static IDesignatedPointDataDAO getDesignatedPointDataDAOInstance (Connection connection){
        return new DesignatedPointDataDAOImpl(connection);
    }
}

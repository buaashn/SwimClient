package model.dao.factory;


import model.dao.INavaidDataDAO;
import model.dao.impl.NavaidDataDAOImpl;

import java.sql.Connection;

public class NavaidDataDAOFactory {
    public static INavaidDataDAO getINavaidDataDAOInstance(Connection connection){
        return new NavaidDataDAOImpl(connection);
    }
}

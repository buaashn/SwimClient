package model.dao.factory;


import model.dao.IFaaNavaidDataDAO;
import model.dao.impl.FaaNavaidDataDAOImpl;

import java.sql.Connection;

public class FaaNavaidDataDAOFactory {
    public static IFaaNavaidDataDAO getFaaNavaidDataDAOInstance(Connection connection){
        return new FaaNavaidDataDAOImpl(connection);
    }
}

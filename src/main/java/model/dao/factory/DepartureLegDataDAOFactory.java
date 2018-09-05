package model.dao.factory;


import model.dao.IDepartureLegDataDAO;
import model.dao.impl.DepartureLegDataDAOImpl;

import java.sql.Connection;

public class DepartureLegDataDAOFactory {
    public static IDepartureLegDataDAO getDepartureLegDataDAOInstance(Connection connection){
        return new DepartureLegDataDAOImpl(connection);
    }
}

package model.dao.factory;


import model.dao.IDistanceIndicationDataDAO;
import model.dao.impl.DistanceIndicationDataDAOImpl;

import java.sql.Connection;

public class DistanceIndicationDataDAOFactory {
    public static IDistanceIndicationDataDAO getDistanceIndicationDataDAOInstance (Connection connection){
        return new DistanceIndicationDataDAOImpl(connection);
    }
}

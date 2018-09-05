package model.dao.factory;


import model.dao.IAngleIndicationDataDAO;
import model.dao.impl.AngleIndicationDataDAOImpl;

import java.sql.Connection;

public class AngleIndicationDataDAOFactory {
    public static IAngleIndicationDataDAO getAngleIndicationDataDAOInstance(Connection connection){
        return new AngleIndicationDataDAOImpl(connection);
    }
}

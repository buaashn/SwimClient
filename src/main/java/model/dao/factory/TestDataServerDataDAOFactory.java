package model.dao.factory;


import model.dao.ITestDataServerDataDAO;
import model.dao.impl.TestDataServerDataDAOImpl;

import java.sql.Connection;

public class TestDataServerDataDAOFactory {
    public static ITestDataServerDataDAO getTestDataServerDataDAOInstance(Connection connection){
        return new TestDataServerDataDAOImpl(connection);
    }
}

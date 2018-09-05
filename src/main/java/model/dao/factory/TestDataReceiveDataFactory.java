package model.dao.factory;


import model.dao.ITestDataReceiveDataDAO;
import model.dao.impl.TestDataReceiveDataDAOImpl;

import java.sql.Connection;

public class TestDataReceiveDataFactory {
    public static ITestDataReceiveDataDAO getTestDataReceiveDataDAOInstance(Connection connection){
        return new TestDataReceiveDataDAOImpl(connection);
    }
}

package model.dao.factory;


import model.dao.IFlowDataDAO;
import model.dao.impl.FlowDataDAOImpl;

import java.sql.Connection;

public class FlowDataDAOFactory {
    public static IFlowDataDAO getFlowDataDAOInstance (Connection connection){
        return new FlowDataDAOImpl(connection);
    }
}

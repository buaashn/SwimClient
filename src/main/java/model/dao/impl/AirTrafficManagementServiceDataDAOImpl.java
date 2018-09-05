package model.dao.impl;


import model.DO.AirTrafficManagementServiceData;
import model.dao.IAirTrafficManagementServiceDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AirTrafficManagementServiceDataDAOImpl implements IAirTrafficManagementServiceDataDAO {
    private Connection connection;
    private PreparedStatement statement;

    public AirTrafficManagementServiceDataDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean doCreate(AirTrafficManagementServiceData DO) throws Exception {
        String sql = "INSERT INTO airTrafficManagementService VALUES (?,?)";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1,DO.getID());
        this.statement.setString(2 ,DO.getClientAirspaceID());
        return this.statement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdata(AirTrafficManagementServiceData DO) throws Exception {
        return false;
    }

    @Override
    public AirTrafficManagementServiceData doFindByID(String ID) throws Exception {
        AirTrafficManagementServiceData DO = null;
        String sql = "SELECT * FROM airTrafficManagementService WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , ID);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new AirTrafficManagementServiceData();
            DO.setID(resultSet.getString("ID"));
            DO.setClientAirspaceID(resultSet.getString("clientAirspaceID"));
        }
        return DO;
    }
}

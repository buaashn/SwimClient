package model.dao.impl;


import model.DO.TestDataReceiveData;
import model.dao.ITestDataReceiveDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class TestDataReceiveDataDAOImpl implements ITestDataReceiveDataDAO {

    private String dataTableName = "testDataReceive";
    private Connection connection;
    private PreparedStatement statement;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    public TestDataReceiveDataDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean doCreate(TestDataReceiveData DO) throws Exception {
        String sql = "INSERT INTO " + dataTableName + " VALUES (?,?,?,?,?)";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setInt(1, DO.getID());
        this.statement.setString(2, DO.getTimeOfReceive());
        this.statement.setString(3, DO.getTimeOfSend());
        this.statement.setInt(4 ,DO.getDelay());
        this.statement.setInt(5,DO.getDataNumber());
        this.statement.setDouble(6, DO.getPacketLoss());

        return this.statement.executeUpdate() > 0;
    }
}

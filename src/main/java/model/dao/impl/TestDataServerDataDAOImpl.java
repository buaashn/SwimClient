package model.dao.impl;

import model.DO.TestDataServerData;
import model.dao.ITestDataServerDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class TestDataServerDataDAOImpl implements ITestDataServerDataDAO {

    private String dataTableName = "testDataServer";
    private Connection connection;
    private PreparedStatement statement;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    public TestDataServerDataDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean doCreate(TestDataServerData DO) throws Exception {
        String sql = "INSERT INTO " + dataTableName + " VALUES (?,?,?)";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1, DO.getTime());
        this.statement.setInt(2 ,DO.getDataNumber());
        this.statement.setInt(3,DO.getCpuUsage());

        return this.statement.executeUpdate() > 0;
    }
}

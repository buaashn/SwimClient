package model.dao.impl;


import model.DO.DesignatedPointData;
import model.dao.IDesignatedPointDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DesignatedPointDataDAOImpl implements IDesignatedPointDataDAO {
    private String dataTableName = "designatedPoint";
    private Connection connection;
    private PreparedStatement statement;

    public DesignatedPointDataDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean doCreate(DesignatedPointData DO) throws Exception {
        String sql = "INSERT INTO " + dataTableName + " VALUES (?,?,?,?,?,?)";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1,DO.getID());
        this.statement.setString(2 ,DO.getDesignator());
        this.statement.setString(3,DO.getType());
        this.statement.setString(4,DO.getName());
        this.statement.setString(5,DO.getLatitude());
        this.statement.setString(6,DO.getLongtitude());
        return this.statement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdata(DesignatedPointData DO) throws Exception {
        return false;
    }

    @Override
    public DesignatedPointData doFindByID(String ID) throws Exception {
        DesignatedPointData DO = null;
        String sql = "SELECT * FROM " + dataTableName + " WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , ID);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new DesignatedPointData();
            DO.setID(resultSet.getString("ID"));
            DO.setDesignator(resultSet.getString("designator"));
            DO.setType(resultSet.getString("type"));
            DO.setName(resultSet.getString("name"));
            DO.setLatitude(resultSet.getString("latitude"));
            DO.setLongtitude(resultSet.getString("longtitude"));
        }
        return DO;
    }
}

package model.dao.impl;


import model.DO.FaaNavaidData;
import model.dao.IFaaNavaidDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FaaNavaidDataDAOImpl implements IFaaNavaidDataDAO {
    private String dataTableName = "faaNavaid";
    private Connection connection;
    private PreparedStatement statement;

    public FaaNavaidDataDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean doCreate(FaaNavaidData DO) throws Exception {
        String sql = "INSERT INTO " + dataTableName + " VALUES (?,?,?,?,?,?,?,?,?)";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1,DO.getID());
        this.statement.setString(2 ,DO.getType());
        this.statement.setString(3,DO.getDesignator());
        this.statement.setString(4,DO.getName());
        this.statement.setString(5,DO.getLatitude());
        this.statement.setString(6,DO.getLongtitude());
        this.statement.setString(7,DO.getNavaidIdentifier());
        this.statement.setString(8,DO.getNavaidState());
        this.statement.setString(9,DO.getNavaidARTCC());
        return this.statement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdata(FaaNavaidData DO) throws Exception {
        return false;
    }

    @Override
    public FaaNavaidData doFindByID(String ID) throws Exception {
        FaaNavaidData DO = null;
        String sql = "SELECT * FROM " + dataTableName + " WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , ID);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new FaaNavaidData();
            DO.setID(resultSet.getString("ID"));
            DO.setType(resultSet.getString("type"));
            DO.setDesignator(resultSet.getString("designator"));
            DO.setName(resultSet.getString("name"));
            DO.setLatitude(resultSet.getString("latitude"));
            DO.setLongtitude(resultSet.getString("longtitude"));
            DO.setNavaidIdentifier(resultSet.getString("navaidIdentifier"));
            DO.setNavaidState(resultSet.getString("navaidState"));
            DO.setNavaidARTCC(resultSet.getString("navaidARTCC"));
        }
        return DO;
    }

    @Override
    public List<FaaNavaidData> findAll() throws Exception {
        List<FaaNavaidData> all = new ArrayList<FaaNavaidData>();
        String sql = "SELECT * FROM " + dataTableName ;
        this.statement = this.connection.prepareStatement(sql);
        ResultSet resultSet = this.statement.executeQuery();
        while (resultSet.next()){
            FaaNavaidData DO = new FaaNavaidData();
            DO.setID(resultSet.getString("ID"));
            DO.setDesignator(resultSet.getString("designator"));
            DO.setName(resultSet.getString("name"));
            DO.setType(resultSet.getString("type"));
            DO.setLatitude(resultSet.getString("latitude"));
            DO.setLongtitude(resultSet.getString("longtitude"));
            DO.setNavaidIdentifier(resultSet.getString("navaidIdentifier"));
            DO.setNavaidState(resultSet.getString("navaidState"));
            DO.setNavaidARTCC(resultSet.getString("navaidARTCC"));
            all.add(DO);
        }

        return all;
    }
}

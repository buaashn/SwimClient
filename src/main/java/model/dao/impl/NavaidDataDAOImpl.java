package model.dao.impl;


import model.DO.NavaidData;
import model.dao.INavaidDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NavaidDataDAOImpl implements INavaidDataDAO {

    private Connection connection;
    private PreparedStatement statement;
    private String nameOfDataTable = "navaid";

    public NavaidDataDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean doCreate(NavaidData DO) throws Exception {
        String sql = "INSERT INTO navaid VALUES (?,?,?,?,?,?,?,?,?)";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 ,DO.getID());
        this.statement.setString(2 ,DO.getDesignator());
        this.statement.setString(3 ,DO.getName());
        this.statement.setString(4 ,DO.getType());
        this.statement.setString(5 ,DO.getLatitude());
        this.statement.setString(6 ,DO.getLongtitude());
        this.statement.setString(7 ,DO.getNavaidIdentifier());
        this.statement.setString(8 ,DO.getNavaidState());
        this.statement.setString(9 ,DO.getNavaidARTCC());
        return this.statement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdata(NavaidData DO) throws Exception {
        return false;
    }

    @Override
    public NavaidData doFindByName(String code) throws Exception {
        return null;
    }

    @Override
    public NavaidData doFindByID(String ID) throws Exception {
        NavaidData DO = null;
        String sql = "SELECT * FROM navaid WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , ID);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new NavaidData();
            DO.setID(resultSet.getString("ID"));
            DO.setDesignator(resultSet.getString("designator"));
            DO.setName(resultSet.getString("name"));
            DO.setType(resultSet.getString("type"));
            DO.setLatitude(resultSet.getString("latitude"));
            DO.setLongtitude(resultSet.getString("longtitude"));
        }
        return DO;
    }

    @Override
    public List<NavaidData> findAll() throws Exception {
        List<NavaidData> all = new ArrayList<NavaidData>();
        String sql = "SELECT * FROM " + nameOfDataTable ;
        this.statement = this.connection.prepareStatement(sql);
        ResultSet resultSet = this.statement.executeQuery();
        while (resultSet.next()){
            NavaidData DO = new NavaidData();
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

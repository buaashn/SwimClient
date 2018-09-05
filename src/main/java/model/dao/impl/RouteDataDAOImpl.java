package model.dao.impl;


import model.DO.RouteData;
import model.dao.IRouteDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RouteDataDAOImpl implements IRouteDataDAO {
    private String dataTableName = "route";
    private Connection connection;
    private PreparedStatement statement;

    public RouteDataDAOImpl(Connection connection){
        this.connection = connection;
    }


    @Override
    public boolean doCreate(RouteData DO) throws Exception {
        String sql = "INSERT INTO " + dataTableName + " VALUES (?,?,?,?)";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1,DO.getID());
        this.statement.setString(2 ,DO.getDesignatorSecondLetter());
        this.statement.setString(3,DO.getDesignatorNumber());
        this.statement.setString(4,DO.getType());

        return this.statement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdata(RouteData DO) throws Exception {
        String sql = "UPDATE " + dataTableName +
                " SET ID = ?, designatorSecondLetter = ?, designatorNumber = ?, type = ?" +
                " WHERE ID = ? ";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1,DO.getID());
        this.statement.setString(2 ,DO.getDesignatorSecondLetter());
        this.statement.setString(3,DO.getDesignatorNumber());
        this.statement.setString(4,DO.getType());
        this.statement.setString(5,DO.getID());
        return this.statement.executeUpdate() > 0;
    }

    @Override
    public RouteData doFindByID(String ID) throws Exception {
        RouteData DO = null;
        String sql = "SELECT * FROM " + dataTableName + " WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , ID);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new RouteData();
            DO.setID(resultSet.getString("ID"));
            DO.setDesignatorSecondLetter(resultSet.getString("designatorSecondLetter"));
            DO.setDesignatorNumber(resultSet.getString("designatorNumber"));
            DO.setType(resultSet.getString("type"));

        }
        return DO;
    }

    @Override
    public List<RouteData> findAll() throws Exception {
        List<RouteData> routeDataList = new ArrayList<>();
        String sql = "SELECT * FROM " + dataTableName ;

        this.statement = this.connection.prepareStatement(sql);
        ResultSet resultSet = this.statement.executeQuery();
        while (resultSet.next()){
            RouteData DO = new RouteData();
            DO.setID(resultSet.getString("ID"));
            DO.setDesignatorSecondLetter(resultSet.getString("designatorSecondLetter"));
            DO.setDesignatorNumber(resultSet.getString("designatorNumber"));
            DO.setType(resultSet.getString("type"));

            routeDataList.add(DO);
        }
        return routeDataList;
    }
}

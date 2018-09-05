package model.dao.impl;


import model.DO.routeSegmentData;
import model.dao.IRouteSegmentDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RouteSegmentDataDAOImpl implements IRouteSegmentDataDAO {

    private Connection connection;
    private PreparedStatement statement;
    private String dataTableName = "routeSegment";

    public RouteSegmentDataDAOImpl(Connection connection){
        this.connection = connection;
    }


    @Override
    public boolean doCreate(routeSegmentData DO) throws Exception {
        String sql = "INSERT INTO " + dataTableName + " VALUES (?,?,?,?,?,?,?,?,?,?)";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1,DO.getID());
        this.statement.setString(2 ,DO.getUpperLimit());
        this.statement.setString(3,DO.getUpperLimitUOM());
        this.statement.setString(4,DO.getLowerLimit());
        this.statement.setString(5,DO.getLowerLimitUOM());
        this.statement.setString(6,DO.getStartPointChoice());
        this.statement.setString(7,DO.getStartPoint());
        this.statement.setString(8,DO.getEndPointChoice());
        this.statement.setString(9,DO.getEndPoint());
        this.statement.setString(10,DO.getRouteFormed());
        return this.statement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdata(routeSegmentData DO) throws Exception {
        String sql = "UPDATE " + dataTableName +
                " SET ID = ?, upperLimit = ?, upperLimitUOM = ?, lowerLimit = ?, lowerLimitUOM = ?," +
                " startPointChoice = ?, startPoint = ?, endPointChoice = ?, endPoint = ?,routeFormed = ? " +
                "WHERE ID=?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1,DO.getID());
        this.statement.setString(2 ,DO.getUpperLimit());
        this.statement.setString(3,DO.getUpperLimitUOM());
        this.statement.setString(4,DO.getLowerLimit());
        this.statement.setString(5,DO.getLowerLimitUOM());
        this.statement.setString(6,DO.getStartPointChoice());
        this.statement.setString(7,DO.getStartPoint());
        this.statement.setString(8,DO.getEndPointChoice());
        this.statement.setString(9,DO.getEndPoint());
        this.statement.setString(10,DO.getRouteFormed());
        this.statement.setString(11,DO.getID());
        return this.statement.executeUpdate() > 0;
    }

    @Override
    public routeSegmentData doFindByID(String ID) throws Exception {
        routeSegmentData DO = null;
        String sql = "SELECT * FROM " + dataTableName + " WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , ID);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new routeSegmentData();
            DO.setID(resultSet.getString("ID"));
            DO.setUpperLimit(resultSet.getString("upperLimit"));
            DO.setUpperLimitUOM(resultSet.getString("upperLimitUOM"));
            DO.setLowerLimit(resultSet.getString("lowerLimit"));
            DO.setLowerLimitUOM(resultSet.getString("lowerLimitUOM"));
            DO.setStartPointChoice(resultSet.getString("startPointChoice"));
            DO.setStartPoint(resultSet.getString("startPoint"));
            DO.setEndPointChoice(resultSet.getString("endPointChoice"));
            DO.setEndPoint(resultSet.getString("endPoint"));
            DO.setRouteFormed(resultSet.getString("routeFormed"));
        }
        return DO;
    }

    @Override
    public List<routeSegmentData> doFindByRouteFormed(String routeFormed) throws Exception {
        List<routeSegmentData> routeSegmentDataList = new ArrayList<>();
        String sql = "SELECT * FROM " + dataTableName + " WHERE routeFormed = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , routeFormed);
        ResultSet resultSet = this.statement.executeQuery();

        while (resultSet.next()){
            routeSegmentData DO = null;
            DO = new routeSegmentData();
            DO.setID(resultSet.getString("ID"));
            DO.setUpperLimit(resultSet.getString("upperLimit"));
            DO.setUpperLimitUOM(resultSet.getString("upperLimitUOM"));
            DO.setLowerLimit(resultSet.getString("lowerLimit"));
            DO.setLowerLimitUOM(resultSet.getString("lowerLimitUOM"));
            DO.setStartPointChoice(resultSet.getString("startPointChoice"));
            DO.setStartPoint(resultSet.getString("startPoint"));
            DO.setEndPointChoice(resultSet.getString("endPointChoice"));
            DO.setEndPoint(resultSet.getString("endPoint"));
            DO.setRouteFormed(resultSet.getString("routeFormed"));

            routeSegmentDataList.add(DO);
        }


        return routeSegmentDataList;
    }

    @Override
    public List<routeSegmentData> findAll() throws Exception {
        List<routeSegmentData> all = new ArrayList<routeSegmentData>();
        String sql = "SELECT * FROM " + dataTableName ;

        this.statement = this.connection.prepareStatement(sql);
        ResultSet resultSet = this.statement.executeQuery();
        while (resultSet.next()){
            routeSegmentData DO = null;
            DO = new routeSegmentData();
            DO.setID(resultSet.getString("ID"));
            DO.setUpperLimit(resultSet.getString("upperLimit"));
            DO.setUpperLimitUOM(resultSet.getString("upperLimitUOM"));
            DO.setLowerLimit(resultSet.getString("lowerLimit"));
            DO.setLowerLimitUOM(resultSet.getString("lowerLimitUOM"));
            DO.setStartPointChoice(resultSet.getString("startPointChoice"));
            DO.setStartPoint(resultSet.getString("startPoint"));
            DO.setEndPointChoice(resultSet.getString("endPointChoice"));
            DO.setEndPoint(resultSet.getString("endPoint"));
            DO.setRouteFormed(resultSet.getString("routeFormed"));

            all.add(DO);
        }
        return all;
    }
}

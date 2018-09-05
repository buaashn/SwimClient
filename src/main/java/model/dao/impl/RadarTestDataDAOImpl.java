package model.dao.impl;


import model.DO.RadarTestData;
import model.dao.IRadarTestDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RadarTestDataDAOImpl implements IRadarTestDataDAO {

    private Connection connection;
    private PreparedStatement statement;
    private String nameOfDataTable = "radarTest";


    public RadarTestDataDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean doCreate(RadarTestData DO) throws Exception {
        return false;
    }

    @Override
    public boolean doUpdata(RadarTestData DO) throws Exception {
        return false;
    }

    @Override
    public List<RadarTestData> doFindByTime(String time) throws Exception {
        List<RadarTestData> all = new ArrayList<RadarTestData>();
        String sql = "SELECT * FROM " + nameOfDataTable + " WHERE storeTime = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , time);

        ResultSet resultSet = this.statement.executeQuery();
        while (resultSet.next()) {
            RadarTestData DO = new RadarTestData();
            DO.setLontitude(resultSet.getString("longtitude"));
            DO.setLatitude(resultSet.getString("latitude"));
            DO.setFlightTag(resultSet.getString("flightTag"));
            DO.setDirection(resultSet.getString("direction"));
            DO.setStoreTime(time);
            all.add(DO);
        }
        connection.close();
        return all;
    }

    @Override
    public List<RadarTestData> doFindByFlightTag(String flightTag) throws Exception {
        List<RadarTestData> all = new ArrayList<RadarTestData>();
        String sql = "SELECT * FROM " + nameOfDataTable + " WHERE flightTag = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , flightTag);

        ResultSet resultSet = this.statement.executeQuery();
        while (resultSet.next()) {
            RadarTestData DO = new RadarTestData();
            DO.setFlightTag(flightTag);
            DO.setLontitude(resultSet.getString("longtitude"));
            DO.setLatitude(resultSet.getString("latitude"));
            DO.setStoreTime(resultSet.getString("storeTime"));
            DO.setDirection(resultSet.getString("direction"));
            all.add(DO);
        }
        return all;
    }
}

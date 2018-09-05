package model.dao.impl;


import model.DO.RadarData;
import model.dao.IRadarDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RadarDataDAOImpl implements IRadarDataDAO {

    private Connection connection;
    private PreparedStatement statement;
    private String nameOfDataTable = "T_RADAR_TRACK_20180104_CON_T";

    public RadarDataDAOImpl(Connection connection){
        this.connection = connection;
    }

    public RadarDataDAOImpl(Connection connection, String nameOfDataTable){
        this.connection = connection;
        this.nameOfDataTable = nameOfDataTable;
    }

    @Override
    public boolean doCreate(RadarData DO) throws Exception {
        return false;
    }

    @Override
    public boolean doUpdata(RadarData DO) throws Exception {
        return false;
    }

    @Override
    public List<RadarData> doFindByTime(String time) throws Exception {
        List<RadarData> all = new ArrayList<RadarData>();
        String sql = "SELECT * FROM " + nameOfDataTable + " WHERE STORE_TIME = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , time);

        ResultSet resultSet = this.statement.executeQuery();
        while (resultSet.next()) {
            RadarData DO = new RadarData();
            DO.setID(resultSet.getString("ID"));
            DO.setNewID(resultSet.getString("NEW_ID"));
            DO.setFlightTag(resultSet.getString("FLIGHT_TAG"));
            DO.setSSR(resultSet.getString("SSR"));
            DO.setLontitude(resultSet.getString("LONGITUDE"));
            DO.setLatitude(resultSet.getString("LATITUDE"));
            DO.setStoreTime(time);
            all.add(DO);
        }
        return all;
    }

    @Override
    public List<RadarData> doFindByFlightTag(String flightTag) throws Exception {
        List<RadarData> all = new ArrayList<RadarData>();
        String sql = "SELECT * FROM " + nameOfDataTable + " WHERE FLIGHT_TAG = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , flightTag);

        ResultSet resultSet = this.statement.executeQuery();
        while (resultSet.next()) {
            RadarData DO = new RadarData();
            DO.setID(resultSet.getString("ID"));
            DO.setNewID(resultSet.getString("NEW_ID"));
            DO.setFlightTag(flightTag);
            DO.setSSR(resultSet.getString("SSR"));
            DO.setLontitude(resultSet.getString("LONGITUDE"));
            DO.setLatitude(resultSet.getString("LATITUDE"));
            DO.setStoreTime(resultSet.getString("STORE_TIME"));
            all.add(DO);
        }
        return all;
    }

    @Override
    public List<RadarData> doTopFind(int number) throws Exception {
        List<RadarData> all = new ArrayList<RadarData>();
        String sql = "SELECT * FROM  T_RADAR_TRACK_20180104_CON_T WHERE ROWNUM <= ? ORDER BY ROWNUM ASC";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setInt(1 , number);

        ResultSet resultSet = this.statement.executeQuery();
        while (resultSet.next()) {
            RadarData DO = new RadarData();
            DO.setID(resultSet.getString("ID"));
            DO.setNewID(resultSet.getString("NEW_ID"));
            DO.setFlightTag(resultSet.getString("FLIGHT_TAG"));
            DO.setSSR(resultSet.getString("SSR"));
            DO.setLontitude(resultSet.getString("LONGITUDE"));
            DO.setLatitude(resultSet.getString("LATITUDE"));
            DO.setStoreTime(resultSet.getString("STORE_TIME"));
            all.add(DO);
        }
        this.statement.close();
        return all;
    }
}

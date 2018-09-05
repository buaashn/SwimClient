package model.dao.impl;


import model.DO.AirportData;
import model.dao.IAirportDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AirportDataDAOImpl implements IAirportDataDAO {
    private Connection connection;
    private PreparedStatement statement;
    private String nameOfDataTable = "airport";

    public AirportDataDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean doCreate(AirportData DO) throws Exception {
        if(this.doFindByCode(DO.getCodeICAO()) == null){
            String sql = "INSERT INTO airport VALUES (?,?,?,?,?,?,?,?)";
            this.statement = this.connection.prepareStatement(sql);
            this.statement.setString(1,DO.getID());
            this.statement.setString(2 ,DO.getCodeICAO());
            this.statement.setString(3 ,DO.getNameEn());
            this.statement.setString(4 ,DO.getControlType());
            this.statement.setString(5 ,DO.getDesignatorIATA());
            this.statement.setString(6 ,DO.getCity());
            this.statement.setString(7 ,DO.getLatitude());
            this.statement.setString(8 ,DO.getLongtitude());
            return this.statement.executeUpdate() > 0;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean doUpdata(AirportData DO) throws Exception {
        String sql = "UPDATE airport SET code = ?, name = ?, controlType = ?, designatorIATA=?,city=?,latitude=?,longtitude=? WHERE ID=?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1,DO.getCodeICAO());
        this.statement.setString(2 ,DO.getNameEn());
        this.statement.setString(3 ,DO.getControlType());
        this.statement.setString(4 ,DO.getDesignatorIATA());
        this.statement.setString(5 ,DO.getCity());
        this.statement.setString(6 ,DO.getLatitude());
        this.statement.setString(7 ,DO.getLongtitude());
        this.statement.setString(8 ,DO.getID());
        return this.statement.executeUpdate() > 0;
    }

    @Override
    public AirportData doFindByCode(String code) throws Exception {
        AirportData DO = null;
        String sql = "SELECT * FROM airport WHERE code = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , code);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new AirportData();
            DO.setID(resultSet.getString("ID"));
            DO.setCodeICAO(resultSet.getString("code"));
            DO.setControlType(resultSet.getString("controlType"));
            DO.setDesignatorIATA(resultSet.getString("designatorIATA"));
            DO.setCity(resultSet.getString("city"));
            DO.setNameEn(resultSet.getString("name"));
            DO.setLatitude(resultSet.getString("latitude"));
            DO.setLongtitude(resultSet.getString("longtitude"));
        }
        return DO;
    }

    @Override
    public AirportData doFindByID(String ID) throws Exception {
        AirportData DO = null;

        String sql = "SELECT * FROM airport WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , ID);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new AirportData();
            DO.setID(resultSet.getString("ID"));
            DO.setCodeICAO(resultSet.getString("code"));
            DO.setControlType(resultSet.getString("controlType"));
            DO.setDesignatorIATA(resultSet.getString("designatorIATA"));
            DO.setCity(resultSet.getString("city"));
            DO.setNameEn(resultSet.getString("name"));
            DO.setLatitude(resultSet.getString("latitude"));
            DO.setLongtitude(resultSet.getString("longtitude"));
        }
        return DO;
    }

    @Override
    public List<AirportData> findAll() throws Exception {
        List<AirportData> all = new ArrayList<AirportData>();
        String sql = "SELECT * FROM " + nameOfDataTable ;
        this.statement = this.connection.prepareStatement(sql);
        ResultSet resultSet = this.statement.executeQuery();
        while (resultSet.next()){
            AirportData DO = new AirportData();
            DO.setID(resultSet.getString("ID"));
            DO.setCodeICAO(resultSet.getString("code"));
            DO.setControlType(resultSet.getString("controlType"));
            DO.setDesignatorIATA(resultSet.getString("designatorIATA"));
            DO.setCity(resultSet.getString("city"));
            DO.setNameEn(resultSet.getString("name"));
            DO.setLatitude(resultSet.getString("latitude"));
            DO.setLongtitude(resultSet.getString("longtitude"));
            all.add(DO);
        }

        return all;
    }
}

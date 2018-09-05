package model.dao.impl;


import model.DO.FaaDesignatedPointData;
import model.dao.IFaaDesignatedPointDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FaaDesignatedPointDataDAOImpl implements IFaaDesignatedPointDataDAO {
    private String dataTableName = "faaDesignatedPoint";
    private Connection connection;
    private PreparedStatement statement;

    public FaaDesignatedPointDataDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean doCreate(FaaDesignatedPointData DO) throws Exception {
        String sql = "INSERT INTO " + dataTableName + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1,DO.getID());
        this.statement.setString(2 ,DO.getDesignator());
        this.statement.setString(3,DO.getType());
        this.statement.setString(4,DO.getName());
        this.statement.setString(5,DO.getLatitude());
        this.statement.setString(6,DO.getLongtitude());
        this.statement.setString(7,DO.getNoteID());
        this.statement.setString(8,DO.getNote());
        this.statement.setString(9,DO.getFixTypePublicationCategory());
        this.statement.setString(10,DO.getFixMinimumReceptionAltitude());
        this.statement.setString(11,DO.getFixState());
        this.statement.setString(12,DO.getFixARTCC());
        this.statement.setString(13,DO.getICAORegCode());
        return this.statement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdata(FaaDesignatedPointData DO) throws Exception {
        return false;
    }

    @Override
    public FaaDesignatedPointData doFindByID(String ID) throws Exception {
        FaaDesignatedPointData DO = null;
        String sql = "SELECT * FROM " + dataTableName + " WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , ID);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new FaaDesignatedPointData();
            DO.setID(resultSet.getString("ID"));
            DO.setDesignator(resultSet.getString("designator"));
            DO.setType(resultSet.getString("type"));
            DO.setName(resultSet.getString("name"));
            DO.setLatitude(resultSet.getString("latitude"));
            DO.setLongtitude(resultSet.getString("longtitude"));
            DO.setNoteID(resultSet.getString("noteID"));
            DO.setNote(resultSet.getString("note"));
            DO.setFixTypePublicationCategory(resultSet.getString("fixTypePublicationCategory"));
            DO.setFixMinimumReceptionAltitude(resultSet.getString("fixMinimumReceptionAltitude"));
            DO.setFixState(resultSet.getString("fixState"));
            DO.setFixARTCC(resultSet.getString("fixARTCC"));
            DO.setICAORegCode(resultSet.getString("ICAORegCode"));
        }
        return DO;
    }

    @Override
    public List<FaaDesignatedPointData> findAll() throws Exception {
        List<FaaDesignatedPointData> all = new ArrayList<FaaDesignatedPointData>();
        String sql = "SELECT * FROM " + dataTableName ;
        this.statement = this.connection.prepareStatement(sql);
        ResultSet resultSet = this.statement.executeQuery();
        while (resultSet.next()){
            FaaDesignatedPointData DO = null;
            DO = new FaaDesignatedPointData();
            DO.setID(resultSet.getString("ID"));
            DO.setDesignator(resultSet.getString("designator"));
            DO.setType(resultSet.getString("type"));
            DO.setName(resultSet.getString("name"));
            DO.setLatitude(resultSet.getString("latitude"));
            DO.setLongtitude(resultSet.getString("longtitude"));
            DO.setNoteID(resultSet.getString("noteID"));
            DO.setNote(resultSet.getString("note"));
            DO.setFixTypePublicationCategory(resultSet.getString("fixTypePublicationCategory"));
            DO.setFixMinimumReceptionAltitude(resultSet.getString("fixMinimumReceptionAltitude"));
            DO.setFixState(resultSet.getString("fixState"));
            DO.setFixARTCC(resultSet.getString("fixARTCC"));
            DO.setICAORegCode(resultSet.getString("ICAORegCode"));
            all.add(DO);
        }

        return all;
    }
}

package model.dao.impl;


import model.DO.FaaRouteData;
import model.dao.IFaaRouteDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class FaaRouteDataDAOImpl implements IFaaRouteDataDAO {
    private String dataTableName = "faaRoute";
    private Connection connection;
    private PreparedStatement statement;

    public FaaRouteDataDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean doCreate(FaaRouteData DO) throws Exception {
        String sql = "INSERT INTO " + dataTableName + " VALUES (?,?,?,?,?,?,?)";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1,DO.getID());
        this.statement.setString(2 ,DO.getDesignatorSecondLetter());
        this.statement.setString(3,DO.getDesignatorNumber());
        this.statement.setString(4,DO.getType());
        this.statement.setString(5,DO.getPropertyName());
        this.statement.setString(6,DO.getNoteID());
        this.statement.setString(7,DO.getNote());

        return this.statement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdata(FaaRouteData DO) throws Exception {
        return false;
    }

    @Override
    public FaaRouteData doFindByID(String ID) throws Exception {
        FaaRouteData DO = null;
        String sql = "SELECT * FROM " + dataTableName + " WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , ID);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new FaaRouteData();
            DO.setID(resultSet.getString("ID"));
            DO.setDesignatorSecondLetter(resultSet.getString("designatorSecondLetter"));
            DO.setDesignatorNumber(resultSet.getString("designatorNumber"));
            DO.setType(resultSet.getString("type"));
            DO.setPropertyName(resultSet.getString("propertyName"));
            DO.setNoteID(resultSet.getString("noteID"));
            DO.setNote(resultSet.getString("note"));

        }
        return DO;
    }

    @Override
    public List<FaaRouteData> findAll() throws Exception {
        return null;
    }
}

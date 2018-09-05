package model.dao.impl;


import model.DO.ArrivalLegData;
import model.dao.IArrivalLegDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ArrivalLegDataDAOImpl implements IArrivalLegDataDAO {
    private Connection connection;
    private PreparedStatement statement;

    public ArrivalLegDataDAOImpl(Connection connection){
        this.connection = connection;
    }
    @Override
    public boolean doCreate(ArrivalLegData DO) throws Exception {
        String sql = "INSERT INTO arrivalLeg VALUES (?,?,?,?,?,?,?,?,?,?)";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1,DO.getID());
        this.statement.setString(2 ,DO.getUpperLimitAltitude());
        this.statement.setString(3,DO.getUpperLimitAltitudeUOM());
        this.statement.setString(4,DO.getLowerLimitAltitude());
        this.statement.setString(5,DO.getLowerLimitAltitudeUOM());
        this.statement.setString(6,DO.getStartPointChoice());
        this.statement.setString(7,DO.getStartPoint());
        this.statement.setString(8,DO.getEndPointChoice());
        this.statement.setString(9,DO.getEndPoint());
        this.statement.setString(10,DO.getArrival());
        return this.statement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdata(ArrivalLegData DO) throws Exception {
        return false;
    }

    @Override
    public ArrivalLegData doFindByID(String ID) throws Exception {
        ArrivalLegData DO = null;
        String sql = "SELECT * FROM arrivalLeg WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , ID);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new ArrivalLegData();
            DO.setID(resultSet.getString("ID"));
            DO.setUpperLimitAltitude(resultSet.getString("upperLimitAltitude"));
            DO.setUpperLimitAltitudeUOM(resultSet.getString("upperLimitAltitudeUOM"));
            DO.setLowerLimitAltitude(resultSet.getString("lowerLimitAltitude"));
            DO.setLowerLimitAltitudeUOM(resultSet.getString("lowerLimitAltitudeUOM"));
            DO.setStartPointChoice(resultSet.getString("startPointChoice"));
            DO.setStartPoint(resultSet.getString("startPoint"));
            DO.setEndPointChoice(resultSet.getString("endPointChoice"));
            DO.setEndPoint(resultSet.getString("endPoint"));
            DO.setArrival(resultSet.getString("arrival"));
        }
        return DO;
    }

    @Override
    public List<ArrivalLegData> findAll() throws Exception {
        return null;
    }
}

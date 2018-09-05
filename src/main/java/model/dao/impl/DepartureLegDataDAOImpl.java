package model.dao.impl;


import model.DO.DepartureLegData;
import model.dao.IDepartureLegDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DepartureLegDataDAOImpl implements IDepartureLegDataDAO {
    private Connection connection;
    private PreparedStatement statement;

    public DepartureLegDataDAOImpl(Connection connection){
        this.connection = connection;
    }
    @Override
    public boolean doCreate(DepartureLegData DO) throws Exception {
        String sql = "INSERT INTO departureLeg VALUES (?,?,?,?,?,?,?,?,?,?)";
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
        this.statement.setString(10,DO.getDeparture());
        return this.statement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdata(DepartureLegData DO) throws Exception {
        return false;
    }

    @Override
    public DepartureLegData doFindByID(String ID) throws Exception {
        DepartureLegData DO = null;
        String sql = "SELECT * FROM departureLeg WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , ID);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new DepartureLegData();
            DO.setID(resultSet.getString("ID"));
            DO.setUpperLimitAltitude(resultSet.getString("upperLimitAltitude"));
            DO.setUpperLimitAltitudeUOM(resultSet.getString("upperLimitAltitudeUOM"));
            DO.setLowerLimitAltitude(resultSet.getString("lowerLimitAltitude"));
            DO.setLowerLimitAltitudeUOM(resultSet.getString("lowerLimitAltitudeUOM"));
            DO.setStartPointChoice(resultSet.getString("startPointChoice"));
            DO.setStartPoint(resultSet.getString("startPoint"));
            DO.setEndPointChoice(resultSet.getString("endPointChoice"));
            DO.setEndPoint(resultSet.getString("endPoint"));
            DO.setDeparture(resultSet.getString("departure"));
        }
        return DO;
    }

    @Override
    public List<DepartureLegData> findAll() throws Exception {
        return null;
    }
}

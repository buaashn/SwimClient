package model.dao.impl;

import model.DO.DistanceIndicationData;
import model.dao.IDistanceIndicationDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DistanceIndicationDataDAOImpl implements IDistanceIndicationDataDAO {

    private String dataTableName = "distanceIndication";
    private Connection connection;
    private PreparedStatement statement;

    public DistanceIndicationDataDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean doCreate(DistanceIndicationData DO) throws Exception {
        String sql = "INSERT INTO " + dataTableName + " VALUES (?,?,?,?,?)";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1,DO.getID());
        this.statement.setString(2 ,DO.getDistance());
        this.statement.setString(3,DO.getDistanceUOM());
        this.statement.setString(4,DO.getFix());
        this.statement.setString(5,DO.getPointChoiceNavaidSystem());
        return this.statement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdata(DistanceIndicationData DO) throws Exception {
        return false;
    }

    @Override
    public DistanceIndicationData doFindByID(String ID) throws Exception {
        DistanceIndicationData DO = null;
        String sql = "SELECT * FROM " + dataTableName + " WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , ID);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new DistanceIndicationData();
            DO.setID(resultSet.getString("ID"));
            DO.setDistance(resultSet.getString("distance"));
            DO.setDistanceUOM(resultSet.getString("distanceUOM"));
            DO.setFix(resultSet.getString("fix"));
            DO.setPointChoiceNavaidSystem(resultSet.getString("pointChoiceNavaidSystem"));
        }
        return DO;
    }

    @Override
    public List<DistanceIndicationData> findAll() throws Exception {
        return null;
    }
}

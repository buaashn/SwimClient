package model.dao.impl;

import model.DO.AngleIndicationData;
import model.dao.IAngleIndicationDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AngleIndicationDataDAOImpl implements IAngleIndicationDataDAO {
    private Connection connection;
    private PreparedStatement statement;

    public AngleIndicationDataDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean doCreate(AngleIndicationData DO) throws Exception {
        String sql = "INSERT INTO angleIndication VALUES (?,?,?,?)";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1,DO.getID());
        this.statement.setString(2 ,DO.getAngle());
        this.statement.setString(3,DO.getAngleType());
        this.statement.setString(4,DO.getPointChoice_navaidSystem());
        return this.statement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdata(AngleIndicationData DO) throws Exception {
        return false;
    }

    @Override
    public AngleIndicationData doFindByID(String ID) throws Exception {
        AngleIndicationData DO = null;
        String sql = "SELECT * FROM angleIndication WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , ID);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new AngleIndicationData();
            DO.setID(resultSet.getString("ID"));
            DO.setAngle(resultSet.getString("angle"));
            DO.setAngleType(resultSet.getString("angleType"));
            DO.setPointChoice_navaidSystem(resultSet.getString("pointChoice_navaidSystem"));
        }
        return DO;
    }
}

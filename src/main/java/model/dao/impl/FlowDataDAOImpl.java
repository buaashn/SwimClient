package model.dao.impl;

import model.DO.FlowData;
import model.dao.IFlowDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class FlowDataDAOImpl implements IFlowDataDAO {

    private String dataTableName = "flow";
    private Connection connection;
    private PreparedStatement statement;

    public FlowDataDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean doCreate(FlowData DO) throws Exception {
        String sql = "INSERT INTO " + dataTableName + " VALUES (?,?,?,?,?,?,?)";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1,DO.getID());
        this.statement.setString(2 ,DO.getFlowName());
        this.statement.setString(3,DO.getFlowID());
        this.statement.setString(4,DO.getDownstreamFlowElementChoice());
        this.statement.setString(5,DO.getDownstreamFlowElement());
        this.statement.setString(6,DO.getUpstreamFlowElementChoice());
        this.statement.setString(7,DO.getUpstreamFlowElement());
        return this.statement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdata(FlowData DO) throws Exception {
        return false;
    }

    @Override
    public FlowData doFindByID(String ID) throws Exception {
        FlowData DO = null;
        String sql = "SELECT * FROM " + dataTableName + " WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , ID);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new FlowData();
            DO.setID(resultSet.getString("ID"));
            DO.setFlowName(resultSet.getString("flowName"));
            DO.setFlowID(resultSet.getString("flowID"));
            DO.setDownstreamFlowElementChoice(resultSet.getString("downstreamFlowElementChoice"));
            DO.setDownstreamFlowElement(resultSet.getString("downstreamFlowElement"));
            DO.setUpstreamFlowElementChoice(resultSet.getString("upstreamFlowElementChoice"));
            DO.setUpstreamFlowElement(resultSet.getString("upstreamFlowElement"));
        }
        return DO;
    }

    @Override
    public List<FlowData> findAll() throws Exception {
        return null;
    }
}

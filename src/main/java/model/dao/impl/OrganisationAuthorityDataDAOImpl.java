package model.dao.impl;


import model.DO.OrganisationAuthorityData;
import model.dao.IOrganisationAuthorityDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrganisationAuthorityDataDAOImpl implements IOrganisationAuthorityDataDAO {

    private String dataTableName = "organisationAuthority";
    private Connection connection;
    private PreparedStatement statement;

    public OrganisationAuthorityDataDAOImpl(Connection connection){
        this.connection = connection;
    }


    @Override
    public boolean doCreate(OrganisationAuthorityData DO) throws Exception {
        String sql = "INSERT INTO " + dataTableName + " VALUES (?,?,?,?)";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1,DO.getID());
        this.statement.setString(2 ,DO.getName());
        this.statement.setString(3,DO.getDesignator());
        this.statement.setString(4,DO.getType());
        return this.statement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdata(OrganisationAuthorityData DO) throws Exception {
        return false;
    }

    @Override
    public OrganisationAuthorityData doFindByID(String ID) throws Exception {
        OrganisationAuthorityData DO = null;
        String sql = "SELECT * FROM " + dataTableName + " WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , ID);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new OrganisationAuthorityData();
            DO.setID(resultSet.getString("ID"));
            DO.setName(resultSet.getString("name"));
            DO.setDesignator(resultSet.getString("designator"));
            DO.setType(resultSet.getString("type"));
        }
        return DO;
    }
}

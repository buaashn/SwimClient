package model.dao.factory;


import model.dao.IOrganisationAuthorityDataDAO;
import model.dao.impl.OrganisationAuthorityDataDAOImpl;

import java.sql.Connection;

public class OrganisationAuthorityDataDAOFactory {
    public static IOrganisationAuthorityDataDAO getOrganisationAuthorityDataInstance (Connection connection){
        return new OrganisationAuthorityDataDAOImpl(connection);
    }
}

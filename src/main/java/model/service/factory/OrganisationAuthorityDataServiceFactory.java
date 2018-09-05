package model.service.factory;


import model.service.IOrganisationAuthorityDataService;
import model.service.impl.OrganisationAuthorityDataServiceImpl;

public class OrganisationAuthorityDataServiceFactory {
    public static IOrganisationAuthorityDataService getOrganisationAuthorityDataServiceInstance() {
        return new OrganisationAuthorityDataServiceImpl();
    }
}

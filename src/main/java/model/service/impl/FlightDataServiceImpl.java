package model.service.impl;


import model.DO.FlightData;
import model.connect.DatabaseConnection;
import model.dao.factory.FlightDataDAOFactory;
import model.service.IFlightDataService;

public class FlightDataServiceImpl implements IFlightDataService {
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public FlightData getFlightData(Integer ids) throws Exception {
        try {
            return FlightDataDAOFactory.getIFlightDataDAOInstance(this.dbc.getDbConnection()).doFindByID(ids);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.databaseClose();
        }
    }
}

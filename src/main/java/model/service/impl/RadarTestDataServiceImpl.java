package model.service.impl;



import model.DO.RadarTestData;
import model.connect.DatabaseConnection;
import model.dao.factory.RadarTestDataDAOFactory;
import model.service.IRadarTestDataService;

import java.util.List;

public class RadarTestDataServiceImpl implements IRadarTestDataService {

    private static DatabaseConnection dbc = new DatabaseConnection();


    @Override
    public List<RadarTestData> getRadaTestDataByTime(String time) {

        try {
            return RadarTestDataDAOFactory.getRadarDataDAOInstance(dbc.getDbConnection()).doFindByTime(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

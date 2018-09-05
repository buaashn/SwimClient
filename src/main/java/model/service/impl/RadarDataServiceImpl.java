package model.service.impl;



import model.DO.RadarData;
import model.connect.OracleDatabaseConnection;
import model.dao.factory.RadarDataDAOFactory;
import model.service.IRadarDataService;

import java.util.List;

public class RadarDataServiceImpl implements IRadarDataService {

    private static OracleDatabaseConnection oracledbc = new OracleDatabaseConnection();

    @Override
    public String[] getRadarData(int numberOfData) {
        List<RadarData> radarDataList = null;
        try {
            radarDataList = RadarDataDAOFactory.getRadarDataDAOInstance(oracledbc.getOracleDatabaseConnection()).doTopFind(numberOfData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] radarDataStringList = new String[radarDataList.size()];
        for(int  i = 0; i < radarDataList.size(); i++){
            radarDataStringList[i] = (radarDataList.get(i).getID() + "," +
                    radarDataList.get(i).getNewID() + "," +
                    radarDataList.get(i).getSSR() + "," +
                    radarDataList.get(i).getFlightTag() + "," +
                    radarDataList.get(i).getLatitude() + "," +
                    radarDataList.get(i).getLontitude() + "," +
                    radarDataList.get(i).getStoreTime()
            );
        }
        return radarDataStringList;
    }
}

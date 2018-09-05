package model.service;



import model.DO.RadarTestData;

import java.util.List;

public interface IRadarTestDataService {
    public List<RadarTestData> getRadaTestDataByTime(String time);
}

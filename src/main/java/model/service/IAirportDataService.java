package model.service;

public interface IAirportDataService {
    /**
     *  读取原始数据并存入数据库
     */
    public void readDataFromXml();

    public void readDataFromXmlToUpdate();
}
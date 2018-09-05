package model.service;

public interface IFaaPointDataService {
    public void readDataFromXml();

    /**
     * 从数据库中读取位置数据，并存入.js文件，作为静态数据进行读取
     * 从数据库中读取位置数据，并存入.js文件，作为静态数据进行读取
     */
    public void getLocationToStatic() throws Exception;
}

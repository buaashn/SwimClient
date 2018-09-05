package model.service;

public interface IRouteSegmentDataService {
    /**
     *  读取原始数据并存入数据库
     */
    public void readDataFromXml();

    /**
     *  更新数据
     */
    public void readDataFromXmlToUpdate();

    /**
     * 从数据库中读取位置数据，并存入.js文件，作为静态数据进行读取
     * 从数据库中读取位置数据，并存入.js文件，作为静态数据进行读取
     */
    public void getLocationToStatic() throws Exception;

    public void sortPoint() throws Exception;
}

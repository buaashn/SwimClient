package model.service;

public interface INavaidDataService {
    /**
     * 从xml文件中读取数据并存入数据库
     */
    public void readDataFromXml();

    /**
     * 从数据库中读取位置数据，并存入.js文件，作为静态数据进行读取
     * 从数据库中读取位置数据，并存入.js文件，作为静态数据进行读取
     */
    public void getLocationToStatic() throws Exception;

    /**
     * 数据融合
     */
    public void dataFusion() throws Exception;
}

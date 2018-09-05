package model.dao;

import model.DO.RadarData;

import java.util.List;

public interface IRadarDataDAO {
    /**
     * 建立存入新的数据
     * @param DO AirportDataJumpStart简单对象类
     * @return
     * @throws Exception
     */
    public boolean doCreate(RadarData DO) throws Exception;

    /**
     * 更新数据库数据
     * @param DO
     * @return
     * @throws Exception
     */
    public boolean doUpdata(RadarData DO) throws Exception;

    /**
     * 根据时间查询
     * @param time
     * @return
     * @throws Exception
     */
    public List<RadarData> doFindByTime(String time) throws Exception;

    /**
     * 根据航班号查询
     * @param flightTag
     * @return
     * @throws Exception
     */
    public List<RadarData> doFindByFlightTag(String flightTag) throws Exception;

    /**
     * 根据航班号查询
     * @param number
     * @return
     * @throws Exception
     */
    public List<RadarData> doTopFind(int number) throws Exception;

}

package model.service;


import model.DO.FlightData;

public interface IFlightDataService {
    /**
     * 根据编号查找飞行数据，调用IFlightDataDAO.findByID()方法
     * @param ids 要查找的飞行数据编号
     * @return 如果能够查询到数据，则以DO对象形式返回，否则返回null
     * @throws Exception SQL执行异常
     */
    public FlightData getFlightData(Integer ids) throws Exception ;
}

package model.dao;


import model.DO.AirTrafficManagementServiceData;

public interface IAirTrafficManagementServiceDataDAO {
    /**
     * 建立存入新的数据
     * @param DO AirportDataJumpStart简单对象类
     * @return
     * @throws Exception
     */
    public boolean doCreate(AirTrafficManagementServiceData DO) throws Exception;

    /**
     * 更新数据库数据
     * @param DO
     * @return
     * @throws Exception
     */
    public boolean doUpdata(AirTrafficManagementServiceData DO) throws Exception;


    /**
     * 根据UUID查询
     * @param ID UUID
     * @return
     * @throws Exception
     */
    public AirTrafficManagementServiceData doFindByID(String ID) throws Exception;

}

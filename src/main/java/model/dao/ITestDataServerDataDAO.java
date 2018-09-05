package model.dao;


import model.DO.TestDataServerData;

public interface ITestDataServerDataDAO {
    /**
     * 建立存入新的数据
     * @param DO AirportDataJumpStart简单对象类
     * @return
     * @throws Exception
     */
    public boolean doCreate(TestDataServerData DO) throws Exception;
}

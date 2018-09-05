package model.dao;


import model.DO.TestDataReceiveData;

public interface ITestDataReceiveDataDAO {
    /**
     * 建立存入新的数据
     * @param DO AirportDataJumpStart简单对象类
     * @return
     * @throws Exception
     */
    public boolean doCreate(TestDataReceiveData DO) throws Exception;
}

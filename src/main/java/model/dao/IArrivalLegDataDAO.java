package model.dao;

import model.DO.ArrivalLegData;

import java.util.List;

public interface IArrivalLegDataDAO {
    /**
     * 建立存入新的数据
     * @param DO AirportDataJumpStart简单对象类
     * @return
     * @throws Exception
     */
    public boolean doCreate(ArrivalLegData DO) throws Exception;

    /**
     * 更新数据库数据
     * @param DO
     * @return
     * @throws Exception
     */
    public boolean doUpdata(ArrivalLegData DO) throws Exception;


    /**
     * 根据UUID查询
     * @param ID UUID
     * @return
     * @throws Exception
     */
    public ArrivalLegData doFindByID(String ID) throws Exception;

    /**
     * 查询数据表中的全部数据
     * @return 以简单对象列表方式返回数据库全部数据
     * @throws Exception
     */
    public List<ArrivalLegData> findAll() throws Exception;
}

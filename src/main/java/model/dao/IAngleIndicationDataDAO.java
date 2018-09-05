package model.dao;


import model.DO.AngleIndicationData;

public interface IAngleIndicationDataDAO {
    /**
     * 建立存入新的数据
     * @param DO AngleIndicationData
     * @return
     * @throws Exception
     */
    public boolean doCreate(AngleIndicationData DO) throws Exception;

    /**
     * 更新数据库数据
     * @param DO
     * @return
     * @throws Exception
     */
    public boolean doUpdata(AngleIndicationData DO) throws Exception;


    /**
     * 根据UUID查询
     * @param ID UUID
     * @return
     * @throws Exception
     */
    public AngleIndicationData doFindByID(String ID) throws Exception;
}

package model.dao;

import model.DO.OrganisationAuthorityData;

public interface IOrganisationAuthorityDataDAO {
    /**
     * 建立存入新的数据
     * @param DO AirportDataJumpStart简单对象类
     * @return
     * @throws Exception
     */
    public boolean doCreate(OrganisationAuthorityData DO) throws Exception;

    /**
     * 更新数据库数据
     * @param DO
     * @return
     * @throws Exception
     */
    public boolean doUpdata(OrganisationAuthorityData DO) throws Exception;


    /**
     * 根据UUID查询
     * @param ID UUID
     * @return
     * @throws Exception
     */
    public OrganisationAuthorityData doFindByID(String ID) throws Exception;

 
}

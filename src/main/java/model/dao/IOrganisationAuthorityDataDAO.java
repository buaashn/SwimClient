package model.dao;

import model.DO.OrganisationAuthorityData;

public interface IOrganisationAuthorityDataDAO {
    /**
     * ���������µ�����
     * @param DO AirportDataJumpStart�򵥶�����
     * @return
     * @throws Exception
     */
    public boolean doCreate(OrganisationAuthorityData DO) throws Exception;

    /**
     * �������ݿ�����
     * @param DO
     * @return
     * @throws Exception
     */
    public boolean doUpdata(OrganisationAuthorityData DO) throws Exception;


    /**
     * ����UUID��ѯ
     * @param ID UUID
     * @return
     * @throws Exception
     */
    public OrganisationAuthorityData doFindByID(String ID) throws Exception;

 
}

package model.dao;


import model.DO.AirTrafficManagementServiceData;

public interface IAirTrafficManagementServiceDataDAO {
    /**
     * ���������µ�����
     * @param DO AirportDataJumpStart�򵥶�����
     * @return
     * @throws Exception
     */
    public boolean doCreate(AirTrafficManagementServiceData DO) throws Exception;

    /**
     * �������ݿ�����
     * @param DO
     * @return
     * @throws Exception
     */
    public boolean doUpdata(AirTrafficManagementServiceData DO) throws Exception;


    /**
     * ����UUID��ѯ
     * @param ID UUID
     * @return
     * @throws Exception
     */
    public AirTrafficManagementServiceData doFindByID(String ID) throws Exception;

}

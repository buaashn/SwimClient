package model.dao;

import model.DO.DesignatedPointData;

public interface IDesignatedPointDataDAO {
    /**
     * ���������µ�����
     * @param DO AirportDataJumpStart�򵥶�����
     * @return
     * @throws Exception
     */
    public boolean doCreate(DesignatedPointData DO) throws Exception;

    /**
     * �������ݿ�����
     * @param DO
     * @return
     * @throws Exception
     */
    public boolean doUpdata(DesignatedPointData DO) throws Exception;


    /**
     * ����UUID��ѯ
     * @param ID UUID
     * @return
     * @throws Exception
     */
    public DesignatedPointData doFindByID(String ID) throws Exception;
}

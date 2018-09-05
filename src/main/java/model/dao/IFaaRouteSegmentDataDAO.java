package model.dao;


import model.DO.FaaRouteSegmentData;

import java.util.List;

public interface IFaaRouteSegmentDataDAO {
    /**
     * ���������µ�����
     * @param DO AirportDataJumpStart�򵥶�����
     * @return
     * @throws Exception
     */
    public boolean doCreate(FaaRouteSegmentData DO) throws Exception;

    /**
     * �������ݿ�����
     * @param DO
     * @return
     * @throws Exception
     */
    public boolean doUpdata(FaaRouteSegmentData DO) throws Exception;


    /**
     * ����UUID��ѯ
     * @param ID UUID
     * @return
     * @throws Exception
     */
    public FaaRouteSegmentData doFindByID(String ID) throws Exception;


    /**
     * ��ѯ���ݱ��е�ȫ������
     * @return �Լ򵥶����б�ʽ�������ݿ�ȫ������
     * @throws Exception
     */
    public List<FaaRouteSegmentData> findAll() throws Exception;
}

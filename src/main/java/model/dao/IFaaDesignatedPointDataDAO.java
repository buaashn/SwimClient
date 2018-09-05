package model.dao;



import model.DO.FaaDesignatedPointData;

import java.util.List;

public interface IFaaDesignatedPointDataDAO {
    /**
     * ���������µ�����
     * @param DO AirportDataJumpStart�򵥶�����
     * @return
     * @throws Exception
     */
    public boolean doCreate(FaaDesignatedPointData DO) throws Exception;

    /**
     * �������ݿ�����
     * @param DO
     * @return
     * @throws Exception
     */
    public boolean doUpdata(FaaDesignatedPointData DO) throws Exception;


    /**
     * ����UUID��ѯ
     * @param ID UUID
     * @return
     * @throws Exception
     */
    public FaaDesignatedPointData doFindByID(String ID) throws Exception;

    /**
     * ��ѯ���ݱ��е�ȫ������
     * @return �Լ򵥶����б�ʽ�������ݿ�ȫ������
     * @throws Exception
     */
    public List<FaaDesignatedPointData> findAll() throws Exception;
}

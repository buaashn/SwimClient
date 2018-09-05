package model.dao;



import model.DO.DistanceIndicationData;

import java.util.List;

public interface IDistanceIndicationDataDAO {
    /**
     * ���������µ�����
     * @param DO AirportDataJumpStart�򵥶�����
     * @return
     * @throws Exception
     */
    public boolean doCreate(DistanceIndicationData DO) throws Exception;

    /**
     * �������ݿ�����
     * @param DO
     * @return
     * @throws Exception
     */
    public boolean doUpdata(DistanceIndicationData DO) throws Exception;


    /**
     * ����UUID��ѯ
     * @param ID UUID
     * @return
     * @throws Exception
     */
    public DistanceIndicationData doFindByID(String ID) throws Exception;

    /**
     * ��ѯ���ݱ��е�ȫ������
     * @return �Լ򵥶����б�ʽ�������ݿ�ȫ������
     * @throws Exception
     */
    public List<DistanceIndicationData> findAll() throws Exception;
}

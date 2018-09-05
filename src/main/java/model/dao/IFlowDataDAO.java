package model.dao;


import model.DO.FlowData;

import java.util.List;

public interface IFlowDataDAO {
    /**
     * ���������µ�����
     * @param DO AirportDataJumpStart�򵥶�����
     * @return
     * @throws Exception
     */
    public boolean doCreate(FlowData DO) throws Exception;

    /**
     * �������ݿ�����
     * @param DO
     * @return
     * @throws Exception
     */
    public boolean doUpdata(FlowData DO) throws Exception;


    /**
     * ����UUID��ѯ
     * @param ID UUID
     * @return
     * @throws Exception
     */
    public FlowData doFindByID(String ID) throws Exception;

    /**
     * ��ѯ���ݱ��е�ȫ������
     * @return �Լ򵥶����б�ʽ�������ݿ�ȫ������
     * @throws Exception
     */
    public List<FlowData> findAll() throws Exception;
}

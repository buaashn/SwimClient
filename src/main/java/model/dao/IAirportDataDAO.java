package model.dao;



import model.DO.AirportData;

import java.util.List;


public interface IAirportDataDAO {
    /**
     * ���������µ�����
     * @param DO AirportDataJumpStart�򵥶�����
     * @return
     * @throws Exception
     */
    public boolean doCreate(AirportData DO) throws Exception;

    /**
     * �������ݿ�����
     * @param DO
     * @return
     * @throws Exception
     */
    public boolean doUpdata(AirportData DO) throws Exception;

    /**
     * �������ִ����ѯ
     * @param code
     * @return
     * @throws Exception
     */
    public AirportData doFindByCode(String code) throws Exception;

    /**
     * ����UUID��ѯ
     * @param ID UUID
     * @return
     * @throws Exception
     */
    public AirportData doFindByID(String ID) throws Exception;

    /**
     * ��ѯ���ݱ��е�ȫ������
     * @return �Լ򵥶����б�ʽ�������ݿ�ȫ������
     * @throws Exception
     */
    public List<AirportData> findAll() throws Exception;
}

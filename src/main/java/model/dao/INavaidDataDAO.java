package model.dao;


import model.DO.NavaidData;

import java.util.List;

public interface INavaidDataDAO {
    /**
     * ���������µ�����
     * @param DO AirportDataJumpStart�򵥶�����
     * @return
     * @throws Exception
     */
    public boolean doCreate(NavaidData DO) throws Exception;

    /**
     * �������ݿ�����
     * @param DO
     * @return
     * @throws Exception
     */
    public boolean doUpdata(NavaidData DO) throws Exception;

    /**
     * �������ִ����ѯ
     * @param code
     * @return
     * @throws Exception
     */
    public NavaidData doFindByName(String code) throws Exception;

    /**
     * ����UUID��ѯ
     * @param ID UUID
     * @return
     * @throws Exception
     */
    public NavaidData doFindByID(String ID) throws Exception;
    
    /**
     * ��ѯ���ݱ��е�ȫ������
     * @return �Լ򵥶����б�ʽ�������ݿ�ȫ������
     * @throws Exception
     */
    public List<NavaidData> findAll() throws Exception;
}

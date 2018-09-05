package model.dao;


import model.DO.AngleIndicationData;

public interface IAngleIndicationDataDAO {
    /**
     * ���������µ�����
     * @param DO AngleIndicationData
     * @return
     * @throws Exception
     */
    public boolean doCreate(AngleIndicationData DO) throws Exception;

    /**
     * �������ݿ�����
     * @param DO
     * @return
     * @throws Exception
     */
    public boolean doUpdata(AngleIndicationData DO) throws Exception;


    /**
     * ����UUID��ѯ
     * @param ID UUID
     * @return
     * @throws Exception
     */
    public AngleIndicationData doFindByID(String ID) throws Exception;
}

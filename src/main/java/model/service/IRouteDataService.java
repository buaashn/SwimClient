package model.service;

public interface IRouteDataService {
    /**
     *  ��ȡԭʼ���ݲ��������ݿ�
     */
    public void readDataFromXml();

    /**
     *  ��������
     */
    public void readDataFromXmlToUpdate();
    /**
     * �����ݿ��ж�ȡλ�����ݣ�������.js�ļ�����Ϊ��̬���ݽ��ж�ȡ
     * �����ݿ��ж�ȡλ�����ݣ�������.js�ļ�����Ϊ��̬���ݽ��ж�ȡ
     */
    public void getLocationToStatic() throws Exception;
}

package model.service;

public interface INavaidDataService {
    /**
     * ��xml�ļ��ж�ȡ���ݲ��������ݿ�
     */
    public void readDataFromXml();

    /**
     * �����ݿ��ж�ȡλ�����ݣ�������.js�ļ�����Ϊ��̬���ݽ��ж�ȡ
     * �����ݿ��ж�ȡλ�����ݣ�������.js�ļ�����Ϊ��̬���ݽ��ж�ȡ
     */
    public void getLocationToStatic() throws Exception;

    /**
     * �����ں�
     */
    public void dataFusion() throws Exception;
}

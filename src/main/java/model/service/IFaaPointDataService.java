package model.service;

public interface IFaaPointDataService {
    public void readDataFromXml();

    /**
     * �����ݿ��ж�ȡλ�����ݣ�������.js�ļ�����Ϊ��̬���ݽ��ж�ȡ
     * �����ݿ��ж�ȡλ�����ݣ�������.js�ļ�����Ϊ��̬���ݽ��ж�ȡ
     */
    public void getLocationToStatic() throws Exception;
}

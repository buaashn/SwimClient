package model.service;


import model.DO.FlightData;

public interface IFlightDataService {
    /**
     * ���ݱ�Ų��ҷ������ݣ�����IFlightDataDAO.findByID()����
     * @param ids Ҫ���ҵķ������ݱ��
     * @return ����ܹ���ѯ�����ݣ�����DO������ʽ���أ����򷵻�null
     * @throws Exception SQLִ���쳣
     */
    public FlightData getFlightData(Integer ids) throws Exception ;
}

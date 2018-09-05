package model.dao;



import model.DO.FlightData;

import java.util.List;
import java.util.Set;

/**
 * ���ݲ����ӿ�
 * @author sdushn
 */
public interface IFlightDataDAO {

    /**
     * ʵ�����ݿ�����Ӳ���
     * @param DO ������Ҫ�������ݵ�DO����
     * @return ���ݱ���ɹ�����true�����򷵻�false
     * @throws Exception SQLִ���쳣
     */
    public boolean doCreate(FlightData DO) throws Exception;

    /**
     * ʵ�����ݿ���޸Ĳ���������DO��ID��Ϣ����ȫ�ֶ������޸�
     * @param DO ������Ҫ�޸����ݵ�DO���󣬱������ID�ֶ�
     * @return �����޸ĳɹ�����true�����򷵻�false
     * @throws Exception SQLִ���쳣
     */
    public boolean doUpdata(FlightData DO) throws Exception;

    /**
     * ʵ�����ݿ������ɾ������������Set�����а�����ID�ֶ���Ϣ����ɾ��
     * @param ids ������Ҫɾ��������ID���������ظ�����
     * @return ����ɾ���ɹ���Ҫɾ�������ݺ���ɾ�������ݸ�����ͬ������true�����򷵻�false
     * @throws Exception SQLִ���쳣
     */
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception;

    /**
     * ����ID�ֶβ�ѯ������Ϣ
     * @param id ������Ҫ��ѯ������ID
     * @return �����ѯ�����ݣ�����DO�������ʽ���أ����򷵻�null
     * @throws Exception SQLִ���쳣
     */
    public FlightData doFindByID(Integer id) throws Exception;

    /**
     * ��ѯ���ݱ��е�ȫ����¼������List���ϵ���ʽ����
     * @return ������������ݣ������ݷ�װΪDO����Ȼ������List���Ϸ���
     *         ���û�����ݣ��򼯺ϵĳ���Ϊ0����size() == 0 ,������null
     * @throws Exception SQLִ���쳣
     */
    public List<FlightData> doFindAll() throws Exception;

}

package model.dao;



import model.DO.FlightData;

import java.util.List;
import java.util.Set;

/**
 * 数据操作接口
 * @author sdushn
 */
public interface IFlightDataDAO {

    /**
     * 实现数据库的增加操作
     * @param DO 包含了要增加数据的DO对象
     * @return 数据保存成功返回true，否则返回false
     * @throws Exception SQL执行异常
     */
    public boolean doCreate(FlightData DO) throws Exception;

    /**
     * 实现数据库的修改操作，根据DO中ID信息进行全字段数据修改
     * @param DO 包含了要修改数据的DO对象，必须包含ID字段
     * @return 数据修改成功返回true，否则返回false
     * @throws Exception SQL执行异常
     */
    public boolean doUpdata(FlightData DO) throws Exception;

    /**
     * 实现数据库的批量删除操作，根据Set集合中包含的ID字段信息进行删除
     * @param ids 包含了要删除的数据ID，不包含重复内容
     * @return 数据删除成功（要删除的数据和已删除的数据个数相同）返回true，否则返回false
     * @throws Exception SQL执行异常
     */
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception;

    /**
     * 根据ID字段查询数据信息
     * @param id 包含了要查询的数据ID
     * @return 如果查询到数据，则以DO对象的形式返回，否则返回null
     * @throws Exception SQL执行异常
     */
    public FlightData doFindByID(Integer id) throws Exception;

    /**
     * 查询数据表中的全部记录，并以List集合的形式返回
     * @return 如果表中有数据，则将数据封装为DO对象然后利用List集合返回
     *         如果没有数据，则集合的长度为0，即size() == 0 ,而不是null
     * @throws Exception SQL执行异常
     */
    public List<FlightData> doFindAll() throws Exception;

}

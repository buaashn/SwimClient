package model.dao.impl;

import model.DO.FlightData;
import model.dao.IFlightDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 数据操作接口实现
 * @author sdushn
 */
public class FlightDataDAOImpl implements IFlightDataDAO {

    private Connection connection;
    private PreparedStatement statement;

    /**
     * 构造方法
     * 如果想使用数据层进行原子性的功能操作实现，必须提供有Connection接口对象
     * @param connection 表示数据库连接对象
     */
    public FlightDataDAOImpl(Connection connection){
        this.connection = connection ;
    }

    /**
     * @param DO
     * @return
     * @throws Exception
     */
    @Override
    public boolean doCreate(FlightData DO) throws Exception {

        return false;
    }

    @Override
    public boolean doUpdata(FlightData DO) throws Exception {
        return false;
    }



    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        return false;
    }

    /**
     * @param id 包含了要查询的数据ID
     * @return
     * @throws Exception
     */
    @Override
    public FlightData doFindByID(Integer id) throws Exception {
        FlightData DO = null;
        String sql = "SELECT * FROM flight_data WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setInt(1 , id);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()){
            DO = new FlightData();
            DO.setAircraftType(resultSet.getString("ac_type"));
            DO.setAirport1(resultSet.getString("ap1"));
            DO.setAirport2(resultSet.getString("ap2"));
            DO.setAirport3(resultSet.getString("ap3"));
            DO.setAirport4(resultSet.getString("ap4"));
            DO.setAirport5(resultSet.getString("ap5"));
            DO.setArrivalTime1(resultSet.getString("arr1"));
            DO.setArrivalTime2(resultSet.getString("arr2"));
            DO.setArrivalTime3(resultSet.getString("arr3"));
            DO.setArrivalTime4(resultSet.getString("arr4"));
            DO.setDepartureTime1(resultSet.getString("dep1"));
            DO.setDepartureTime2(resultSet.getString("dep2"));
            DO.setDepartureTime3(resultSet.getString("dep3"));
            DO.setDepartureTime4(resultSet.getString("dep4"));
            DO.setEffectiveTimeBegin(resultSet.getString("eff_beg"));
            DO.setEffectiveTimeEnd(resultSet.getString("eff_end"));
            DO.setFlightDays(resultSet.getString("days"));
            DO.setFlightID(resultSet.getString("flt_id"));
            DO.setID(resultSet.getInt("ID"));
            DO.setRoute(resultSet.getString("route"));
        }
        return DO;
    }

    @Override
    public List<FlightData> doFindAll() throws Exception {
        List<FlightData> all = new ArrayList<FlightData>();
        String sql = "SELECT * FROM data";
        this.statement = this.connection.prepareStatement(sql);
        ResultSet resultSet = this.statement.executeQuery();
        while (resultSet.next()){
            FlightData DO = new FlightData();
            DO.setAircraftType(resultSet.getString("ac_type"));
            DO.setAirport1(resultSet.getString("ap1"));
            DO.setAirport2(resultSet.getString("ap2"));
            DO.setAirport3(resultSet.getString("ap3"));
            DO.setAirport4(resultSet.getString("ap4"));
            DO.setAirport5(resultSet.getString("ap5"));
            DO.setArrivalTime1(resultSet.getString("arr1"));
            DO.setArrivalTime2(resultSet.getString("arr2"));
            DO.setArrivalTime3(resultSet.getString("arr3"));
            DO.setArrivalTime4(resultSet.getString("arr4"));
            DO.setDepartureTime1(resultSet.getString("dep1"));
            DO.setDepartureTime2(resultSet.getString("dep2"));
            DO.setDepartureTime3(resultSet.getString("dep3"));
            DO.setDepartureTime4(resultSet.getString("dep4"));
            DO.setEffectiveTimeBegin(resultSet.getString("eff_beg"));
            DO.setEffectiveTimeEnd(resultSet.getString("eff_end"));
            DO.setFlightDays(resultSet.getString("days"));
            DO.setFlightID(resultSet.getString("flt_id"));
            DO.setID(resultSet.getInt("ID"));
            DO.setRoute(resultSet.getString("route"));
            all.add(DO);
        }
        return all;
    }
}

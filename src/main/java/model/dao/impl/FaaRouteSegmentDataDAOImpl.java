package model.dao.impl;


import model.DO.FaaRouteSegmentData;
import model.dao.IFaaRouteSegmentDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FaaRouteSegmentDataDAOImpl implements IFaaRouteSegmentDataDAO {
    private String dataTableName = "faaRouteSegment";
    private Connection connection;
    private PreparedStatement statement;

    public FaaRouteSegmentDataDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean doCreate(FaaRouteSegmentData DO) throws Exception {
        String sql = "INSERT INTO " + dataTableName + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1,DO.getID());
        this.statement.setString(2,DO.getUpperLimit());
        this.statement.setString(3,DO.getUpperLimitUOM());
        this.statement.setString(4,DO.getMinimumObstacleClearanceAltitude());
        this.statement.setString(5,DO.getMinimumObstacleClearanceAltitudeUOM());
        this.statement.setString(6,DO.getMinimumEnrouteAltitude());
        this.statement.setString(7,DO.getMinimumEnrouteAltitudeUOM());
        this.statement.setString(8,DO.getMinimumCrossingAtEnd());
        this.statement.setString(9,DO.getMinimumCrossingAtEndUOM());
        this.statement.setString(10,DO.getStartPointChoice());
        this.statement.setString(11,DO.getStartPoint());
        this.statement.setString(12,DO.getEndPointChioce());
        this.statement.setString(13,DO.getEndPoint());
        this.statement.setString(14,DO.getRouteFormed());
        this.statement.setString(15,DO.getAirwayPointSequenceNumber());
        this.statement.setString(16,DO.getChartPublicationDate());
        this.statement.setString(17,DO.getDistanceToNextPointInNauticalMiles());
        this.statement.setString(18,DO.getBearing());
        this.statement.setString(19,DO.getPointToPointMinimumEnrouteDirectionOppositeDirection());
        this.statement.setString(20,DO.getAirwayGapFlagIndicator());
        this.statement.setString(21,DO.getDistanceFromThisPointToChangeOverPointForNextNavaid());
        this.statement.setString(22,DO.getDirectionOfCrossing());
        this.statement.setString(23,DO.getDirectionOfCrossingOppositeDirection());
        this.statement.setString(24,DO.getPointToPointGpsMinimumEnrouteAltitude());
        this.statement.setString(25,DO.getUsAirspaceOnlyIndicator());
        this.statement.setString(26,DO.getMagneticVariation());
        this.statement.setString(27,DO.getReservedToPoint());
        this.statement.setString(28,DO.getReservedNextMEApoint());
        this.statement.setString(29,DO.getReservedMCAPoint());
        this.statement.setString(30,DO.getPointTopointMinimumEnrouteDirection());
        this.statement.setString(31,DO.getPointToPointMinimumEnrouteAltitudeOppositeDirection());
        this.statement.setString(32,DO.getPointToPointGpsMinimumEnrouteDirection());
        this.statement.setString(33,DO.getMinimumCrossingAltitudeOppositeDirection());
        this.statement.setString(34,DO.getTrackAngleOutbound());
        this.statement.setString(35,DO.getTrackAngleInbound());


        return this.statement.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdata(FaaRouteSegmentData DO) throws Exception {
        return false;
    }

    @Override
    public FaaRouteSegmentData doFindByID(String ID) throws Exception {
        FaaRouteSegmentData DO = null;
        String sql = "SELECT * FROM " + dataTableName + " WHERE ID = ?";
        this.statement = this.connection.prepareStatement(sql);
        this.statement.setString(1 , ID);
        ResultSet resultSet = this.statement.executeQuery();
        if (resultSet.next()) {
            DO = new FaaRouteSegmentData();
            DO.setID(resultSet.getString("ID"));
            DO.setUpperLimit(resultSet.getString("upperLimit"));
            DO.setUpperLimitUOM(resultSet.getString("upperLimitUOM"));
            DO.setMinimumObstacleClearanceAltitude(resultSet.getString("minimumObstacleClearanceAltitude"));
            DO.setMinimumObstacleClearanceAltitudeUOM(resultSet.getString("minimumObstacleClearanceAltitudeUOM"));
            DO.setMinimumEnrouteAltitude(resultSet.getString("minimumEnrouteAltitude"));
            DO.setMinimumEnrouteAltitudeUOM(resultSet.getString("minimumEnrouteAltitudeUOM"));
            DO.setMinimumCrossingAtEnd(resultSet.getString("minimumCrossingAtEnd"));
            DO.setMinimumCrossingAtEndUOM(resultSet.getString("minimumCrossingAtEndUOM"));
            DO.setStartPointChoice(resultSet.getString("startPointChoice"));
            DO.setStartPoint(resultSet.getString("startPoint"));
            DO.setEndPointChioce(resultSet.getString("endPointChioce"));
            DO.setEndPoint(resultSet.getString("endPoint"));
            DO.setRouteFormed(resultSet.getString("routeFormed"));
            DO.setAirwayPointSequenceNumber(resultSet.getString("airwayPointSequenceNumber"));
            DO.setChartPublicationDate(resultSet.getString("chartPublicationDate"));
            DO.setDistanceToNextPointInNauticalMiles(resultSet.getString("distanceToNextPointInNauticalMiles"));
            DO.setBearing(resultSet.getString("bearing"));
            DO.setPointToPointMinimumEnrouteDirectionOppositeDirection(resultSet.getString("pointToPointMinimumEnrouteDirectionOppositeDirection"));
            DO.setAirwayGapFlagIndicator(resultSet.getString("airwayGapFlagIndicator"));
            DO.setDistanceFromThisPointToChangeOverPointForNextNavaid(resultSet.getString("distanceFromThisPointToChangeOverPointForNextNavaid"));
            DO.setDirectionOfCrossing(resultSet.getString("directionOfCrossing"));
            DO.setDirectionOfCrossingOppositeDirection(resultSet.getString("directionOfCrossingOppositeDirection"));
            DO.setPointToPointGpsMinimumEnrouteAltitude(resultSet.getString("pointToPointGpsMinimumEnrouteAltitude"));
            DO.setUsAirspaceOnlyIndicator(resultSet.getString("usAirspaceOnlyIndicator"));
            DO.setMagneticVariation(resultSet.getString("magneticVariation"));
            DO.setReservedToPoint(resultSet.getString("reservedToPoint"));
            DO.setReservedNextMEApoint(resultSet.getString("reservedNextMEApoint"));
            DO.setReservedMCAPoint(resultSet.getString("reservedMCAPoint"));
            DO.setPointTopointMinimumEnrouteDirection(resultSet.getString("pointTopointMinimumEnrouteDirection"));
            DO.setPointToPointMinimumEnrouteAltitudeOppositeDirection(resultSet.getString("pointToPointMinimumEnrouteAltitudeOppositeDirection"));
            DO.setPointToPointGpsMinimumEnrouteDirection(resultSet.getString("pointToPointGpsMinimumEnrouteDirection"));
            DO.setMinimumCrossingAltitudeOppositeDirection(resultSet.getString("minimumCrossingAltitudeOppositeDirection"));
            DO.setTrackAngleOutbound(resultSet.getString("trackAngleOutbound"));
            DO.setTrackAngleInbound(resultSet.getString("trackAngleInbound"));

        }
        return DO;
    }

    @Override
    public List<FaaRouteSegmentData> findAll() throws Exception {
        List<FaaRouteSegmentData> all = new ArrayList<FaaRouteSegmentData>();
        String sql = "SELECT * FROM " + dataTableName ;

        this.statement = this.connection.prepareStatement(sql);
        ResultSet resultSet = this.statement.executeQuery();
        while (resultSet.next()){
            FaaRouteSegmentData DO = null;
            DO = new FaaRouteSegmentData();
            DO.setID(resultSet.getString("ID"));
            DO.setUpperLimit(resultSet.getString("upperLimit"));
            DO.setUpperLimitUOM(resultSet.getString("upperLimitUOM"));
            DO.setStartPointChoice(resultSet.getString("startPointChoice"));
            DO.setStartPoint(resultSet.getString("startPoint"));
            DO.setEndPointChioce(resultSet.getString("endPointChoice"));
            DO.setEndPoint(resultSet.getString("endPoint"));
            DO.setRouteFormed(resultSet.getString("routeFormed"));
            all.add(DO);
        }
        return all;
    }
}

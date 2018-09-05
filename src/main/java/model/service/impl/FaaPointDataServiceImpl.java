package model.service.impl;


import model.DO.FaaDesignatedPointData;
import model.DO.FaaNavaidData;
import model.DO.FaaRouteData;
import model.DO.FaaRouteSegmentData;
import model.base.OsName;
import model.connect.DatabaseConnection;
import model.dao.factory.FaaDesignatedPointDataDAOFactory;
import model.dao.factory.FaaNavaidDataDAOFactory;
import model.dao.factory.FaaRouteDataDAOFactory;
import model.dao.factory.FaaRouteSegmentDataDAOFactory;
import model.service.IFaaPointDataService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FaaPointDataServiceImpl implements IFaaPointDataService {
    private DatabaseConnection dbc = new DatabaseConnection();
    private boolean debug_readXML = false;
    //private boolean debug_readXML = true;

    File directory = new File("");
    private String url = null;

    @Override
    public void readDataFromXml() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;
        File fileXml = null;
        url = directory.getAbsolutePath() + "/client/data_original/AWY_AIXM.POINT.xml";

        try {
            if (OsName.getSystem() == OsName.WINDOWS) {
                fileXml = new File(url);
            } else {
                fileXml = new File(url);
            }
            builder = factory.newDocumentBuilder();
            doc = builder.parse(fileXml);

            // DesignatePoint
            NodeList nodeListOfDesignatePoint = doc.getElementsByTagName("aixm:DesignatedPoint");
            System.out.println("nodeListOfDesignatePoint:" + nodeListOfDesignatePoint.getLength());
            for (int i = 0; i < nodeListOfDesignatePoint.getLength(); i++) {
                Element elementOfDesignatePoint = (Element) nodeListOfDesignatePoint.item(i);
                FaaDesignatedPointData DODesignatedPointData = new FaaDesignatedPointData();
                String ID = null;
                String designator = null;
                String type = null;
                String name = null;
                String latitude = null;
                String longtitude = null;
                String noteID = null;
                String note = null;
                String fixTypePublicationCategory = null;
                String fixMinimumReceptionAltitude = null;
                String fixState = null;
                String fixARTCC = null;
                String ICAORegCode = null;

                ID = elementOfDesignatePoint.getAttribute("gml:id");
                if(elementOfDesignatePoint.getElementsByTagName("aixm:designator").getLength() > 0){
                    designator = elementOfDesignatePoint.getElementsByTagName("aixm:designator").item(0).getTextContent();
                }
                if(elementOfDesignatePoint.getElementsByTagName("aixm:type").getLength() > 0) {
                    type = elementOfDesignatePoint.getElementsByTagName("aixm:type").item(0).getTextContent();
                }
                if(elementOfDesignatePoint.getElementsByTagName("aixm:name").getLength() > 0){
                    name = elementOfDesignatePoint.getElementsByTagName("aixm:name").item(0).getTextContent();
                }
                if(elementOfDesignatePoint.getElementsByTagName("gml:pos").getLength() > 0){
                    latitude = elementOfDesignatePoint.getElementsByTagName("gml:pos").item(0).getTextContent().split("\\s+")[0];
                    longtitude = elementOfDesignatePoint.getElementsByTagName("gml:pos").item(0).getTextContent().split("\\s+")[1];
                }
                if(elementOfDesignatePoint.getElementsByTagName("aixm:Note").getLength() > 0){
                    noteID = ((Element) elementOfDesignatePoint.getElementsByTagName("aixm:Note").item(0)).getAttribute("gml:id");
                }
                if(elementOfDesignatePoint.getElementsByTagName("aixm:note").getLength() > 0){
                    note = elementOfDesignatePoint.getElementsByTagName("aixm:note").item(0).getTextContent();
                }
                
                if(elementOfDesignatePoint.getElementsByTagName("awy:fixTypePublicationCategory").getLength() > 0){
                    fixTypePublicationCategory = elementOfDesignatePoint.getElementsByTagName("awy:fixTypePublicationCategory").item(0).getTextContent();
                } 
                if(elementOfDesignatePoint.getElementsByTagName("awy:fixMinimumReceptionAltitude").getLength() > 0){
                    fixMinimumReceptionAltitude = elementOfDesignatePoint.getElementsByTagName("awy:fixMinimumReceptionAltitude").item(0).getTextContent();
                }
                if(elementOfDesignatePoint.getElementsByTagName("awy:fixState").getLength() > 0){
                    fixState = elementOfDesignatePoint.getElementsByTagName("awy:fixState").item(0).getTextContent();
                }
                if(elementOfDesignatePoint.getElementsByTagName("awy:fixARTCC").getLength() > 0){
                    fixARTCC = elementOfDesignatePoint.getElementsByTagName("awy:fixARTCC").item(0).getTextContent();
                }
                if(elementOfDesignatePoint.getElementsByTagName("awy:ICAORegCode").getLength() > 0){
                    ICAORegCode = elementOfDesignatePoint.getElementsByTagName("awy:ICAORegCode").item(0).getTextContent();
                }

                if(debug_readXML){
                    System.out.println("ID:" + ID);
                    System.out.println("designator:" + designator);
                    System.out.println("type:" + type);
                    System.out.println("Name:" + name);
                    System.out.println("Location:" + latitude + "," + longtitude);
                    System.out.println("noteID:"+noteID);
                    System.out.println("note:"+note);
                    System.out.println("fixTypePublicationCategory:"+fixTypePublicationCategory);
                    System.out.println("fixMinimumReceptionAltitude:" + fixMinimumReceptionAltitude);
                    System.out.println("fixState:" + fixState);
                    System.out.println("fixARTCC:" + fixARTCC);
                    System.out.println("ICAORegCode:" + ICAORegCode);
                    System.out.println("---------------------------------");
                } else {
                    DODesignatedPointData.setID(ID);
                    DODesignatedPointData.setDesignator(designator);
                    DODesignatedPointData.setType(type);
                    DODesignatedPointData.setName(name);
                    DODesignatedPointData.setLatitude(latitude);
                    DODesignatedPointData.setLongtitude(longtitude);
                    DODesignatedPointData.setNoteID(noteID);
                    DODesignatedPointData.setNote(note);
                    DODesignatedPointData.setFixTypePublicationCategory(fixTypePublicationCategory);
                    DODesignatedPointData.setFixMinimumReceptionAltitude(fixMinimumReceptionAltitude);
                    DODesignatedPointData.setFixState(fixState);
                    DODesignatedPointData.setFixARTCC(fixARTCC);
                    DODesignatedPointData.setICAORegCode(ICAORegCode);

                    if(!FaaDesignatedPointDataDAOFactory.getFaaDesignatedPointDataDAOInstance(dbc.getDbConnection()).doCreate(DODesignatedPointData)){
                        System.out.println("Error: " + ID);
                    } else {
                        System.out.println("DesignatedPointData : " + i);
                    }
                }
                
            }

// Navaid
            NodeList nodeListOfNavaid = doc.getElementsByTagName("aixm:Navaid");
            System.out.println("nodeListOfNavaid:" + nodeListOfNavaid.getLength());
            for (int i = 0; i < nodeListOfNavaid.getLength(); i++) {
                Element elementOfNavaid = (Element) nodeListOfNavaid.item(i);
                FaaNavaidData DONavaidData = new FaaNavaidData();
                String ID = null;
                String type = null;
                String designator = null;
                String name = null;
                String latitude = null;
                String longtitude = null;
                String navaidIdentifier = null;
                String navaidState = null;
                String navaidARTCC = null;

                ID = elementOfNavaid.getAttribute("gml:id");
                if(elementOfNavaid.getElementsByTagName("aixm:type").getLength() > 0){
                    type = elementOfNavaid.getElementsByTagName("aixm:type").item(0).getTextContent();
                }
                if(elementOfNavaid.getElementsByTagName("aixm:designator").getLength() > 0){
                    designator = elementOfNavaid.getElementsByTagName("aixm:designator").item(0).getTextContent();
                }
                if(elementOfNavaid.getElementsByTagName("aixm:name").getLength() > 0 ){
                    name = elementOfNavaid.getElementsByTagName("aixm:name").item(0).getTextContent();
                }
                if(elementOfNavaid.getElementsByTagName("gml:pos").getLength() > 0 ){
                    latitude = elementOfNavaid.getElementsByTagName("gml:pos").item(0).getTextContent().split("\\s+")[0];
                    longtitude = elementOfNavaid.getElementsByTagName("gml:pos").item(0).getTextContent().split("\\s+")[1];
                }

                if(elementOfNavaid.getElementsByTagName("awy:navaidIdentifier").getLength() > 0){
                    navaidIdentifier = elementOfNavaid.getElementsByTagName("awy:navaidIdentifier").item(0).getTextContent();
                }
                if(elementOfNavaid.getElementsByTagName("awy:navaidState").getLength() > 0){
                    navaidState = elementOfNavaid.getElementsByTagName("awy:navaidState").item(0).getTextContent();
                }
                if(elementOfNavaid.getElementsByTagName("awy:navaidARTCC").getLength() > 0){
                    navaidARTCC = elementOfNavaid.getElementsByTagName("awy:navaidARTCC").item(0).getTextContent();
                }

                if(debug_readXML){
                    System.out.println("ID:" + ID);
                    System.out.println("type:" + type);
                    System.out.println("designator:" + designator);
                    System.out.println("name:" + name);
                    System.out.println("latitude:" + latitude);
                    System.out.println("longtitude:" + longtitude);
                    System.out.println("navaidIdentifier:" + navaidIdentifier);
                    System.out.println("navaidState:" + navaidState);
                    System.out.println("navaidARTCC:" + navaidARTCC);
                    System.out.println("---------------------------------");
                } else {
                    DONavaidData.setID(ID);
                    DONavaidData.setType(type);
                    DONavaidData.setDesignator(designator);
                    DONavaidData.setName(name);
                    DONavaidData.setLatitude(latitude);
                    DONavaidData.setLongtitude(longtitude);
                    DONavaidData.setNavaidIdentifier(navaidIdentifier);
                    DONavaidData.setNavaidState(navaidState);
                    DONavaidData.setNavaidARTCC(navaidARTCC);

                    if(!FaaNavaidDataDAOFactory.getFaaNavaidDataDAOInstance(dbc.getDbConnection()).doCreate(DONavaidData)){
                        System.out.println("ERROR: " + ID);
                    } else {
                        System.out.println("Navaid: " + i);
                    }
                }
            }

// Route
            NodeList nodeListOfRoute = doc.getElementsByTagName("aixm:Route");
            System.out.println("nodeListOfRoute:" + nodeListOfRoute.getLength());
            for (int i = 0; i < nodeListOfRoute.getLength(); i++) {
                Element elementOfRoute = (Element) nodeListOfRoute.item(i);
                FaaRouteData DORouteData = new FaaRouteData();
                String ID = null;
                String designatorSecondLetter = null;
                String designatorNumber = null;
                String type = null;
                String propertyName = null;
                String noteID = null;
                String note = null;

                ID = elementOfRoute.getAttribute("gml:id");
                if(elementOfRoute.getElementsByTagName("aixm:designatorSecondLetter").getLength() > 0){
                    designatorSecondLetter = elementOfRoute.getElementsByTagName("aixm:designatorSecondLetter").item(0).getTextContent();
                }
                if(elementOfRoute.getElementsByTagName("aixm:designatorNumber").getLength() > 0){
                    designatorNumber = elementOfRoute.getElementsByTagName("aixm:designatorNumber").item(0).getTextContent();
                }
                if(elementOfRoute.getElementsByTagName("aixm:type").getLength() > 0){
                    type = elementOfRoute.getElementsByTagName("aixm:type").item(0).getTextContent();
                }
                if(elementOfRoute.getElementsByTagName("aixm:propertyName").getLength() > 0){
                    propertyName = elementOfRoute.getElementsByTagName("aixm:propertyName").item(0).getTextContent();
                }
                if(elementOfRoute.getElementsByTagName("aixm:Note").getLength() > 0){
                    noteID = ((Element) elementOfRoute.getElementsByTagName("aixm:Note").item(0)).getAttribute("gml:id");
                }
                if(elementOfRoute.getElementsByTagName("aixm:note").getLength() > 0){
                    note = elementOfRoute.getElementsByTagName("aixm:note").item(0).getTextContent();
                }

                if(debug_readXML){
                    System.out.println("ID:" + ID);
                    System.out.println("designatorSecondLetter:" + designatorSecondLetter);
                    System.out.println("designatorNumber:" + designatorNumber);
                    System.out.println("type:" + type);
                    System.out.println("propertyName:" + propertyName);
                    System.out.println("noteID:" + noteID);
                    System.out.println("note:" + note);
                    System.out.println("------------------------------------------");
                } else {
                    DORouteData.setID(ID);
                    DORouteData.setDesignatorSecondLetter(designatorSecondLetter);
                    DORouteData.setDesignatorNumber(designatorNumber);
                    DORouteData.setType(type);
                    DORouteData.setPropertyName(propertyName);
                    DORouteData.setNoteID(noteID);
                    DORouteData.setNote(note);

                    if(!FaaRouteDataDAOFactory.getFaaRouteDataDAOInstance(dbc.getDbConnection()).doCreate(DORouteData)){
                        System.out.println("ERROR: " + ID);
                    } else {
                        System.out.println("Route: " + i);
                    }
                }

            }
// RouteSegment
            NodeList nodeListOfRouteSegment = doc.getElementsByTagName("aixm:RouteSegment");
            System.out.println("nodeListOfRouteSegment:" + nodeListOfRouteSegment.getLength());
            for (int i = 21636; i < nodeListOfRouteSegment.getLength(); i++) {
                Element elementOfRouteSegment = (Element) nodeListOfRouteSegment.item(i);
                FaaRouteSegmentData DORouteSegment = new FaaRouteSegmentData();

                String ID = null;
                String upperLimit = null;
                String upperLimitUOM = null;
                String minimumObstacleClearanceAltitude = null;
                String minimumObstacleClearanceAltitudeUOM = null;
                String minimumEnrouteAltitude = null;
                String minimumEnrouteAltitudeUOM = null;
                String minimumCrossingAtEnd =null;
                String minimumCrossingAtEndUOM = null;
                String startPointChoice = null;
                String startPoint = null;
                String endPointChioce = null;
                String endPoint = null;
                String routeFormed = null;
                String airwayPointSequenceNumber = null;
                String chartPublicationDate = null;
                String distanceToNextPointInNauticalMiles = null;
                String bearing = null;
                String pointToPointMinimumEnrouteDirectionOppositeDirection = null;
                String airwayGapFlagIndicator = null;
                String distanceFromThisPointToChangeOverPointForNextNavaid = null;
                String directionOfCrossing = null;
                String directionOfCrossingOppositeDirection = null;
                String pointToPointGpsMinimumEnrouteAltitude = null;
                String usAirspaceOnlyIndicator = null;
                String magneticVariation = null;
                String reservedToPoint = null;
                String reservedNextMEApoint = null;
                String reservedMCAPoint = null;
                String pointTopointMinimumEnrouteDirection = null;
                String pointToPointMinimumEnrouteAltitudeOppositeDirection = null;
                String pointToPointGpsMinimumEnrouteDirection = null;
                String minimumCrossingAltitudeOppositeDirection = null;
                String trackAngleOutbound = null;
                String trackAngleInbound = null;

                ID = elementOfRouteSegment.getAttribute("gml:id");
                if(elementOfRouteSegment.getElementsByTagName("aixm:upperLimit").getLength() > 0){
                    upperLimit = elementOfRouteSegment.getElementsByTagName("aixm:upperLimit").item(0).getTextContent();
                    upperLimitUOM = ((Element)elementOfRouteSegment.getElementsByTagName("aixm:upperLimit").item(0)).getAttribute("uom");
                }

                if(elementOfRouteSegment.getElementsByTagName("aixm:minimumObstacleClearanceAltitude").getLength() > 0){
                    minimumObstacleClearanceAltitude = elementOfRouteSegment.getElementsByTagName("aixm:minimumObstacleClearanceAltitude").item(0).getTextContent();
                    minimumObstacleClearanceAltitudeUOM = ((Element)elementOfRouteSegment.getElementsByTagName("aixm:minimumObstacleClearanceAltitude").item(0)).getAttribute("uom");
                }
                if(elementOfRouteSegment.getElementsByTagName("aixm:minimumEnrouteAltitude").getLength() > 0){
                    minimumEnrouteAltitude = elementOfRouteSegment.getElementsByTagName("aixm:minimumEnrouteAltitude").item(0).getTextContent();
                    minimumEnrouteAltitudeUOM = ((Element)elementOfRouteSegment.getElementsByTagName("aixm:minimumEnrouteAltitude").item(0)).getAttribute("uom");
                }
                if (elementOfRouteSegment.getElementsByTagName("aixm:minimumCrossingAtEnd").getLength() > 0){
                    minimumCrossingAtEnd = elementOfRouteSegment.getElementsByTagName("aixm:minimumCrossingAtEnd").item(0).getTextContent();
                    minimumCrossingAtEndUOM = ((Element)elementOfRouteSegment.getElementsByTagName("aixm:minimumCrossingAtEnd").item(0)).getAttribute("uom");
                }
                if(elementOfRouteSegment.getElementsByTagName("aixm:start").getLength() > 0){
                    Element elementStart = (Element) elementOfRouteSegment.getElementsByTagName("aixm:start").item(0);
                    startPointChoice = elementStart.getElementsByTagName("aixm:EnRouteSegmentPoint").item(0).getChildNodes().item(1).getNodeName().split("_")[1];
                    startPoint = ((Element)elementStart.getElementsByTagName("aixm:EnRouteSegmentPoint").item(0).getChildNodes().item(1)).getAttribute("xlink:href").split("'")[1];
                }
                if(elementOfRouteSegment.getElementsByTagName("aixm:end").getLength() > 0){
                    Element elementEnd = (Element) elementOfRouteSegment.getElementsByTagName("aixm:end").item(0);
                    endPointChioce = elementEnd.getElementsByTagName("aixm:EnRouteSegmentPoint").item(0).getChildNodes().item(1).getNodeName().split("_")[1];
                    endPoint = ((Element)elementEnd.getElementsByTagName("aixm:EnRouteSegmentPoint").item(0).getChildNodes().item(1)).getAttribute("xlink:href").split("'")[1];
                }
                if(elementOfRouteSegment.getElementsByTagName("aixm:routeFormed").getLength() > 0){
                    routeFormed = ((Element)elementOfRouteSegment.getElementsByTagName("aixm:routeFormed").item(0)).getAttribute("xlink:href").split("'")[1];
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:airwayPointSequenceNumber").getLength() > 0){
                    airwayPointSequenceNumber = elementOfRouteSegment.getElementsByTagName("awy:airwayPointSequenceNumber").item(0).getTextContent();
                }

                if(elementOfRouteSegment.getElementsByTagName("awy:chartPublicationDate").getLength() > 0){
                    chartPublicationDate = elementOfRouteSegment.getElementsByTagName("awy:chartPublicationDate").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:distanceToNextPointInNauticalMiles").getLength() > 0){
                    distanceToNextPointInNauticalMiles = elementOfRouteSegment.getElementsByTagName("awy:distanceToNextPointInNauticalMiles").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:bearing").getLength() > 0){
                    bearing = elementOfRouteSegment.getElementsByTagName("awy:bearing").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:pointToPointMinimumEnrouteDirectionOppositeDirection").getLength() > 0){
                    pointToPointMinimumEnrouteDirectionOppositeDirection = elementOfRouteSegment.getElementsByTagName("awy:pointToPointMinimumEnrouteDirectionOppositeDirection").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:airwayGapFlagIndicator").getLength() > 0){
                    airwayGapFlagIndicator = elementOfRouteSegment.getElementsByTagName("awy:airwayGapFlagIndicator").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:distanceFromThisPointToChangeOverPointForNextNavaid").getLength() > 0){
                    distanceFromThisPointToChangeOverPointForNextNavaid = elementOfRouteSegment.getElementsByTagName("awy:distanceFromThisPointToChangeOverPointForNextNavaid").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:directionOfCrossing").getLength() > 0){
                    directionOfCrossing = elementOfRouteSegment.getElementsByTagName("awy:directionOfCrossing").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:directionOfCrossingOppositeDirection").getLength() > 0){
                    directionOfCrossingOppositeDirection = elementOfRouteSegment.getElementsByTagName("awy:directionOfCrossingOppositeDirection").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:pointToPointGpsMinimumEnrouteAltitude").getLength() > 0){
                    pointToPointGpsMinimumEnrouteAltitude = elementOfRouteSegment.getElementsByTagName("awy:pointToPointGpsMinimumEnrouteAltitude").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:usAirspaceOnlyIndicator").getLength() > 0){
                    usAirspaceOnlyIndicator = elementOfRouteSegment.getElementsByTagName("awy:usAirspaceOnlyIndicator").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:magneticVariation").getLength() > 0){
                    magneticVariation = elementOfRouteSegment.getElementsByTagName("awy:magneticVariation").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:reservedToPoint").getLength() > 0){
                    reservedToPoint = elementOfRouteSegment.getElementsByTagName("awy:reservedToPoint").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:reservedNextMEApoint").getLength() > 0){
                    reservedNextMEApoint = elementOfRouteSegment.getElementsByTagName("awy:reservedNextMEApoint").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:reservedMCAPoint").getLength() > 0){
                    reservedMCAPoint = elementOfRouteSegment.getElementsByTagName("awy:reservedMCAPoint").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:pointTopointMinimumEnrouteDirection").getLength() > 0){
                    pointTopointMinimumEnrouteDirection = elementOfRouteSegment.getElementsByTagName("awy:pointTopointMinimumEnrouteDirection").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:pointToPointMinimumEnrouteAltitudeOppositeDirection").getLength() > 0){
                    pointToPointMinimumEnrouteAltitudeOppositeDirection = elementOfRouteSegment.getElementsByTagName("awy:pointToPointMinimumEnrouteAltitudeOppositeDirection").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:pointToPointGpsMinimumEnrouteDirection").getLength() > 0){
                    pointToPointGpsMinimumEnrouteDirection = elementOfRouteSegment.getElementsByTagName("awy:pointToPointGpsMinimumEnrouteDirection").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:minimumCrossingAltitudeOppositeDirection").getLength() > 0){
                    minimumCrossingAltitudeOppositeDirection = elementOfRouteSegment.getElementsByTagName("awy:minimumCrossingAltitudeOppositeDirection").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:trackAngleOutbound").getLength() > 0){
                    trackAngleOutbound = elementOfRouteSegment.getElementsByTagName("awy:trackAngleOutbound").item(0).getTextContent();
                }
                if(elementOfRouteSegment.getElementsByTagName("awy:trackAngleInbound").getLength() > 0){
                    trackAngleInbound = elementOfRouteSegment.getElementsByTagName("awy:trackAngleInbound").item(0).getTextContent();
                }

                if(debug_readXML){
                    System.out.println("ID:" + ID);
                    System.out.println("upperLimit:" + upperLimit);
                    System.out.println("upperLimitUOM:" + upperLimitUOM);
                    System.out.println("minimumObstacleClearanceAltitude:" + minimumObstacleClearanceAltitude);
                    System.out.println("minimumObstacleClearanceAltitudeUOM:" + minimumObstacleClearanceAltitudeUOM);
                    System.out.println("minimumEnrouteAltitude:" + minimumEnrouteAltitude);
                    System.out.println("minimumEnrouteAltitudeUOM:" + minimumEnrouteAltitudeUOM);
                    System.out.println("minimumCrossingAtEnd:" + minimumCrossingAtEnd);
                    System.out.println("minimumCrossingAtEndUOM:" + minimumCrossingAtEndUOM);
                    System.out.println("startPointChoice:" + startPointChoice);
                    System.out.println("startPoint:" + startPoint);
                    System.out.println("endPointChioce:" + endPointChioce);
                    System.out.println("endPoint:" + endPoint);
                    System.out.println("routeFormed:" + routeFormed);
                    System.out.println("airwayPointSequenceNumber:" + airwayPointSequenceNumber);
                    System.out.println("chartPublicationDate:" + chartPublicationDate);
                    System.out.println("distanceToNextPointInNauticalMiles:" + distanceToNextPointInNauticalMiles);
                    System.out.println("bearing:" + bearing);
                    System.out.println("pointToPointMinimumEnrouteDirectionOppositeDirection:" + pointToPointMinimumEnrouteDirectionOppositeDirection);
                    System.out.println("airwayGapFlagIndicator:" + airwayGapFlagIndicator);
                    System.out.println("distanceFromThisPointToChangeOverPointForNextNavaid:" + distanceFromThisPointToChangeOverPointForNextNavaid);
                    System.out.println("directionOfCrossing:" + directionOfCrossing);
                    System.out.println("directionOfCrossingOppositeDirection:" + directionOfCrossingOppositeDirection);
                    System.out.println("pointToPointGpsMinimumEnrouteAltitude:" + pointToPointGpsMinimumEnrouteAltitude);
                    System.out.println("usAirspaceOnlyIndicator:" + usAirspaceOnlyIndicator);
                    System.out.println("magneticVariation:" + magneticVariation);
                    System.out.println("reservedToPoint:" + reservedToPoint);
                    System.out.println("reservedNextMEApoint:" + reservedNextMEApoint);
                    System.out.println("reservedMCAPoint:" + reservedMCAPoint);
                    System.out.println("pointTopointMinimumEnrouteDirection:" + pointTopointMinimumEnrouteDirection);
                    System.out.println("pointToPointMinimumEnrouteAltitudeOppositeDirection:" + pointToPointMinimumEnrouteAltitudeOppositeDirection);
                    System.out.println("pointToPointGpsMinimumEnrouteDirection:" + pointToPointGpsMinimumEnrouteDirection);
                    System.out.println("minimumCrossingAltitudeOppositeDirection:" + minimumCrossingAltitudeOppositeDirection);
                    System.out.println("trackAngleOutbound:" + trackAngleOutbound);
                    System.out.println("trackAngleInbound:" + trackAngleInbound);
                } else {
                    DORouteSegment.setID(ID);
                    DORouteSegment.setUpperLimit(upperLimit);
                    DORouteSegment.setUpperLimitUOM(upperLimitUOM);
                    DORouteSegment.setMinimumObstacleClearanceAltitude(minimumObstacleClearanceAltitude);
                    DORouteSegment.setMinimumObstacleClearanceAltitudeUOM(minimumObstacleClearanceAltitudeUOM);
                    DORouteSegment.setMinimumEnrouteAltitude(minimumEnrouteAltitude);
                    DORouteSegment.setMinimumEnrouteAltitudeUOM(minimumEnrouteAltitudeUOM);
                    DORouteSegment.setMinimumCrossingAtEnd(minimumCrossingAtEnd);
                    DORouteSegment.setMinimumCrossingAtEndUOM(minimumCrossingAtEndUOM);
                    DORouteSegment.setStartPointChoice(startPointChoice);
                    DORouteSegment.setStartPoint(startPoint);
                    DORouteSegment.setEndPointChioce(endPointChioce);
                    DORouteSegment.setEndPoint(endPoint);
                    DORouteSegment.setRouteFormed(routeFormed);
                    DORouteSegment.setAirwayPointSequenceNumber(airwayPointSequenceNumber);
                    DORouteSegment.setChartPublicationDate(chartPublicationDate);
                    DORouteSegment.setDistanceToNextPointInNauticalMiles(distanceToNextPointInNauticalMiles);
                    DORouteSegment.setBearing(bearing);
                    DORouteSegment.setPointToPointMinimumEnrouteDirectionOppositeDirection(pointToPointMinimumEnrouteDirectionOppositeDirection);
                    DORouteSegment.setAirwayGapFlagIndicator(airwayGapFlagIndicator);
                    DORouteSegment.setDistanceFromThisPointToChangeOverPointForNextNavaid(distanceFromThisPointToChangeOverPointForNextNavaid);
                    DORouteSegment.setDirectionOfCrossing(directionOfCrossing);
                    DORouteSegment.setDirectionOfCrossingOppositeDirection(directionOfCrossingOppositeDirection);
                    DORouteSegment.setPointToPointGpsMinimumEnrouteAltitude(pointToPointGpsMinimumEnrouteAltitude);
                    DORouteSegment.setUsAirspaceOnlyIndicator(usAirspaceOnlyIndicator);
                    DORouteSegment.setMagneticVariation(magneticVariation);
                    DORouteSegment.setReservedToPoint(reservedToPoint);
                    DORouteSegment.setReservedNextMEApoint(reservedNextMEApoint);
                    DORouteSegment.setPointTopointMinimumEnrouteDirection(pointTopointMinimumEnrouteDirection);
                    DORouteSegment.setPointToPointMinimumEnrouteAltitudeOppositeDirection(pointToPointMinimumEnrouteAltitudeOppositeDirection);
                    DORouteSegment.setPointToPointGpsMinimumEnrouteDirection(pointToPointGpsMinimumEnrouteDirection);
                    DORouteSegment.setMinimumCrossingAltitudeOppositeDirection(minimumCrossingAltitudeOppositeDirection);
                    DORouteSegment.setTrackAngleOutbound(trackAngleOutbound);
                    DORouteSegment.setTrackAngleInbound(trackAngleInbound);

                    if(!FaaRouteSegmentDataDAOFactory.getFaaRouteSegmentDataDAOInstance(dbc.getDbConnection()).doCreate(DORouteSegment)){
                        System.out.println("ERROR: " + ID);
                    } else {
                        System.out.println("RouteSegment: " + i);
                    }
                }

            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getLocationToStatic() throws Exception {
        String text = null;
        String routeSegment = "[\n";
        List<FaaRouteSegmentData> routeSegmentDataList = null;

        routeSegmentDataList = FaaRouteSegmentDataDAOFactory.getFaaRouteSegmentDataDAOInstance(dbc.getDbConnection()).findAll();

        for (int i = 0; i < routeSegmentDataList.size(); i++) {
            boolean error = false;
            String pointStart = "[";
            String pointEnd = "[";

            if(routeSegmentDataList.get(i).getStartPointChoice().matches("fixDesignatedPoint")){
                FaaDesignatedPointData designatedPointDataStart = null;
                designatedPointDataStart = FaaDesignatedPointDataDAOFactory.getFaaDesignatedPointDataDAOInstance(dbc.getDbConnection()).doFindByID(routeSegmentDataList.get(i).getStartPoint());
                if(designatedPointDataStart == null | designatedPointDataStart.getLatitude() == null | designatedPointDataStart.getLongtitude() == null){
                    error = true;
                } else {
                    pointStart = pointStart + designatedPointDataStart.getLatitude() + "," + designatedPointDataStart.getLongtitude() + "]";
                }
            } else if(routeSegmentDataList.get(i).getStartPointChoice().matches("navaidSystem")){
                FaaNavaidData navaidData = null;
                navaidData = FaaNavaidDataDAOFactory.getFaaNavaidDataDAOInstance(dbc.getDbConnection()).doFindByID(routeSegmentDataList.get(i).getStartPoint());
                if(navaidData == null | navaidData.getLatitude() == null | navaidData.getLongtitude() == null){
                    error = true;
                } else {
                    pointStart = pointStart + navaidData.getLatitude() + "," + navaidData.getLongtitude() + "]";
                }
            } else {
                error = true;
            }

            if(routeSegmentDataList.get(i).getEndPointChioce().matches("fixDesignatedPoint")){
                FaaDesignatedPointData designatedPointDataStart = null;
                designatedPointDataStart = FaaDesignatedPointDataDAOFactory.getFaaDesignatedPointDataDAOInstance(dbc.getDbConnection()).doFindByID(routeSegmentDataList.get(i).getEndPoint());
                if(designatedPointDataStart == null || designatedPointDataStart.getLatitude() == null || designatedPointDataStart.getLongtitude() == null) {
                    error = true;
                } else {
                    pointEnd = pointEnd + designatedPointDataStart.getLatitude() + "," + designatedPointDataStart.getLongtitude() + "]";
                }
            } else if(routeSegmentDataList.get(i).getEndPointChioce().matches("navaidSystem")){
                FaaNavaidData navaidData = null;
                navaidData = FaaNavaidDataDAOFactory.getFaaNavaidDataDAOInstance(dbc.getDbConnection()).doFindByID(routeSegmentDataList.get(i).getEndPoint());
                if( navaidData == null || navaidData.getLatitude() == null || navaidData.getLongtitude() == null) {
                    error = true;
                } else {
                    pointEnd = pointEnd + navaidData.getLatitude() + "," + navaidData.getLongtitude() + "]";
                }
            } else {
                error = true;
            }

            if(error){

            } else {
                routeSegment = routeSegment + "[" + pointStart + "," + pointEnd + "],\n";
            }
        }

        routeSegment = routeSegment + "]\n";
        text = "var routeSegment;\n" +
                "routeSegment = {\n" +
                "    \"routeSegment\":" +
                routeSegment +
                "}";

        File file = new File("D:\\Dropbox\\SWIMSystem\\client\\src\\com\\swim\\mian\\routeSegmentFaa.js");
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.print(text);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}

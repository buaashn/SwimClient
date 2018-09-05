package model.service.impl;


import model.DO.DesignatedPointData;
import model.DO.NavaidData;
import model.DO.RouteData;
import model.DO.routeSegmentData;
import model.base.OsName;
import model.connect.DatabaseConnection;
import model.dao.factory.DesignatedPointDataDAOFactory;
import model.dao.factory.NavaidDataDAOFactory;
import model.dao.factory.RouteDataDAOFactory;
import model.dao.factory.RouteSegmentDataDAOFactory;
import model.service.IRouteSegmentDataService;
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

public class RouteSegmentDataServiceImpl implements IRouteSegmentDataService {

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
        url = directory.getAbsolutePath() + "/data_original/routeSegment.xml";

        try {
            if (OsName.getSystem() == OsName.WINDOWS) {
                fileXml = new File(url);
            } else {
                fileXml = new File(url);
            }
            builder = factory.newDocumentBuilder();
            doc = builder.parse(fileXml);
            NodeList list = doc.getElementsByTagName("aixm:RouteSegment");
            for (int i = 14210; i < list.getLength(); i++) {
                Element element = (Element) list.item(i);
                routeSegmentData DO = new routeSegmentData();

                String ID = element.getElementsByTagName("gml:identifier").item(0).getTextContent();

                String upperLimitAltitudeUOM = null;
                String upperLimitAltitude = null;
                NodeList listUpperLimitAltitude = element.getElementsByTagName("aixm:upperLimit");
                if(listUpperLimitAltitude.getLength() > 0) {
                    Element elementUpperLimitAltitude = (Element) listUpperLimitAltitude.item(0);
                    upperLimitAltitudeUOM = elementUpperLimitAltitude.getAttribute("uom");
                    upperLimitAltitude = elementUpperLimitAltitude.getTextContent();
                }

                String lowerLimitAltitudeUOM = null;
                String lowerLimitAltitude = null;
                NodeList listLowerLimitAltitude = element.getElementsByTagName("aixm:lowerLimit");
                if(listLowerLimitAltitude.getLength() > 0){
                    Element elementLowerLimitAltitude = (Element) listLowerLimitAltitude.item(0);
                    lowerLimitAltitudeUOM = elementLowerLimitAltitude.getAttribute("uom");
                    lowerLimitAltitude = elementLowerLimitAltitude.getTextContent();
                }

                String startPointChoice = null;
                String startPoint = null;
                NodeList listStartPoint = null;
                Element elementStartPoint = (Element) element.getElementsByTagName("aixm:start").item(0);
                listStartPoint = elementStartPoint.getElementsByTagName("aixm:EnRouteSegmentPoint");
                startPointChoice = listStartPoint.item(0).getFirstChild().getNodeName().split("_")[1];
                startPoint = ((Element)listStartPoint.item(0).getFirstChild()).getAttribute("xlink:href").split(":")[2];

                NodeList listEndPoint = ((Element)element.getElementsByTagName("aixm:end").item(0)).getElementsByTagName("aixm:EnRouteSegmentPoint");
                String endPointChoice = listEndPoint.item(0).getFirstChild().getNodeName().split("_")[1];
                String endPoint = ((Element)listEndPoint.item(0).getFirstChild()).getAttribute("xlink:href").split(":")[2];

                String routeFormed = ((Element) element.getElementsByTagName("aixm:routeFormed").item(0)).getAttribute("xlink:href").split(":")[2];
                
                if (debug_readXML) {
                    System.out.println("ID:" + ID);
                    System.out.println("upperLimitAltitude:" + upperLimitAltitude);
                    System.out.println("upperLimitAltitudeUOM:" + upperLimitAltitudeUOM);
                    System.out.println("lowerLimitAltitude:" + lowerLimitAltitude);
                    System.out.println("lowerLimitAltitudeUOM:" + lowerLimitAltitudeUOM);
                    System.out.println("startPointChoice:" + startPointChoice);
                    System.out.println("startPoint:" + startPoint);
                    //System.out.println("startPoint:" + startPoint[2]);
                    System.out.println("endPointChoice:" + endPointChoice);
                    System.out.println("endPoint:" + endPoint);
                    System.out.println("routeFormed:" + routeFormed);
                    System.out.println("-------------------------------");
                } else {
                    DO.setID(ID);
                    DO.setUpperLimit(upperLimitAltitude);
                    DO.setUpperLimitUOM(upperLimitAltitudeUOM);
                    DO.setLowerLimit(lowerLimitAltitude);
                    DO.setLowerLimitUOM(lowerLimitAltitudeUOM);
                    DO.setStartPointChoice(startPointChoice);
                    DO.setStartPoint(startPoint);
                    DO.setEndPointChoice(endPointChoice);
                    DO.setEndPoint(endPoint);
                    DO.setRouteFormed(routeFormed);
                    if (!RouteSegmentDataDAOFactory.getRouteSegmentDataDAOInstance(this.dbc.getDbConnection()).doCreate(DO)) {
                        System.out.println("Error:" + ID);
                    }
                    System.out.println(Integer.toString(i));
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
    public void readDataFromXmlToUpdate() {

    }

    @Override
    public void getLocationToStatic() throws Exception {
        String text = null;
        String routeSegment = "[\n";
        List<routeSegmentData> routeSegmentDataList = null;

        routeSegmentDataList = RouteSegmentDataDAOFactory.getRouteSegmentDataDAOInstance(dbc.getDbConnection()).findAll();

        for (int i = 0; i < routeSegmentDataList.size(); i++) {
            boolean error = false;
            String pointStart = "[";
            String pointEnd = "[";

            if(routeSegmentDataList.get(i).getStartPointChoice().matches("fixDesignatedPoint")){
                DesignatedPointData designatedPointDataStart = null;
                designatedPointDataStart = DesignatedPointDataDAOFactory.getDesignatedPointDataDAOInstance(dbc.getDbConnection()).doFindByID(routeSegmentDataList.get(i).getStartPoint());
                if(designatedPointDataStart == null){
                    error = true;
                } else {
                    pointStart = pointStart + designatedPointDataStart.getLongtitude() + "," + designatedPointDataStart.getLatitude() + "]";
                }
            } else if(routeSegmentDataList.get(i).getStartPointChoice().matches("navaidSystem")){
                NavaidData navaidData = null;
                navaidData = NavaidDataDAOFactory.getINavaidDataDAOInstance(dbc.getDbConnection()).doFindByID(routeSegmentDataList.get(i).getStartPoint());
                if(navaidData == null){
                    error = true;
                } else {
                    pointStart = pointStart + navaidData.getLongtitude() + "," + navaidData.getLatitude() + "]";
                }
            } else {
                error = true;
            }

            if(routeSegmentDataList.get(i).getEndPointChoice().matches("fixDesignatedPoint")){
                DesignatedPointData designatedPointDataStart = null;
                designatedPointDataStart = DesignatedPointDataDAOFactory.getDesignatedPointDataDAOInstance(dbc.getDbConnection()).doFindByID(routeSegmentDataList.get(i).getEndPoint());
                if(designatedPointDataStart == null) {
                    error = true;
                } else {
                    pointEnd = pointEnd + designatedPointDataStart.getLongtitude() + "," + designatedPointDataStart.getLatitude() + "]";
                }
            } else if(routeSegmentDataList.get(i).getEndPointChoice().matches("navaidSystem")){
                NavaidData navaidData = null;
                navaidData = NavaidDataDAOFactory.getINavaidDataDAOInstance(dbc.getDbConnection()).doFindByID(routeSegmentDataList.get(i).getEndPoint());
                if( navaidData == null) {
                    error = true;
                } else {
                    pointEnd = pointEnd + navaidData.getLongtitude() + "," + navaidData.getLatitude() + "]";
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

        File file = new File("D:\\Dropbox\\SWIMSystem\\client\\src\\com\\swim\\mian\\routeSegment.js");
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.print(text);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void sortPoint() throws Exception {
        List<RouteData> routeDataList = null;
        routeDataList = RouteDataDAOFactory.getRouteDataDAOInstance(dbc.getDbConnection()).findAll();
        for (int i = 0; i < 3; i ++){
            List<routeSegmentData> routeSegmentDataList = null;
            System.out.println("Route: " + routeDataList.get(i).getID());
            routeSegmentDataList = RouteSegmentDataDAOFactory.getRouteSegmentDataDAOInstance(dbc.getDbConnection()).doFindByRouteFormed(routeDataList.get(i).getID());
            String firstStartPoint = null;
            String startPoint = null;
            String endPoint = null;
            firstStartPoint = findFirstStartPoint(routeSegmentDataList);

            startPoint = firstStartPoint;
            endPoint = findEndPointByStartPoint(routeSegmentDataList, startPoint);
            System.out.println(routeSegmentDataList.size());
            System.out.println(firstStartPoint);
//            System.out.println(endPoint);
            while (true){
                if(findEndPointByStartPoint(routeSegmentDataList, startPoint) == null){
                    break;
                } else {
                    System.out.println(endPoint);
                    startPoint = findEndPointByStartPoint(routeSegmentDataList, startPoint);
                    endPoint = findEndPointByStartPoint(routeSegmentDataList, startPoint);

                }
            }
            System.out.println("======================================================");

        }

    }

    public String findStartPointByEndPoint(List<routeSegmentData> routeSegmentDataList, String endPoint){
        String startPoint = null;

        for(int i = 0; i < routeSegmentDataList.size(); i++){
            if (endPoint.equals( routeSegmentDataList.get(i).getEndPoint())){
                startPoint = routeSegmentDataList.get(i).getStartPoint();
                break;
            }
        }

        return startPoint;
    }

    public String findEndPointByStartPoint (List<routeSegmentData> routeSegmentDataList, String startPoint){
        String endPoint = null;

        for(int i = 0; i < routeSegmentDataList.size(); i++){
            if(startPoint.equals(routeSegmentDataList.get(i).getStartPoint()) ){
                endPoint = routeSegmentDataList.get(i).getEndPoint();
                break;
            }
        }

        return endPoint;
    }


    public String findFirstStartPoint(List<routeSegmentData> routeSegmentDataList){
        String firstStartPoint = null;
        firstStartPoint = routeSegmentDataList.get(0).getStartPoint();

        for(int i = 0; i < routeSegmentDataList.size(); ){
            String endPoint = routeSegmentDataList.get(i).getEndPoint();
//            System.out.println("Point " + i);
            if(firstStartPoint.equals(endPoint)){
                firstStartPoint = routeSegmentDataList.get(i).getStartPoint();
                i = 0;
//                System.out.println("Point Find " + i + ":" + firstStartPoint);
            } else {
                i++;
//                System.out.println(endPoint);
            }
        }

        return firstStartPoint;
    }


}

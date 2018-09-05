package model.service.impl;


import model.DO.DepartureLegData;
import model.base.OsName;
import model.connect.DatabaseConnection;
import model.dao.factory.DepartureLegDataDAOFactory;
import model.service.IDepartureLegDataService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DepartureLegDataServiceImpl implements IDepartureLegDataService {
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
        url = directory.getAbsolutePath() + "/client/data_original/departureLeg.xml";

        try {
            if (OsName.getSystem() == OsName.WINDOWS) {
                fileXml = new File(url);
            } else {
                fileXml = new File(url);
            }
            builder = factory.newDocumentBuilder();
            doc = builder.parse(fileXml);
            NodeList list = doc.getElementsByTagName("aixm:DepartureLeg");
            for (int i = 0; i < list.getLength(); i++) {
                Element element = (Element) list.item(i);
                DepartureLegData DO = new DepartureLegData();

                String ID = element.getElementsByTagName("gml:identifier").item(0).getTextContent();

                NodeList listUpperLimitAltitude = element.getElementsByTagName("aixm:upperLimitAltitude");
                Element elementUpperLimitAltitude = (Element) listUpperLimitAltitude.item(0);
                String upperLimitAltitudeUOM = elementUpperLimitAltitude.getAttribute("uom");
                String upperLimitAltitude = elementUpperLimitAltitude.getTextContent();

                NodeList listLowerLimitAltitude = element.getElementsByTagName("aixm:lowerLimitAltitude");
                Element elementLowerLimitAltitude = (Element) listLowerLimitAltitude.item(0);
                String lowerLimitAltitudeUOM = elementLowerLimitAltitude.getAttribute("uom");
                String lowerLimitAltitude = elementLowerLimitAltitude.getTextContent();

                NodeList listStartPoint = null;
                Element elementStartPoint = (Element) element.getElementsByTagName("aixm:startPoint").item(0);
                listStartPoint = elementStartPoint.getElementsByTagName("aixm:TerminalSegmentPoint");
                String startPointChoice = listStartPoint.item(0).getFirstChild().getNodeName().split("_")[1];
                String startPoint = ((Element)listStartPoint.item(0).getFirstChild()).getAttribute("xlink:href").split(":")[2];

                NodeList listEndPoint = ((Element)element.getElementsByTagName("aixm:endPoint").item(0)).getElementsByTagName("aixm:TerminalSegmentPoint");
                String endPointChoice = listEndPoint.item(0).getFirstChild().getNodeName().split("_")[1];
                String endPoint = ((Element)listEndPoint.item(0).getFirstChild()).getAttribute("xlink:href").split(":")[2];

                NodeList listArrival = element.getElementsByTagName("aixm:departure");
                Element elementArrival = (Element) listArrival.item(0);
                String departure = elementArrival.getAttribute("xlink:href").split(":")[2];

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
                    System.out.println("departure:" + departure);
                    System.out.println("-------------------------------");
                } else {
                    DO.setID(ID);
                    DO.setUpperLimitAltitude(upperLimitAltitude);
                    DO.setUpperLimitAltitudeUOM(upperLimitAltitudeUOM);
                    DO.setLowerLimitAltitude(lowerLimitAltitude);
                    DO.setLowerLimitAltitudeUOM(lowerLimitAltitudeUOM);
                    DO.setStartPointChoice(startPointChoice);
                    DO.setStartPoint(startPoint);
                    DO.setEndPointChoice(endPointChoice);
                    DO.setEndPoint(endPoint);
                    DO.setDeparture(departure);
                    if (!DepartureLegDataDAOFactory.getDepartureLegDataDAOInstance(this.dbc.getDbConnection()).doCreate(DO)) {
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
}

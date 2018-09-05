package model.service.impl;


import model.DO.RouteData;
import model.base.OsName;
import model.connect.DatabaseConnection;
import model.dao.factory.RouteDataDAOFactory;
import model.service.IRouteDataService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class RouteDataServiceImpl implements IRouteDataService {

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
        url = directory.getAbsolutePath() + "/data_original/route.xml";

        try {
            if (OsName.getSystem() == OsName.WINDOWS) {
                fileXml = new File(url);
            } else {
                fileXml = new File(url);
            }
            builder = factory.newDocumentBuilder();
            doc = builder.parse(fileXml);

            NodeList nodeListOfRoute = doc.getElementsByTagName("aixm:Route");
            System.out.println("nodeListOfRoute:" + nodeListOfRoute.getLength());
            for (int i = 0; i < nodeListOfRoute.getLength(); i++) {
                Element elementOfRoute = (Element) nodeListOfRoute.item(i);
                RouteData DORouteData = new RouteData();
                String ID = null;
                String designatorSecondLetter = null;
                String designatorNumber = null;
                String type = null;

                ID = elementOfRoute.getElementsByTagName("gml:identifier").item(0).getTextContent();
                if (elementOfRoute.getElementsByTagName("aixm:designatorSecondLetter").getLength() > 0) {
                    designatorSecondLetter = elementOfRoute.getElementsByTagName("aixm:designatorSecondLetter").item(0).getTextContent();
                }
                if (elementOfRoute.getElementsByTagName("aixm:designatorNumber").getLength() > 0) {
                    designatorNumber = elementOfRoute.getElementsByTagName("aixm:designatorNumber").item(0).getTextContent();
                }
                if (elementOfRoute.getElementsByTagName("aixm:type").getLength() > 0) {
                    type = elementOfRoute.getElementsByTagName("aixm:type").item(0).getTextContent();
                }

                if (debug_readXML) {
                    System.out.println("ID:" + ID);
                    System.out.println("designatorSecondLetter:" + designatorSecondLetter);
                    System.out.println("designatorNumber:" + designatorNumber);
                    System.out.println("type:" + type);
                    System.out.println("------------------------------------------------------");
                } else {
                    DORouteData.setID(ID);
                    DORouteData.setDesignatorSecondLetter(designatorSecondLetter);
                    DORouteData.setDesignatorNumber(designatorNumber);
                    DORouteData.setType(type);

                    if (!RouteDataDAOFactory.getRouteDataDAOInstance(dbc.getDbConnection()).doCreate(DORouteData)) {
                        System.out.println("ERROR: " + ID);
                    } else {
                        System.out.println("Route: " + i);
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
    public void readDataFromXmlToUpdate() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;
        File fileXml = null;
        try {
            if (OsName.getSystem() == OsName.WINDOWS) {
                fileXml = new File(url);
            } else {
                fileXml = new File(url);
            }

            builder = factory.newDocumentBuilder();
            doc = builder.parse(fileXml);
            NodeList nodeListOfRoute = doc.getElementsByTagName("aixm:Route");
            System.out.println("nodeListOfRoute:" + nodeListOfRoute.getLength());
            for (int i = 0; i < nodeListOfRoute.getLength(); i++) {
                Element elementOfRoute = (Element) nodeListOfRoute.item(i);
                RouteData DORouteData = new RouteData();
                String ID = null;
                String designatorSecondLetter = null;
                String designatorNumber = null;
                String type = null;


                ID = elementOfRoute.getAttribute("gml:id");
                if (elementOfRoute.getElementsByTagName("aixm:designatorSecondLetter").getLength() > 0) {
                    designatorSecondLetter = elementOfRoute.getElementsByTagName("aixm:designatorSecondLetter").item(0).getTextContent();
                }
                if (elementOfRoute.getElementsByTagName("aixm:designatorNumber").getLength() > 0) {
                    designatorNumber = elementOfRoute.getElementsByTagName("aixm:designatorNumber").item(0).getTextContent();
                }
                if (elementOfRoute.getElementsByTagName("aixm:type").getLength() > 0) {
                    type = elementOfRoute.getElementsByTagName("aixm:type").item(0).getTextContent();
                }

                if (debug_readXML) {
                    System.out.println("ID:" + ID);
                    System.out.println("designatorSecondLetter:" + designatorSecondLetter);
                    System.out.println("designatorNumber:" + designatorNumber);
                    System.out.println("type:" + type);
                    System.out.println("------------------------------------------------------");
                } else {
                    DORouteData.setID(ID);
                    DORouteData.setDesignatorSecondLetter(designatorSecondLetter);
                    DORouteData.setDesignatorNumber(designatorNumber);
                    DORouteData.setType(type);

                    if (!RouteDataDAOFactory.getRouteDataDAOInstance(dbc.getDbConnection()).doCreate(DORouteData)) {
                        System.out.println("ERROR: " + ID);
                    } else {
                        System.out.println("Route: " + i);
                    }
                }

            }
            } catch (ParserConfigurationException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (SAXException e1) {
            e1.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void getLocationToStatic() throws Exception {

    }
}

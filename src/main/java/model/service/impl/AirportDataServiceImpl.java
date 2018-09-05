package model.service.impl;


import model.DO.AirportData;
import model.base.OsName;
import model.connect.DatabaseConnection;
import model.dao.factory.AirportDataDAOFactory;
import model.service.IAirportDataService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class AirportDataServiceImpl implements IAirportDataService {
    private DatabaseConnection dbc = new DatabaseConnection();
    private boolean debug_readXML = false;
    //private boolean debug_readXML = true;
    private String url_win = "D:\\Dropbox\\5.学习\\GIS\\arcgis-runtime-sdk-java-100.2.1\\swimSystem\\client\\data_original\\airport.xml";
    private String url_mac = "";

    @Override
    public void readDataFromXml() {
        //String point = "[";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;
        File fileXml = null;
        try {
            if (OsName.getSystem() == OsName.WINDOWS) {
                fileXml = new File(url_win);
            } else {
                fileXml = new File(url_mac);
            }
            builder = factory.newDocumentBuilder();
            doc = builder.parse(fileXml);
            NodeList list = doc.getElementsByTagName("aixm:AirportHeliport");
            for (int i = 0; i < list.getLength(); i++) {
                AirportData airportData = new AirportData();
                String name = null;
                String code = null;
                Element element = (Element) list.item(i);
                String ID = element.getElementsByTagName("gml:identifier").item(0).getTextContent();
                if (element.getElementsByTagName("aixm:name").getLength() > 1) {
                    name = element.getElementsByTagName("aixm:name").item(0).getTextContent();
                }
                String cityName = element.getElementsByTagName("aixm:servedCity").item(0).getTextContent();
                if (element.getElementsByTagName("aixm:locationIndicatorICAO").getLength() > 0) {
                    code = element.getElementsByTagName("aixm:locationIndicatorICAO").item(0).getTextContent();
                }
                String[] location = element.getElementsByTagName("gml:pos").item(0).getTextContent().split("\\s+");


                if (debug_readXML) {
                    System.out.println("ID:" + ID);
                    System.out.println("ICAO code:" + code);
                    System.out.println("Name:" + name);
                    System.out.println("City Name:" + cityName);
                    System.out.println("Location:" + location[0] + "," + location[1]);
                    System.out.println("---------------------------------");
                } else {
                    airportData.setID(ID);
                    airportData.setCodeICAO(code);
                    airportData.setNameEn(name);
                    airportData.setCity(cityName);
                    //纬度
                    airportData.setLatitude(location[0]);
                    //经度
                    airportData.setLongtitude(location[1]);

                    if (!AirportDataDAOFactory.getIAirportDataDAOInstance(this.dbc.getDbConnection()).doCreate(airportData)) {
                        System.out.println("Error:" + doc.getElementsByTagName("aixm:locationIndicatorICAO").item(i).getTextContent());
                    }
                    System.out.println(Integer.toString(i));
                    //point = point + "],\n";
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
        //String text = null;
        //text = "var data;\n" +
        //        "data = {\n" +
        //        "    \"data\":"+
        //        point+
        //        " 'total': 5365,\n" +
        //        "    \"rt_loc_cnt\": 47764510,\n" +
        //        "    \"errorno\": 0,\n" +
        //        "    \"NearestTime\": \"2014-08-29 15:20:00\",\n" +
        //        "    \"userTime\": \"2014-08-29 15:32:11\"\n" +
        //        "};";
        //File file = new File("D:\\Dropbox\\5.??\\GIS\\arcgis-runtime-sdk-java-100.2.1\\swimSystem\\client\\src\\com\\swim\\test\\air.js");
        //try {
        //    PrintWriter printWriter = new PrintWriter(file);
        //    printWriter.print(text);
        //    printWriter.close();
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}
    }

    @Override
    public void readDataFromXmlToUpdate() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;
        File fileXml = null;
        try {
            if (OsName.getSystem() == OsName.WINDOWS) {
                fileXml = new File(url_win);
            } else {
                fileXml = new File(url_mac);
            }

            builder = factory.newDocumentBuilder();
            doc = builder.parse(fileXml);
            NodeList list = doc.getElementsByTagName("aixm:AirportHeliport");
            for (int i = 0; i < list.getLength(); i++) {
                AirportData airportData = new AirportData();
                String name = null;
                String code = null;
                String controlType = null;
                String designatorIATA = null;
                Element element = (Element) list.item(i);
                String ID = element.getElementsByTagName("gml:identifier").item(0).getTextContent();
                if (element.getElementsByTagName("aixm:name").getLength() > 1) {
                    name = element.getElementsByTagName("aixm:name").item(0).getTextContent();
                }
                String cityName = element.getElementsByTagName("aixm:servedCity").item(0).getTextContent();
                if (element.getElementsByTagName("aixm:locationIndicatorICAO").getLength() > 0) {
                    code = element.getElementsByTagName("aixm:locationIndicatorICAO").item(0).getTextContent();
                }
                String[] location = element.getElementsByTagName("gml:pos").item(0).getTextContent().split("\\s+");
                if (element.getElementsByTagName("aixm:designatorIATA").getLength() > 0) {
                    designatorIATA = element.getElementsByTagName("aixm:designatorIATA").item(0).getTextContent();
                }
                if (element.getElementsByTagName("aixm:controlType").getLength() > 0) {
                    controlType = element.getElementsByTagName("aixm:controlType").item(0).getTextContent();
                }

                if (debug_readXML) {
                    System.out.println("ID:" + ID);
                    System.out.println("ICAO code:" + code);
                    System.out.println("controlType:" + controlType);
                    System.out.println("designatorIATA:" + designatorIATA);
                    System.out.println("Name:" + name);
                    System.out.println("City Name:" + cityName);
                    System.out.println("Location:" + location[0] + "," + location[1]);
                    System.out.println("---------------------------------");
                } else {
                    airportData.setID(ID);
                    airportData.setCodeICAO(code);
                    airportData.setControlType(controlType);
                    airportData.setDesignatorIATA(designatorIATA);
                    airportData.setNameEn(name);
                    airportData.setCity(cityName);
                    //纬度
                    airportData.setLatitude(location[0]);
                    //经度
                    airportData.setLongtitude(location[1]);

                    if (!AirportDataDAOFactory.getIAirportDataDAOInstance(this.dbc.getDbConnection()).doUpdata(airportData)) {
                        System.out.println("Error:" + doc.getElementsByTagName("aixm:locationIndicatorICAO").item(i).getTextContent());
                    }
                    System.out.println(Integer.toString(i));
                    //point = point + "],\n";
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

package model.service.impl;


import model.DO.FaaNavaidData;
import model.DO.NavaidData;
import model.base.OsName;
import model.connect.DatabaseConnection;
import model.dao.factory.FaaNavaidDataDAOFactory;
import model.dao.factory.NavaidDataDAOFactory;
import model.service.INavaidDataService;
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


public class NavaidDataServiceImpl implements INavaidDataService {
    private DatabaseConnection dbc = new DatabaseConnection();
    private boolean debug_readXML = false;
    //private boolean debug_readXML = true;
    private String url_win = "D:\\Dropbox\\5.??\\GIS\\arcgis-runtime-sdk-java-100.2.1\\swimSystem\\client\\src\\com\\swim\\data_original\\navaid.xml";
    private String url_mac = "";

    @Override
    public void readDataFromXml() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;
        File fileXml = null;
        try {
            if(OsName.getSystem() == OsName.WINDOWS){
                fileXml = new File(url_win);
            }
            else{
                fileXml = new File(url_mac);
            }

            builder = factory.newDocumentBuilder();
            doc = builder.parse(fileXml);
            NodeList list = doc.getElementsByTagName("aixm:Navaid");
            for(int i = 0; i<list.getLength(); i++){
                NavaidData navaidData = new NavaidData();

                Element element = (Element) list.item(i);

                String ID = element.getElementsByTagName("gml:identifier").item(0).getTextContent();
                String designator = element.getElementsByTagName("aixm:designator").item(0).getTextContent();
                String name = element.getElementsByTagName("aixm:name").item(0).getTextContent();
                String type = element.getElementsByTagName("aixm:type").item(0).getTextContent();
                String[] location = element.getElementsByTagName("gml:pos").item(0).getTextContent().split("\\s+");

                if (debug_readXML){
                    System.out.println("ID:" + ID);
                    System.out.println("Designator:" + designator);
                    System.out.println("Name:" + name);
                    System.out.println("Type:" + type);
                    System.out.println("Location:" + location[0] + "," + location[1]);
                    System.out.println("---------------------------------");
                }
                else{
                    navaidData.setID(ID);
                    navaidData.setDesignator(designator);
                    navaidData.setName(name);
                    navaidData.setType(type);
                    //Î³¶È
                    navaidData.setLatitude(location[0]);
                    //¾­¶È
                    navaidData.setLongtitude(location[1]);
                    if(!NavaidDataDAOFactory.getINavaidDataDAOInstance(dbc.getDbConnection()).doCreate(navaidData)){
                        System.out.println("Error:" + Integer.toString(i));
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
    public void getLocationToStatic() throws Exception {
        String point = "[";
        String text = null;
        List<NavaidData> navaidData = null;

        navaidData = NavaidDataDAOFactory.getINavaidDataDAOInstance(dbc.getDbConnection()).findAll();

        for (int i = 3014; i < navaidData.size(); i++) {
            String latitude = null;
            String longtitude = null;
            longtitude = navaidData.get(i).getLatitude();
            latitude = navaidData.get(i).getLongtitude();

            point = point + "[" + longtitude + "," + latitude + ",1]\n,";
        }

        text = "var navaidLocationData;\n" +
                "navaidLocationData = {\n" +
                "    \"navaidLocationData\":"+
                point + "],\n" +
                " 'total': 5365,\n" +
                "    \"rt_loc_cnt\": 47764510,\n" +
                "    \"errorno\": 0,\n" +
                "    \"NearestTime\": \"2014-08-29 15:20:00\",\n" +
                "    \"userTime\": \"2014-08-29 15:32:11\"\n" +
                "};";

        File file = new File("D:\\Dropbox\\SWIMSystem\\client\\src\\com\\swim\\mian\\navaidStaticLoction.js");

        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.print(text);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dataFusion() throws Exception {
        List<FaaNavaidData> faaNavaidDataList = null;

        faaNavaidDataList = FaaNavaidDataDAOFactory.getFaaNavaidDataDAOInstance(dbc.getDbConnection()).findAll();

        for(int i = 0; i < faaNavaidDataList.size(); i++){
            FaaNavaidData faaNavaidData = faaNavaidDataList.get(i);
            NavaidData navaidData = new NavaidData();
            navaidData.setDesignator(faaNavaidData.getDesignator());
            navaidData.setID(faaNavaidData.getID());
            navaidData.setLatitude(faaNavaidData.getLatitude());
            navaidData.setLongtitude(faaNavaidData.getLongtitude());
            navaidData.setName(faaNavaidData.getName());
            navaidData.setNavaidARTCC(faaNavaidData.getNavaidARTCC());
            navaidData.setNavaidIdentifier(faaNavaidData.getNavaidIdentifier());
            navaidData.setNavaidState(faaNavaidData.getNavaidState());
            navaidData.setType(faaNavaidData.getType());
            if(!NavaidDataDAOFactory.getINavaidDataDAOInstance(dbc.getDbConnection()).doCreate(navaidData)){
                System.out.println("Error:" + Integer.toString(i));
            } else {
                System.out.println("i:" + i);
            }
        }
    }
}

package model.service.impl;


import model.DO.AirTrafficManagementServiceData;
import model.base.OsName;
import model.connect.DatabaseConnection;
import model.dao.factory.AirTrafficManagementServiceDataDAOFactory;
import model.service.IAirTrafficManagementServiceDataService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class AirTrafficManagementServiceDataServiceImpl implements IAirTrafficManagementServiceDataService {
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
        url = directory.getAbsolutePath() + "/client/src/com/swim/data_original/airTrafficManagementService.xml";

        try{
            if(OsName.getSystem() == OsName.WINDOWS){
                fileXml = new File(url);
            }
            else{
                fileXml = new File(url);
            }
            builder = factory.newDocumentBuilder();
            doc = builder.parse(fileXml);
            NodeList list = doc.getElementsByTagName("aixm:AirTrafficManagementService");
            for(int i = 0; i<list.getLength(); i++){
                Element element = (Element) list.item(i);
                AirTrafficManagementServiceData DO = new AirTrafficManagementServiceData();

                String ID[] = element.getElementsByTagName("gml:identifier").item(0).getTextContent().split("_");
                DO.setID(ID[1]);
                NodeList list_clientAirspace = element.getElementsByTagName("aixm:clientAirspace");
                for(int j = 0; j<list_clientAirspace.getLength(); j++){
                    Element element1 = (Element) list_clientAirspace.item(j);
                    String[] clientAirspace = element1.getAttribute("xlink:href").split(":");

                    if(debug_readXML){
                        System.out.println("ID:" + ID[1]);
                        System.out.println("clientAirspace:" + clientAirspace[2]);
                    }
                    else{
                        DO.setClientAirspaceID(clientAirspace[2]);
                        if (!AirTrafficManagementServiceDataDAOFactory.getAirTrafficManagementServiceDataDAOInstance(this.dbc.getDbConnection()).doCreate(DO)){
                            System.out.println("Error:" + Integer.toString(i));
                        }
                        System.out.println(Integer.toString(i) + "." + Integer.toString(j));
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
}

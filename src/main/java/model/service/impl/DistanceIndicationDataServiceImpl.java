package model.service.impl;


import model.DO.DistanceIndicationData;
import model.base.OsName;
import model.connect.DatabaseConnection;
import model.dao.factory.DistanceIndicationDataDAOFactory;
import model.service.IDistanceIndicationDataService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DistanceIndicationDataServiceImpl implements IDistanceIndicationDataService {
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
        url = directory.getAbsolutePath() + "/client/data_original/distanceIndication.xml";

        try {
            if (OsName.getSystem() == OsName.WINDOWS) {
                fileXml = new File(url);
            } else {
                fileXml = new File(url);
            }
            builder = factory.newDocumentBuilder();
            doc = builder.parse(fileXml);

            NodeList nodeList = doc.getElementsByTagName("aixm:DistanceIndication");
            System.out.println("nodeList:" + nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                DistanceIndicationData DO = new DistanceIndicationData();
                String ID = null;
                String distance = null;
                String distanceUOM = null;
                String fix = null;
                String pointChoiceNavaidSystem = null;

                if(element.getElementsByTagName("gml:identifier").getLength() > 0){
                    ID = element.getElementsByTagName("gml:identifier").item(0).getTextContent().split("_")[1];
                }
                if(element.getElementsByTagName("aixm:distance").getLength() > 0){
                    distance = element.getElementsByTagName("aixm:distance").item(0).getTextContent();
                    distanceUOM = ((Element)element.getElementsByTagName("aixm:distance").item(0)).getAttribute("uom");
                }
                if(element.getElementsByTagName("aixm:fix").getLength() > 0){
                    fix = ((Element)element.getElementsByTagName("aixm:fix").item(0)).getAttribute("xlink:href");
                }
                if(element.getElementsByTagName("aixm:pointChoice_navaidSystem").getLength() > 0){
                    pointChoiceNavaidSystem = ((Element)element.getElementsByTagName("aixm:pointChoice_navaidSystem").item(0)).getAttribute("xlink:href");
                }

                if(debug_readXML){
                    System.out.println("ID:" + ID);
                    System.out.println("distance:" + distance);
                    System.out.println("distanceUOM:" + distanceUOM);
                    System.out.println("fix:" + fix);
                    System.out.println("pointChoiceNavaidSystem:" + pointChoiceNavaidSystem);
                } else {
                    DO.setID(ID);
                    DO.setDistance(distance);
                    DO.setDistanceUOM(distanceUOM);
                    DO.setFix(fix);
                    DO.setPointChoiceNavaidSystem(pointChoiceNavaidSystem);

                    if(!DistanceIndicationDataDAOFactory.getDistanceIndicationDataDAOInstance(dbc.getDbConnection()).doCreate(DO)){
                        System.out.println("ERROR: " + ID);
                    } else {
                        System.out.println(i);
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

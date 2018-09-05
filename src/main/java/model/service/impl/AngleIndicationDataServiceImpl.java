package model.service.impl;


import model.DO.AngleIndicationData;
import model.base.OsName;
import model.connect.DatabaseConnection;
import model.dao.factory.AngleIndicationDataDAOFactory;
import model.service.IAngleIndicationDataService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class AngleIndicationDataServiceImpl implements IAngleIndicationDataService {
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
        url = directory.getAbsolutePath() + "/client/src/com/swim/data_original/angleIndication.xml";

        try{
            if(OsName.getSystem() == OsName.WINDOWS){
                fileXml = new File(url);
            }
            else{
                fileXml = new File(url);
            }
            builder = factory.newDocumentBuilder();
            doc = builder.parse(fileXml);
            NodeList list = doc.getElementsByTagName("aixm:AngleIndication");
            for(int i = 0; i<list.getLength(); i++){
                Element element = (Element) list.item(i);
                AngleIndicationData DO = new AngleIndicationData();

                String ID[] = element.getElementsByTagName("gml:identifier").item(0).getTextContent().split("_");
                String angle = element.getElementsByTagName("aixm:angle").item(0).getTextContent();
                String angleType = element.getElementsByTagName("aixm:angleType").item(0).getTextContent();
                Element elementPointChoice_navaidSystem = (Element) element.getElementsByTagName("aixm:pointChoice_navaidSystem").item(0);
                String[] pointChoice_navaidSystem = elementPointChoice_navaidSystem.getAttribute("xlink:href").split(":");

                if(debug_readXML){
                    System.out.println("ID:" + ID[1]);
                    System.out.println("Angle:" + angle);
                    System.out.println("AngleType:" + angleType);
                    System.out.println("PointChoice_NavaidSystem:" + pointChoice_navaidSystem[2]);
                } else {
                    DO.setID(ID[1]);
                    DO.setAngle(angle);
                    DO.setAngleType(angleType);
                    DO.setPointChoice_navaidSystem(pointChoice_navaidSystem[2]);
                    if(!AngleIndicationDataDAOFactory.getAngleIndicationDataDAOInstance(this.dbc.getDbConnection()).doCreate(DO)){
                        System.out.println("Error:" + ID[1]);
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

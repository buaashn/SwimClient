package model.service.impl;


import model.DO.DesignatedPointData;
import model.DO.FaaDesignatedPointData;
import model.base.OsName;
import model.connect.DatabaseConnection;
import model.dao.factory.DesignatedPointDataDAOFactory;
import model.dao.factory.FaaDesignatedPointDataDAOFactory;
import model.service.IDesignatedPointDataService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author sdush
 */
public class DesignatedPointDataServiceImpl implements IDesignatedPointDataService {
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
        url = directory.getAbsolutePath() + "/client/data_original/designatedPoint.xml";

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
                DesignatedPointData DO = new DesignatedPointData();
                String ID = null;
                String designator = null;
                String type = null;
                String name = null;
                String latitude = null;
                String longtitude = null;

                if(elementOfDesignatePoint.getElementsByTagName("gml:identifier").getLength() > 0){
                    ID = elementOfDesignatePoint.getElementsByTagName("gml:identifier").item(0).getTextContent();
                }
                if(elementOfDesignatePoint.getElementsByTagName("aixm:designator").getLength() > 0){
                    designator = elementOfDesignatePoint.getElementsByTagName("aixm:designator").item(0).getTextContent();
                }
                if(elementOfDesignatePoint.getElementsByTagName("aixm:type").getLength() > 0){
                    type = elementOfDesignatePoint.getElementsByTagName("aixm:type").item(0).getTextContent();
                }
                if(elementOfDesignatePoint.getElementsByTagName("aixm:name").getLength() > 0){
                    name = elementOfDesignatePoint.getElementsByTagName("aixm:name").item(0).getTextContent();
                }
                if(elementOfDesignatePoint.getElementsByTagName("gml:pos").getLength() > 0){
                    latitude = elementOfDesignatePoint.getElementsByTagName("gml:pos").item(0).getTextContent().split("\\s+")[0];
                    longtitude = elementOfDesignatePoint.getElementsByTagName("gml:pos").item(0).getTextContent().split("\\s+")[1];
                }

                if(debug_readXML){
                    System.out.println("ID:" + ID);
                    System.out.println("designator:" + designator);
                    System.out.println("type:" + type);
                    System.out.println("Name:" + name);
                    System.out.println("Location:" + latitude + "," + longtitude);
                } else {
                    DO.setID(ID);
                    DO.setDesignator(designator);
                    DO.setType(type);
                    DO.setName(name);
                    DO.setLatitude(latitude);
                    DO.setLongtitude(longtitude);

                    if(!DesignatedPointDataDAOFactory.getDesignatedPointDataDAOInstance(dbc.getDbConnection()).doCreate(DO)){
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

    @Override
    public void dataFusion() throws Exception {
        List<FaaDesignatedPointData> faaDesignatedPointDataList = null;
        faaDesignatedPointDataList = FaaDesignatedPointDataDAOFactory.getFaaDesignatedPointDataDAOInstance(dbc.getDbConnection()).findAll();

        for (int i = 0; i < faaDesignatedPointDataList.size(); i++){
            FaaDesignatedPointData faaDesignatedPointData = faaDesignatedPointDataList.get(i);
            DesignatedPointData designatedPointData = null;
            designatedPointData = new DesignatedPointData();

            designatedPointData.setName(faaDesignatedPointData.getName());
            designatedPointData.setDesignator(faaDesignatedPointData.getDesignator());
            designatedPointData.setID(faaDesignatedPointData.getID());
            designatedPointData.setType(faaDesignatedPointData.getType());
            designatedPointData.setLatitude(faaDesignatedPointData.getLongtitude());
            designatedPointData.setLongtitude(faaDesignatedPointData.getLatitude());

            if(!DesignatedPointDataDAOFactory.getDesignatedPointDataDAOInstance(dbc.getDbConnection()).doCreate(designatedPointData)){
                System.out.println("ERROR: " + designatedPointData.getID());
            } else {
                System.out.println(i);
            }
        }

    }
}

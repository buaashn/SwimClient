package model.service.impl;


import model.DO.OrganisationAuthorityData;
import model.base.OsName;
import model.connect.DatabaseConnection;
import model.dao.factory.OrganisationAuthorityDataDAOFactory;
import model.service.IOrganisationAuthorityDataService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class OrganisationAuthorityDataServiceImpl implements IOrganisationAuthorityDataService {

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
        url = directory.getAbsolutePath() + "/client/data_original/organisationAuthority.xml";

        try {
            if (OsName.getSystem() == OsName.WINDOWS) {
                fileXml = new File(url);
            } else {
                fileXml = new File(url);
            }
            builder = factory.newDocumentBuilder();
            doc = builder.parse(fileXml);

            NodeList nodeList = doc.getElementsByTagName("aixm:OrganisationAuthority");
            System.out.println("nodeList:" + nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                OrganisationAuthorityData DO = new OrganisationAuthorityData();
                String ID = null;
                String name = null;
                String designator = null;
                String type = null;

                if(element.getElementsByTagName("gml:identifier").getLength() > 0){
                    ID = element.getElementsByTagName("gml:identifier").item(0).getTextContent();
                }
                if(element.getElementsByTagName("aixm:name").getLength() > 0){
                    name = element.getElementsByTagName("aixm:name").item(0).getTextContent();
                }
                if(element.getElementsByTagName("aixm:designator").getLength() > 0){
                    designator = element.getElementsByTagName("aixm:designator").item(0).getTextContent();
                }
                if(element.getElementsByTagName("aixm:type").getLength() > 0){
                    type = element.getElementsByTagName("aixm:type").item(0).getTextContent();
                }

                if(debug_readXML){
                    System.out.println("ID:" + ID);
                    System.out.println("name:" + name);
                    System.out.println("designator:" + designator);
                    System.out.println("type:" + type);
                    System.out.println("-------------------------------");
                } else {
                    DO.setID(ID);
                    DO.setName(name);
                    DO.setDesignator(designator);
                    DO.setType(type);

                    if(!OrganisationAuthorityDataDAOFactory.getOrganisationAuthorityDataInstance(dbc.getDbConnection()).doCreate(DO)){
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

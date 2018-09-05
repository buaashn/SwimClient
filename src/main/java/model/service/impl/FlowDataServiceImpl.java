package model.service.impl;


import model.DO.FlowData;
import model.base.OsName;
import model.connect.DatabaseConnection;
import model.dao.factory.FlowDataDAOFactory;
import model.service.IFlowDataService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class FlowDataServiceImpl implements IFlowDataService {
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
        url = directory.getAbsolutePath() + "/client/data_original/flow.xml";

        try {
            if (OsName.getSystem() == OsName.WINDOWS) {
                fileXml = new File(url);
            } else {
                fileXml = new File(url);
            }
            builder = factory.newDocumentBuilder();
            doc = builder.parse(fileXml);

            NodeList nodeList = doc.getElementsByTagName("adrext:Flow");
            System.out.println("nodeList:" + nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                FlowData DO = new FlowData();
                
                String ID = null;
                String flowName = null;
                String flowID = null;
                String downstreamFlowElementChoice = null;
                String downstreamFlowElement = null;
                String upstreamFlowElementChoice = null;
                String upstreamFlowElement = null;

                if(element.getElementsByTagName("gml:identifier").getLength() > 0){
                    ID = element.getElementsByTagName("gml:identifier").item(0).getTextContent();
                }
                if(element.getElementsByTagName("adrext:flowName").getLength() > 0){
                    flowName = element.getElementsByTagName("adrext:flowName").item(0).getTextContent();
                }
                if(element.getElementsByTagName("adrext:flowId").getLength() > 0){
                    flowID = element.getElementsByTagName("adrext:flowId").item(0).getTextContent();
                }
                if(element.getElementsByTagName("adrext:downstreamFlowElement").getLength() > 0){
                    Element elementDownstreamFlow = (Element) element.getElementsByTagName("adrext:downstreamFlowElement").item(0);
                    downstreamFlowElementChoice = elementDownstreamFlow.getElementsByTagName("adrext:FlowLocationElement").item(0).getChildNodes().item(1).getNodeName().split("_")[1];
                    downstreamFlowElement = ((Element)elementDownstreamFlow.getElementsByTagName("adrext:FlowLocationElement").item(0).getChildNodes().item(1)).getAttribute("xlink:href").split(":")[2];
                }
                if(element.getElementsByTagName("adrext:upstreamFlowElement").getLength() > 0){
                    Element elementUpstreamFlow = (Element) element.getElementsByTagName("adrext:upstreamFlowElement").item(0);
                    upstreamFlowElementChoice = elementUpstreamFlow.getElementsByTagName("adrext:FlowLocationElement").item(0).getChildNodes().item(1).getNodeName().split("_")[1];
                    upstreamFlowElement = ((Element)elementUpstreamFlow.getElementsByTagName("adrext:FlowLocationElement").item(0).getChildNodes().item(1)).getAttribute("xlink:href").split(":")[2];
                }

                if(debug_readXML){
                    System.out.println("ID:" + ID);
                    System.out.println("flowName:" + flowName);
                    System.out.println("flowID:" + flowID);
                    System.out.println("downstreamFlowElementChoice:" + downstreamFlowElementChoice);
                    System.out.println("downstreamFlowElement:" + downstreamFlowElement);
                    System.out.println("upstreamFlowElementChoice:" + upstreamFlowElementChoice);
                    System.out.println("upstreamFlowElement:" + upstreamFlowElement);
                    System.out.println("---------------------------------------------");
                } else {
                    DO.setID(ID);
                    DO.setFlowName(flowName);
                    DO.setFlowID(flowID);
                    DO.setDownstreamFlowElementChoice(downstreamFlowElementChoice);
                    DO.setDownstreamFlowElement(downstreamFlowElement);
                    DO.setUpstreamFlowElementChoice(upstreamFlowElementChoice);
                    DO.setUpstreamFlowElement(upstreamFlowElement);

                    if(!FlowDataDAOFactory.getFlowDataDAOInstance(dbc.getDbConnection()).doCreate(DO)){
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

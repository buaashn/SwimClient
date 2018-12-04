package gui.component;

import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import io.datafx.controller.ViewController;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import model.DO.AirportData;
import model.DO.RadarTestData;
import model.connect.DatabaseConnection;
import model.connect.TCPConnect;
import model.dao.factory.RadarTestDataDAOFactory;
import model.service.factory.RadarTestDataServiceFactory;

import javax.annotation.PostConstruct;
import javax.swing.plaf.PanelUI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ViewController(value = "/fxml/ui/radar.fxml", title = "Material Design Example")
public class radarController {
    @FXML
    private WebView webview;
    @FXML
    public WebEngine engine;
    @FXML
    private TreeTableView radarDataTable;
    @FXML
    private TreeTableColumn<RadarTestData, String> radarTimeColumn;
    @FXML
    private TreeTableColumn<RadarTestData, String> radarFlightTagColumn;
    @FXML
    private TreeTableColumn<RadarTestData, String> radarDirectionColumn;
    @FXML
    private TreeTableColumn<RadarTestData, String> radarLatitudeColumn;
    @FXML
    private TreeTableColumn<RadarTestData, String> radarLongtitudeColumn;


    DatabaseConnection dbc = new DatabaseConnection();
    private boolean debugFlag = false;

    @PostConstruct
    public void init() {
        setupWebView();

        setupRadarTreeTable();
    }

    @FXML
    private void onShowRadarButtonClick(){
        showRadar(engine);
        showRadarToTable();
    }

    private void setupWebView(){
        engine = webview.getEngine();
        webview.setZoom(0.8);
        // 允许执行JavaScript语句
        engine.setJavaScriptEnabled(true);
        engine.load("file:/D:\\Dropbox\\SwimClient\\src\\main\\java\\gui\\web\\baiduMap.html");
        //engine.load("http://lbsyun.baidu.com/jsdemo.htm#a3_2");
        //System.out.println(this.getClass().getResource("baiduMap.html").toString());
        //System.out.println(this.getClass().getResource("baiduMap.html").toString());
    }

    public void showRadar(WebEngine engine){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        TCPConnect tcpConnect = new TCPConnect();
        tcpConnect.sendText(df.format(new Date())+":Radar data request!");
        tcpConnect.sendText(df.format(new Date())+":Radar data multicast has started!");
        List<RadarTestData> list = null;
        String time = "20180103161622";

        list = RadarTestDataServiceFactory.getRadarTestDataServiceInstance().getRadaTestDataByTime(time);

        for (int i = 0; i < list.size(); i++) {
            String flightTag;
            String nameOfIcon = "flightIconD";
            int direction;
            flightTag = list.get(i).getFlightTag();
            direction = Integer.parseInt(list.get(i).getDirection());
            if (direction % 10 < 5){
                direction = direction / 10 * 10;
            } else {
                direction = (direction / 10 + 1) * 10;
            }
            if (direction == 360) {
                direction =0;
            }
            nameOfIcon += String.format("%03d",direction);

            String js = "var " + flightTag + " = new BMap.Marker(new BMap.Point(" +
                    list.get(i).getLontitude() + "," + list.get(i).getLatitude() + "), {icon:" + nameOfIcon + "});";
            if (debugFlag) {
                System.out.println("js:" + js);
            }
            engine.executeScript(js);

            js = "var label = new BMap.Label(\"" + flightTag + "\",{offset:new BMap.Size(20,-15)});";
            if (debugFlag) {
                System.out.println("js:" + js);
            }
            engine.executeScript(js);

            js = "label.setStyle({border:\"0\",backgroundColor:\"yellow\"});";
            if (debugFlag) {
                System.out.println("js:" + js);
            }
            engine.executeScript(js);

            js = flightTag + ".setLabel(label);";
            if (debugFlag) {
                System.out.println("js:" + js);
            }
            engine.executeScript(js);

            js = "window.map.addOverlay(" + flightTag + ");";
            if (debugFlag) {
                System.out.println("js:" + js);
            }
            engine.executeScript(js);

        }
    }

    private void setupRadarTreeTable(){
        radarTimeColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<RadarTestData, String> param) ->
            new ReadOnlyStringWrapper(param.getValue().getValue().getStoreTime())
        );
        radarFlightTagColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<RadarTestData, String> param) ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getFlightTag())
        );
        radarDirectionColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<RadarTestData, String> param) ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getDirection())
        );
        radarLatitudeColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<RadarTestData, String> param) ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getLatitude())
        );
        radarLongtitudeColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<RadarTestData, String> param) ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getLontitude())
        );
    }

    private void showRadarToTable(){

        List<RadarTestData> radarData = null;
        try {
            radarData = RadarTestDataDAOFactory.getRadarDataDAOInstance(dbc.getDbConnection()).doFindByTime("20180103161622");
        } catch (Exception e) {
            e.printStackTrace();
        }

        ObservableList<RadarTestData> radarTestData = FXCollections.observableArrayList();
        System.out.println(radarTestData.size());
        for(int i = 0; i < radarData.size(); i ++) {
            radarTestData.add(radarData.get(i));
        }
        radarDataTable.setRoot(new RecursiveTreeItem<>(radarTestData, RecursiveTreeObject::getChildren));
        radarDataTable.setShowRoot(false);
    }
}

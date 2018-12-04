package gui.component;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import io.datafx.controller.ViewController;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import model.DO.AirportData;
import model.connect.DatabaseConnection;
import model.connect.TCPConnect;
import model.dao.factory.AirportDataDAOFactory;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ViewController(value = "/fxml/ui/airport.fxml")
public class airportController {
    @FXML
    private WebView webview;
    @FXML
    public WebEngine engine;
    @FXML
    private JFXTreeTableView airportTreeTable;
    @FXML
    private TreeTableColumn<AirportData, String> airportCodeICAOTreeColumn;
    @FXML
    private TreeTableColumn<AirportData, String> airportNameTreeColumn;
    @FXML
    private TreeTableColumn<AirportData, String> airportControlTypeTreeColumn;
    @FXML
    private TreeTableColumn<AirportData, String> airportDesignatorIATATreeColumn;
    @FXML
    private TreeTableColumn<AirportData, String> airportCityTreeColumn;
    @FXML
    private TreeTableColumn<AirportData, String> airportLatitudeTreeColumn;
    @FXML
    private TreeTableColumn<AirportData, String> airportLongtitudeTreeColumn;
    // Airport Search Field
    @FXML
    private JFXTextField airportSearchFied;

    // Airport Count Label
    @FXML
    private Label airportCount;

    // Airport ComboBox
    @FXML
    private JFXComboBox<String> airportComboBox;

    @FXML
    private JFXColorPicker airportColor;

    private static final String PREFIX = "( ";
    private static final String POSTFIX = " )";

    DatabaseConnection dbc = new DatabaseConnection();

    @PostConstruct
    public void init() {
        setupWebView();
        setupAirport();
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

    private  void setupAirport(){
        airportComboBox.getItems().add("Airport");
        airportComboBox.getItems().add("Eurocontrol");
        airportComboBox.setValue("Airport");

        airportColor.setValue(new Color(0.9569, 0.2667, 0.2, 1));
        //pointColor.setValue(new Color(0.6039, 0.2157, 0.5922, 1));
        setupAirportTreeTable();
    }

    // Tree Table

    /**
     * 初始化Airport界面中的TreeTable
     * 1. 将表格中的列与简单类的字段进行关联
     * 2. 设置搜索栏的监听，输入时调用，对表格中数据进行大小写不敏感的匹配
     * 3. 设置计数统计标签的监听，实时刷新当前表格中数据数量
     */
    private void setupAirportTreeTable(){
        //setupCellValueFactory(airportCodeICAOTreeColumn,AirportData::getCodeICAO);
        // Column to DO
        airportCodeICAOTreeColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<AirportData, String> param) ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getCodeICAO())
        );
        airportNameTreeColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<AirportData, String> param) ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getNameEn()));
        airportControlTypeTreeColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<AirportData, String> param) ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getControlType()));
        airportDesignatorIATATreeColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<AirportData, String> param) ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getDesignatorIATA()));
        airportCityTreeColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<AirportData, String> param) ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getCity()));
        airportLatitudeTreeColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<AirportData, String> param) ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getLatitude()));
        airportLongtitudeTreeColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<AirportData, String> param) ->
                new ReadOnlyStringWrapper(param.getValue().getValue().getLongtitude()));

        // SearchField 设置监听
        airportSearchFied.textProperty().addListener(setupAirportSearchField(airportTreeTable));
        airportCount.textProperty()
                .bind( Bindings.createStringBinding(() ->
                                PREFIX + airportTreeTable.getCurrentItemsCount() + POSTFIX,
                        airportTreeTable.currentItemsCountProperty()
                ));
    }

    /**
     * Search Field
     * @param tableView 表格
     * @return 返回是否显示该列数据，如果要显示则返回true，否则返回false
     */

    private ChangeListener<String> setupAirportSearchField(final JFXTreeTableView<AirportData> tableView) {
        return (o, oldVal, newVal) ->
                tableView.setPredicate(airportProp -> {
                    final AirportData airportData = airportProp.getValue();
                    return contain2(airportData.getCodeICAO(),newVal)|
                            contain2(airportData.getCity(),newVal)|
                            contain2(airportData.getControlType(),newVal)|
                            contain2(airportData.getDesignatorIATA(),newVal)|
                            contain2(airportData.getLatitude(),newVal)|
                            contain2(airportData.getLongtitude(),newVal)|
                            contain2(airportData.getNameEn(),newVal);
                });
    }

    /**
     * 通用函数，大小写不敏感的匹配
     * @param input 待检测的字符串
     * @param regex 匹配字段
     * @return 返回比较结果，包含返回ture，否则返回false
     */

    public static boolean contain2(String input, String regex) {
        if(input == null){
            return false;
        }
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        boolean result = m.find();
        return result;
    }

    // *********************************************************************************
    // Button OnClick Listener                                                         *
    // *********************************************************************************

    // Airport Button OnClick Listener
    @FXML
    private void onAirportFileChooserButtonChick(ActionEvent event) throws Exception {
        //fileChooser.setTitle("Open Resource File");
        //fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SQLite database","*.db"));
        //fileChooser.showOpenDialog(rootPane.getScene().getWindow());
    }

    @FXML
    public void onLoadAirportsButtonClick(ActionEvent event) throws Exception {
        if(airportComboBox.getValue() == "Airport"){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            TCPConnect tcpConnect = new TCPConnect();
            tcpConnect.sendText(df.format(new Date())+":Airport data request!");
        } else {
            try
            {
                Thread.currentThread().sleep(6000);//毫秒
            }
            catch(Exception e){}
        }


        ObservableList<AirportData> allAirportData = FXCollections.observableArrayList();
        List<AirportData> airportData = AirportDataDAOFactory.getIAirportDataDAOInstance(dbc.getDbConnection()).findAll();
        ObservableList<AirportData> dummyData = FXCollections.observableArrayList();
        for(int i = 0; i < airportData.size(); i++){
            allAirportData.add(airportData.get(i));
            dummyData.add(airportData.get(i));
        }
        System.out.println(allAirportData.size());
        airportTreeTable.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));
        airportTreeTable.setShowRoot(false);

        //aitportDataTable.setEditable(false);
        //aitportDataTable.setItems(allAirportData);
    }

    @FXML
    public void onShowAirportButtonClick(ActionEvent event) {

        String regHex = Integer.toHexString((int) Math.ceil(airportColor.getValue().getRed()*255));
        String greenHex = Integer.toHexString((int) Math.ceil(airportColor.getValue().getGreen()*255));
        String blueHex = Integer.toHexString((int) Math.ceil(airportColor.getValue().getBlue()*255));
        String color = "'#" + regHex + greenHex + blueHex + "'";
        engine.executeScript("airportColor = " + color);
        engine.executeScript("drawAirport();");
        //engine.executeScript("drawRouteSegement();");
        //System.out.println(airportColor.getValue());
        //System.out.println(Integer.toHexString((int) Math.ceil(airportColor.getValue().getBlue()*255)));
        //System.out.println(Integer.toHexString((int) Math.ceil(airportColor.getValue().getGreen()*255)));
        //System.out.println(Integer.toHexString((int) Math.ceil(airportColor.getValue().getBlue()*255)));
    }

}

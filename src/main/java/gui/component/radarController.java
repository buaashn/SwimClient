package gui.component;

import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import model.DO.RadarTestData;
import model.service.factory.RadarTestDataServiceFactory;

import javax.annotation.PostConstruct;
import javax.swing.plaf.PanelUI;
import java.util.List;

@ViewController(value = "/fxml/ui/radar.fxml", title = "Material Design Example")
public class radarController {
    @FXML
    private WebView webview;
    @FXML
    public WebEngine engine;

    private boolean debugFlag = true;

    @PostConstruct
    public void init() {
        setupWebView();

    }

    @FXML
    private void onShowRadarButtonClick(){
        showRadar(engine);
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
}

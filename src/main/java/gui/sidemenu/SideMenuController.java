package gui.sidemenu;

import com.jfoenix.controls.JFXListView;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import io.datafx.controller.util.VetoException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

import javax.annotation.PostConstruct;
import java.util.Objects;

@ViewController(value = "/fxml/SideMenu.fxml", title = "Material Design Example")
public class SideMenuController {
    @FXMLViewFlowContext
    private ViewFlowContext context;
    @FXML
    @ActionTrigger("aim")
    private Label aim;
    @FXML
    @ActionTrigger("airportImformation")
    private Label airportImformation;
    @FXML
    @ActionTrigger("navaidPoint")
    private Label navaidPoint;
    @FXML
    @ActionTrigger("designatedPoint")
    private Label designatedPoint;
    @FXML
    @ActionTrigger("routeInformation")
    private Label routeInformation;
    @FXML
    @ActionTrigger("airspce")
    private Label airspce;
    @FXML
    @ActionTrigger("radar")
    private Label radar;
    @FXML
    @ActionTrigger("aimFile")
    private Label aimFile;
    @FXML
    @ActionTrigger("aixm")
    private Label aixm;
    @FXML
    @ActionTrigger("flight")
    private Label buflighttton;
    @FXML
    @ActionTrigger("flightInformation")
    private Label flightInformation;
    @FXML
    @ActionTrigger("flightList")
    private Label flightList;
    @FXML
    @ActionTrigger("flightChange")
    private Label flightChange;
    @FXML
    @ActionTrigger("weather")
    private Label weather;
    @FXML
    @ActionTrigger("setting")
    private Label setting;

    @FXML
    private JFXListView<Label> sideList;

    /**
     * init fxml when loaded.
     */
    @PostConstruct
    public void init() {
        Objects.requireNonNull(context, "context");
        FlowHandler contentFlowHandler = (FlowHandler) context.getRegisteredObject("ContentFlowHandler");
        sideList.propagateMouseEventsToParent();
        sideList.getSelectionModel().selectedItemProperty().addListener((o, oldVal, newVal) -> {
            new Thread(()->{
                Platform.runLater(()->{
                    if (newVal != null) {
                        try {
                            contentFlowHandler.handle(newVal.getId());
                        } catch (VetoException exc) {
                            exc.printStackTrace();
                        } catch (FlowException exc) {
                            exc.printStackTrace();
                        }
                    }
                });
            }).start();
        });
        Flow contentFlow = (Flow) context.getRegisteredObject("ContentFlow");
        //bindNodeToController(button, ButtonController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(checkbox, CheckboxController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(combobox, ComboBoxController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(dialogs, DialogController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(icons, IconsController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(listview, ListViewController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(treetableview, TreeTableViewController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(progressbar, ProgressBarController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(radiobutton, RadioButtonController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(slider, SliderController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(spinner, SpinnerController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(textfield, TextFieldController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(highlighter, HighlighterController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(chipview, ChipViewController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(togglebutton, ToggleButtonController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(popup, PopupController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(svgLoader, SVGLoaderController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(pickers, PickersController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(masonry, MasonryPaneController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(scrollpane, ScrollPaneController.class, contentFlow, contentFlowHandler);
        //bindNodeToController(nodesList, NodesListController.class, contentFlow, contentFlowHandler);
    }

    private void bindNodeToController(Node node, Class<?> controllerClass, Flow flow, FlowHandler flowHandler) {
        flow.withGlobalLink(node.getId(), controllerClass);
    }
}

package model.DO;

public class FaaNavaidData {
    private String ID;
    private String type;
    private String designator;
    private String name;
    private String latitude;
    private String longtitude;
    private String navaidIdentifier;
    private String navaidState;
    private String navaidARTCC;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesignator() {
        return designator;
    }

    public void setDesignator(String designator) {
        this.designator = designator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getNavaidIdentifier() {
        return navaidIdentifier;
    }

    public void setNavaidIdentifier(String navaidIdentifier) {
        this.navaidIdentifier = navaidIdentifier;
    }

    public String getNavaidState() {
        return navaidState;
    }

    public void setNavaidState(String navaidState) {
        this.navaidState = navaidState;
    }

    public String getNavaidARTCC() {
        return navaidARTCC;
    }

    public void setNavaidARTCC(String navaidARTCC) {
        this.navaidARTCC = navaidARTCC;
    }
}

package model.DO;

public class RouteData {
    private String ID;
    private String designatorSecondLetter;
    private String designatorNumber;
    private String type;
    private String ID_old;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDesignatorSecondLetter() {
        return designatorSecondLetter;
    }

    public void setDesignatorSecondLetter(String designatorSecondLetter) {
        this.designatorSecondLetter = designatorSecondLetter;
    }

    public String getDesignatorNumber() {
        return designatorNumber;
    }

    public void setDesignatorNumber(String designatorNumber) {
        this.designatorNumber = designatorNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

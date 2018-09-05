package model.DO;

public class FaaRouteData {
    private String ID;
    private String designatorSecondLetter;
    private String designatorNumber;
    private String type;
    private String propertyName;
    private String noteID;
    private String note;

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
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

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getNoteID() {
        return noteID;
    }

    public void setNoteID(String noteID) {
        this.noteID = noteID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

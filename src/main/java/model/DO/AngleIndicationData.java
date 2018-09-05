package model.DO;

public class AngleIndicationData {
    private String ID;
    private String angle;
    private String angleType;
    private String pointChoice_navaidSystem;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAngle() {
        return angle;
    }

    public void setAngle(String angle) {
        this.angle = angle;
    }

    public String getAngleType() {
        return angleType;
    }

    public void setAngleType(String angleType) {
        this.angleType = angleType;
    }

    public String getPointChoice_navaidSystem() {
        return pointChoice_navaidSystem;
    }

    public void setPointChoice_navaidSystem(String pointChoice_navaidSystem) {
        this.pointChoice_navaidSystem = pointChoice_navaidSystem;
    }
}

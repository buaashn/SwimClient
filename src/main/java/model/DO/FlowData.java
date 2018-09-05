package model.DO;

public class FlowData {
    private String ID;
    private String flowName;
    private String flowID;
    private String downstreamFlowElementChoice;
    private String downstreamFlowElement;
    private String upstreamFlowElementChoice;
    private String upstreamFlowElement;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getFlowID() {
        return flowID;
    }

    public void setFlowID(String flowID) {
        this.flowID = flowID;
    }

    public String getDownstreamFlowElementChoice() {
        return downstreamFlowElementChoice;
    }

    public void setDownstreamFlowElementChoice(String downstreamFlowElementChoice) {
        this.downstreamFlowElementChoice = downstreamFlowElementChoice;
    }

    public String getDownstreamFlowElement() {
        return downstreamFlowElement;
    }

    public void setDownstreamFlowElement(String downstreamFlowElement) {
        this.downstreamFlowElement = downstreamFlowElement;
    }

    public String getUpstreamFlowElementChoice() {
        return upstreamFlowElementChoice;
    }

    public void setUpstreamFlowElementChoice(String upstreamFlowElementChoice) {
        this.upstreamFlowElementChoice = upstreamFlowElementChoice;
    }

    public String getUpstreamFlowElement() {
        return upstreamFlowElement;
    }

    public void setUpstreamFlowElement(String upstreamFlowElement) {
        this.upstreamFlowElement = upstreamFlowElement;
    }
}

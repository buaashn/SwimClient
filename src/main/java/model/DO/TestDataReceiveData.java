package model.DO;

public class TestDataReceiveData {
    private int ID;
    private String timeOfReceive;
    private String timeOfSend;
    private int delay;
    private int dataNumber;
    private double packetLoss;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTimeOfReceive() {
        return timeOfReceive;
    }

    public void setTimeOfReceive(String timeOfReceive) {
        this.timeOfReceive = timeOfReceive;
    }

    public String getTimeOfSend() {
        return timeOfSend;
    }

    public void setTimeOfSend(String timeOfSend) {
        this.timeOfSend = timeOfSend;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getDataNumber() {
        return dataNumber;
    }

    public void setDataNumber(int dataNumber) {
        this.dataNumber = dataNumber;
    }

    public double getPacketLoss() {
        return packetLoss;
    }

    public void setPacketLoss(double packetLoss) {
        this.packetLoss = packetLoss;
    }
}

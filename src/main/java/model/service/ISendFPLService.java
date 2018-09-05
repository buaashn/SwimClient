package model.service;

public interface ISendFPLService {
    /**
     * 发送FPL
     * @param stringFPL 要发送的FPL内容
     * @output 如果发送成功输出ture，否则输出false
     */
    public boolean sendFPL(String stringFPL);
}

package model.service;

public interface ICreateFPLService {
    /**
     * 通过数据库生成FPL报文
     * @param id 数据库数据编号
     * @return 若成功生成报文则返回报文内容，如果没有生成报文则返回null
     */
    public String getFPLByDatabase(Integer id);
}

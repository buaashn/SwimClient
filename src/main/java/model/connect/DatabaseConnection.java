package model.connect;


import model.base.OsName;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 创建数据库连接
 * @author sdush
 * @
 */
@SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
public class DatabaseConnection {

    /**
     * 数据库地址常量
     */
    private  static  final String SQLITE_URL_MACOS = "jdbc:sqlite:/Users/shn/IdeaProjects/SWIMSystem/SWIMSystem/client/data/数据库.db";
    private static final String SQLITE_URL = "jdbc:sqlite:D:\\Dropbox\\SWIMSystem\\client\\data\\数据库.db";
    private Connection dbConnection = null;

    /**
     * 构造方法
     * 添加driver，获取数据库连接
     */
    public DatabaseConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            if(OsName.getSystem() == OsName.WINDOWS){
                this.dbConnection = DriverManager.getConnection(SQLITE_URL);
            }
            else if(OsName.getSystem() == OsName.MACOS) {
                this.dbConnection = DriverManager.getConnection(SQLITE_URL_MACOS);
            }
            else{
                System.out.println("Cann't find database!");
                System.exit(1);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @return 返回数据库连接
     */
    public Connection getDbConnection() {
        return dbConnection;
    }

    /**
     * 关闭数据库连接
     */
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public void databaseClose(){
        if (this.dbConnection != null){
            try {
                this.dbConnection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

}

package model.connect;


import model.base.OsName;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * �������ݿ�����
 * @author sdush
 * @
 */
@SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
public class DatabaseConnection {

    /**
     * ���ݿ��ַ����
     */
    private  static  final String SQLITE_URL_MACOS = "jdbc:sqlite:/Users/shn/IdeaProjects/SWIMSystem/SWIMSystem/client/data/���ݿ�.db";
    private static final String SQLITE_URL = "jdbc:sqlite:D:\\Dropbox\\SWIMSystem\\client\\data\\���ݿ�.db";
    private Connection dbConnection = null;

    /**
     * ���췽��
     * ���driver����ȡ���ݿ�����
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
     * @return �������ݿ�����
     */
    public Connection getDbConnection() {
        return dbConnection;
    }

    /**
     * �ر����ݿ�����
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

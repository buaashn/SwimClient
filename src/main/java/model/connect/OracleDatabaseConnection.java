package model.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDatabaseConnection {
    private static String urlOracle = "jdbc:oracle:thin:@localhost:1522:XE";
    private static String userOracle = "SYS as sysdba";
    private static String passwordOracle = "XXXX";

    private Connection connection = null;

    private boolean debugFlag = true;


    public OracleDatabaseConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(urlOracle, userOracle, passwordOracle);
            if (debugFlag) {
                System.out.println("Oracle : Connected!" );
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getOracleDatabaseConnection(){
        return connection;
    }

    public void closeOracleDatabase(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

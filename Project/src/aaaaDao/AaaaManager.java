package aaaaDao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AaaaManager {
    private static String url = "jdbc:mysql://localhost/aaaa?useUnicode=true&characterEncoding=utf8";
    private static String user = "root";
    private static String pass = "password";

    /**
     * DBへ接続するコネクションを返す
     */
    public static Connection getConnection() {
        Connection con = null;
        try {
        	//DBに接続する際に必要なクラス
        	//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
            Class.forName("com.mysql.cj.jdbc.Driver");
            //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
            con = DriverManager.getConnection(url,user,pass);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}

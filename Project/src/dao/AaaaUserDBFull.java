package dao;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class AaaaUserDBFull {

	    public static void main(String[] args) {
	        Connection conn = null;
	        try {

	            // データベースへ接続
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aaaa?useUnicode=true&characterEncoding=utf8", "root", "password");

	            // SELECT文を準備
	            String sql = "SELECT id,login_id,name,birth_date,password,create_date,update_date FROM user";

	            // SELECTを実行し、結果表（ResultSet）を取得
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);



            // 結果表に格納されたレコードの内容を表示
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date birth = rs.getDate("birth_date");
                String pass = rs.getString("password");
                Date create = rs.getDate("create_date");
                Date up = rs.getDate("update_date");

                // 取得したデータを出力
                System.out.println("ID:" + id);
                System.out.println("名前:" + name);
                System.out.println("生年月日:" + birth);
                System.out.println("パスワード:" + pass);
                System.out.println("作成日時" + create);
                System.out.println("更新日時" + up);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


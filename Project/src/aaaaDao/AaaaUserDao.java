package aaaaDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.AaaaUser;

public class AaaaUserDao {

	public List<AaaaUser> findAll() {
		Connection conn = null;
		List<AaaaUser> aaaalist = new ArrayList<AaaaUser>();

		try {
			// データベースへ接続
			conn = AaaaManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user";

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// 結果表に格納されたレコードの内容を

			while (rs.next()) {
				int id = rs.getInt("id");
				String li = rs.getString("login_id");
				String name = rs.getString("name");
				String birth = rs.getString("birth_date");
				String pass = rs.getString("password");
				String create = rs.getString("create_date");
				String update = rs.getString("update_date");
				AaaaUser aaaa = new AaaaUser(id, li, name, birth, pass, create, update);
				aaaalist.add(aaaa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return aaaalist;
	}


	public List<AaaaUser> TopRemove() {
		Connection conn = null;
		List<AaaaUser> aaaalist = new ArrayList<AaaaUser>();

		try {
			// データベースへ接続
			conn = AaaaManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE id>=2";

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// 結果表に格納されたレコードの内容を

			while (rs.next()) {
				int id = rs.getInt("id");
				String li = rs.getString("login_id");
				String name = rs.getString("name");
				String birth = rs.getString("birth_date");
				String pass = rs.getString("password");
				String create = rs.getString("create_date");
				String update = rs.getString("update_date");
				AaaaUser aaaa = new AaaaUser(id, li, name, birth, pass, create, update);
				aaaalist.add(aaaa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return aaaalist;
	}













	public AaaaUser findById(String loginId, String password) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = AaaaManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();
			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}
			String li = rs.getString("login_id");
			String name = rs.getString("name");

			return new AaaaUser(li, name);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				} // 以下findAllと同じ処理なので略
			}

		}
	}

	//新規ユーザ用メソッド
	public AaaaUser newUser(String id, String name, String birth, String pass) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		String create="";
		try {
			// データベースへ接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/aaaa?useUnicode=true&characterEncoding=utf8",
					"root", "password");

			// INSERT文を準備
			String sql = "INSERT INTO user(login_id,name,birth_date,password,create_date,update_date) VALUES(?,?,?,?,now(),now())";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			pStmt.setString(2, name);
			pStmt.setString(3, birth);
			pStmt.setString(4, pass);
			pStmt.executeUpdate();
			pStmt.close();

			return new AaaaUser(id, name, birth, pass);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
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
		return null;
	}

	public AaaaUser syousai(String userId) {
		Connection conn = null;
		try {
			// データベースへ接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = AaaaManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE id = ?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);
			ResultSet rs = pStmt.executeQuery();

			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}
			int id = rs.getInt("id");
			String loginId = rs.getString("login_id");
			String name = rs.getString("name");
			String birthDate = rs.getString("birth_date");
			String pass = rs.getString("password");
			String createDate = rs.getString("create_date");
			String updateDate = rs.getString("update_date");

			return new AaaaUser(id, loginId, name, birthDate, pass, createDate,updateDate);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	public AaaaUser UpDate(String id, String login, String name, String birth) {
		Connection conn = null;
		try {
			// データベースへ接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = AaaaManager.getConnection();

			// UPDATE文を準備
			String sql = "UPDATE user SET login_id = ?, name = ?,birth_date = ?,update_date =now() WHERE id = ?";



			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login);
			pStmt.setString(2, name);
			pStmt.setString(3, birth);
			pStmt.setString(4, id);
			pStmt.executeUpdate();
			pStmt.close();

			return new AaaaUser(login, name, birth);


		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}
	public void Delete(String id) {
		Connection conn = null;
		try {
			// データベースへ接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = AaaaManager.getConnection();

			// DELETE文を準備
			String sql = "DELETE FROM user WHERE id = ?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			pStmt.executeUpdate();
			pStmt.close();

			//return AaaaUser(login,name,burth,create)

		} catch (SQLException | ClassNotFoundException e) {
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

	//ユーザ検索用
	public AaaaUser Search(String loginId, String name, String birth) {
		Connection conn = null;
		try {
			// データベースへ接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = AaaaManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE login_id = ? and name = ? and birth_date = ?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, name);
			pStmt.setString(3, birth);
			ResultSet rs = pStmt.executeQuery();
			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}
			int id = rs.getInt("id");
			String li = rs.getString("login_id");
			String userName = rs.getString("name");
			String date = rs.getString("birth_date");
			String pass = rs.getString("password");
			String create = rs.getString("create_date");
			String update = rs.getString("update_date");

			return new AaaaUser(id,li, userName,date,pass,create,update);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				} // 以下findAllと同じ処理なので略
			}

		}
	}
}
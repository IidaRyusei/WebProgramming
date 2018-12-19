package model;

public class AaaaUser {


	private int id;
	private String login_id;
	private String name;
	private String birth_date;
	private String password;
	private String create_date;
	private String update_date;

//ユーザ情報全て
public AaaaUser(int id, String login_id, String name, String birth_date, String password, String create,
			String update) {

		this.id = id;
		this.login_id = login_id;
		this.name = name;
		this.birth_date = birth_date;
		this.password = password;
		this.create_date = create;
		this.update_date = update;
	}



//ユーザの紐付け用
	public AaaaUser(String login_id, String name) {

		this.login_id = login_id;
		this.name = name;

	}
//新規ユーザ用コンストラクタ
	public AaaaUser(String login_id,String name,String birth_date,String password) {
		this.login_id = login_id;
		this.name = name;
		this.birth_date = birth_date;
		this.password = password;
	}



//ユーザ詳細用コンストラクタ
	public AaaaUser(int id2, String loginId, String name2, String birthDate, String pass, String createDate) {
		this.id = id2;
		this.login_id = loginId;
		this.name = name2;
		this.birth_date = birthDate;
		this.password = pass;
		this.create_date = createDate;

	}

	//更新用コンストラクタ
	public AaaaUser(String loginId, String name, String birth) {
		this.login_id = loginId;
		this.name = name;
		this.birth_date = birth;
	}
//デリート用コンストラクタ
	public AaaaUser(int id) {

	this.id = id;

	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getPossword() {
		return password;
	}

	public void setPossword(String password) {
		this.password = password;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}





}


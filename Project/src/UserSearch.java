

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aaaaDao.AaaaUserDao;
import model.AaaaUser;

/**
 * Servlet implementation class UserSearch
 */
@WebServlet("/UserSearch")
public class UserSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータの文字コードを指定
        request.setCharacterEncoding("UTF-8");

     // HttpSessionインスタンスの取得
	    HttpSession session = request.getSession();

	    // セッションスコープからインスタンスを取得
	    AaaaUser userInfo = (AaaaUser)session.getAttribute("userInfo");

	    if(userInfo == null) {

		 //フォワード
        RequestDispatcher dispatcher =
        request.getRequestDispatcher("/WEB-INF/jsp/loginn.jsp");
        dispatcher.forward(request, response);
	}
		// リクエストパラメータの入力項目を取得
		String name = request.getParameter("loginId");
		String pass = request.getParameter("pass");

		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		AaaaUserDao userDao = new AaaaUserDao();
		AaaaUser user = userDao.findById(name , pass);

		/** テーブルに該当のデータが見つからなかった場合 **/
		if (user == null) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "切り替えにに失敗しました。");

			// 詳細２jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/syousai2.jsp");
			dispatcher.forward(request, response);
			return;

     		}
		/** テーブルに該当のデータが見つかった場合 **/

		/*// セッションにユーザの情報をセット
		HttpSession session = request.getSession();*/
		session.setAttribute("userInfo", user);

		// 詳細２jspにフォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("/UserList");
					dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");

		// HttpSessionインスタンスの取得
	    HttpSession session = request.getSession();

	    // セッションスコープからインスタンスを取得
	    AaaaUser userInfo = (AaaaUser)session.getAttribute("userInfo");

	    if(userInfo == null) {

		 //フォワード
        RequestDispatcher dispatcher =
        request.getRequestDispatcher("/WEB-INF/jsp/loginn.jsp");
        dispatcher.forward(request, response);
	}

		// リクエストパラメータの取得
		String id = request.getParameter("loginId");
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String date2 = request.getParameter("date2");


		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
				AaaaUserDao userDao = new AaaaUserDao();
				List<AaaaUser> user = userDao.findUser(id , name, date,date2);



				// リクエストスコープにユーザ一覧情報をセット
		 		request.setAttribute("userList", user);

		// 詳細jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
			dispatcher.forward(request, response);
}
}
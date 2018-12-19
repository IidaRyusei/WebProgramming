

import java.io.IOException;

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
 * Servlet implementation class NewUser
 */
@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
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

		  //フォワード
        RequestDispatcher dispatcher =
        request.getRequestDispatcher("/WEB-INF/jsp/newUser.jsp");
        dispatcher.forward(request, response);



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				String id = request.getParameter("loginId");
				String pass = request.getParameter("pass");
				String passs = request.getParameter("passs");
				String name = request.getParameter("name");
				String birth = request.getParameter("birth");



				if(!pass.equals(passs)) {

					// リクエストスコープにエラーメッセージをセット
					request.setAttribute("errMsg", "入力された内容は正しくありません");

					session.setAttribute("loginId",id );
					session.setAttribute("name", name);
					session.setAttribute("birth", birth);


					// 新規登録jspにフォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newUser.jsp");
					dispatcher.forward(request, response);
					return;
				}

				AaaaUserDao user =new AaaaUserDao();
				AaaaUser newuser =user.newUser(id,name,birth,pass);

				// ユーザ一覧のサーブレットにリダイレクト
				response.sendRedirect("UserList");
	}

}

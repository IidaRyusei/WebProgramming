

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
 * Servlet implementation class Syousai
 */
@WebServlet("/Syousai")
public class Syousai extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Syousai() {
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
		String id = request.getParameter("id");

		AaaaUserDao user =new AaaaUserDao();
		AaaaUser aaaaUser = user.syousai(id);

		/*/ セッションにユーザの情報をセット
				HttpSession session = request.getSession();*/
				session.setAttribute("syousai", aaaaUser);
		//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/syousai.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

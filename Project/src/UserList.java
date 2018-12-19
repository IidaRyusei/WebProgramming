

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
 * Servlet implementation class UserList
 */
@WebServlet("/UserList")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");

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

	    String user=userInfo.getName();
    if( user.equals("管理者")) {


    	// 管理者
 		AaaaUserDao userDao = new AaaaUserDao();
 		List<AaaaUser> userList = userDao.findAll();

 		// リクエストスコープにユーザ一覧情報をセット
 		request.setAttribute("userList", userList);


 		// ユーザ一覧のjspにフォワード
 		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
 		dispatcher.forward(request, response);

	}

  //管理者以外にログインした場合テーブルに管理者のデータを表示させない為の処理


 // ユーザ一覧情報を取得
 		AaaaUserDao userDao = new AaaaUserDao();
 		List<AaaaUser> userList = userDao.TopRemove();

 		// リクエストスコープにユーザ一覧情報をセット
 		request.setAttribute("userList", userList);


 		// ユーザ一覧のjspにフォワード
 		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
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

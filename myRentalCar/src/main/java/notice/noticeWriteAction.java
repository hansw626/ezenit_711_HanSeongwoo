package notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDao;

/**
 * Servlet implementation class boardWriteAction
 */
//@WebServlet("/noticeWriteAction")
public class noticeWriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noticeWriteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		NoticeDao dao = NoticeDao.getInstance();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		if(title != null && content != null) {
			String id = (String)session.getAttribute("log");
			
			NoticeDto notice = new NoticeDto(id, title, content);
			dao.createNotice(notice);
			response.sendRedirect("notice");
		}else {
			response.sendRedirect("noticeWrite");
		}
		
//		request.getRequestDispatcher("index").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
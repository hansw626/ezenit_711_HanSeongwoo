package rental;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import car.CarDao;
import car.CarDto;

/**
 * Servlet implementation class rentalAction
 */
@WebServlet("/rentalAction")
public class rentalAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rentalAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RentalDao dao = RentalDao.getInstance();
		
		String id = (String)session.getAttribute("log");
		String code = request.getParameter("code");
		String place = request.getParameter("place");
		String reason = request.getParameter("reason");
		int price = Integer.parseInt(request.getParameter("price"));
		int cost = Integer.parseInt(request.getParameter("cost"));
		
		String[] sTemp = request.getParameter("start_date").split("-");
		int sYear = Integer.parseInt(sTemp[0])-1900;
		int sMonth = Integer.parseInt(sTemp[1])-1;
		int sDay = Integer.parseInt(sTemp[2]);
		Timestamp sDate = new Timestamp(sYear, sMonth, sDay, 0, 0, 0, 0);
		
		String[] eTemp = request.getParameter("end_date").split("-");
		int eYear = Integer.parseInt(sTemp[0])-1900;
		int eMonth = Integer.parseInt(sTemp[1])-1;
		int eDay = Integer.parseInt(sTemp[2]);	
		Timestamp eDate = new Timestamp(eYear, eMonth, eDay, 0, 0, 0, 0);
		
		RentalVo rental = new RentalVo(id,code,sDate,eDate,place,reason,price,cost);
		dao.createRentalInfo(rental);
		
		response.sendRedirect("viewCar.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

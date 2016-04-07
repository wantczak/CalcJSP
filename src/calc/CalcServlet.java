package calc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/calc.jsp";
	    
	    HttpSession session = request.getSession();		
		Calc kalkulator = (Calc)session.getAttribute("kalkulator");
		if (kalkulator==null){
			kalkulator = new Calc();
			System.out.println(kalkulator);
	    	session.setAttribute("kalkulator",kalkulator);
	    	kalkulator.setResultText("0");
		}
			    
	    if (request.getParameterMap().containsKey("btnParam")) {
	        String s = request.getParameter("btnParam");
	        kalkulator.setBtnParam(s);
	    }	
	    
	    else if (request.getParameterMap().containsKey("btnResult")) {
	        String s = request.getParameter("btnResult");
	        kalkulator.setBtnResult(s);
	    }	
		
	    if(request.getParameterMap().containsKey("btn")) {
	        String s = request.getParameter("btn");
	        kalkulator.setBtn(s);
	    }


	    RequestDispatcher requestDispatcher =   getServletContext().getRequestDispatcher(url);
	    requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

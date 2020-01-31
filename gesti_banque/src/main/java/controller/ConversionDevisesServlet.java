package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpRetryException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConversionDevisesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/views/common_views/conversionDevises1.jsp");
		req.include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String deviseSRC = request.getParameter("deviseSRC");
		String deviseDest = request.getParameter("deviseDest");
		String stringSum = request.getParameter("sum");

		if (deviseSRC.isEmpty() || deviseDest.isEmpty() || stringSum.isEmpty()) {
			RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/views/common_views/conversionDevises1.jsp");
			req.include(request, response);
		} else {
			float sum = Float.parseFloat(stringSum);
			ConversionDevises cd = new ConversionDevises();
			float res = cd.conversion(deviseSRC, deviseDest, sum);
			System.out.println("Valeur =============>" + res);
			
			  HttpSession session = request.getSession(true);
			  session.setAttribute("vc",res); System.out.println("/WEB-INF/views/common_views/Resultat conversion : " +
			  res); 
			//  RequestDispatcher req = request.getRequestDispatcher("ConversionDevise2.jsp");
				RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/views/common_views/conversionDevises2.jsp");
				req.forward(request, response);

			  //req.forward(request, response);
			 
			/*
			 * PrintWriter out = response.getWriter(); out.print("<!DOCTYPE html>\r\n" +
			 * "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n" +
			 * "<title>Insert title here</title>\r\n" + "</head>\r\n" + "<body>");
			 * out.print("Valeur convertie" + res); out.print("</body>\r\n" + "</html>");
			 * out.close();
			 */
		}
	}

}

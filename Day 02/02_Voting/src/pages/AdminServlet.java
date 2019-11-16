package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VotingDaoImpl;
import pojos.Candidate;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
		pw.append("Served at: ").append(request.getContextPath());

		// Get dao from session
		
		HttpSession hs = request.getSession();
		
		//// Get Data Access Object instance from HttpSession
		VotingDaoImpl dao =  (VotingDaoImpl) hs.getAttribute("dao");
		
		// 1. Show top ? candidates having max votes
		HashMap<Integer, Candidate> topCandidates;
		try {
			topCandidates =  dao.topCandidates(1);
			pw.print("<h5> Top Candidate is : ");
			pw.print(topCandidates.toString());
			pw.print("</h5>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("Top candidate not found");
		}
		
		// 2. Display Votes Analysis
		
		try {
			HashMap<String, Integer> partyVotes =  dao.votesByParty();
			pw.print("<h5> Votes by Party : ");
			pw.print(partyVotes);
			pw.print("</h5>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("Party Votes not found");
		}
		pw.print("<form>");
		pw.print("<input type='submit' value='Logout' formaction='logout' formmethod = 'post'>");
		pw.print("<input type='submit' value='Refresh' formaction='admin' formmethod = 'get'>");
		pw.print("</form>");
		
	} catch (Exception e) {
		throw new ServletException("Error in do-get : " + getClass().getName(), e);
	}}

}

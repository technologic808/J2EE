package pages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VotingDaoImpl;
import pojos.Voter;

/**
 * Servlet implementation class RegisterVoteServlet
 */
@WebServlet("/register_vote")
public class RegisterVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get selected candidate id  
		Integer candidateId = Integer.parseInt(request.getParameter("candidate"));
		
		// Get current HttpSession
		HttpSession hs = request.getSession();
		
		// Get voter details from HttpSession
		Voter v = (Voter) hs.getAttribute("voter_details");
		
		// Get Data Access Object instance from HttpSession
		VotingDaoImpl dao = (VotingDaoImpl) hs.getAttribute("dao");
		
		// Update vote in System
		try {
			System.out.println(dao.incVotesUpdateStatus(candidateId, v.getId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("Failed to register vote!");
		}
		
		response.sendRedirect("thanks_for_voting.html");
		
	}

}

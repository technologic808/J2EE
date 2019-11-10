package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VotingDaoImpl;
import pojos.Candidate;
import pojos.Voter;


/**
 * Servlet implementation class VotingServlet
 */
@WebServlet("/vote")
public class VotingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		try (PrintWriter pw = resp.getWriter()) {

			// Get current HttpSession from Web Container
			HttpSession hs = req.getSession();

			// Get Data Access Object instance from HttpSession
			VotingDaoImpl dao = (VotingDaoImpl) hs.getAttribute("dao");

			// Get voter details from HttpSession
			Voter v = (Voter) hs.getAttribute("voter_details");

			// Get list of all candidates using Data Access Object
			List<Candidate> names = dao.getCandidateList();

			// Generate the voting form dynamically
			pw.print("<h4>Hello, " + v.getV_email() + "</h4>");
			pw.print("<h3 align=center>Please choose a Candidate</h3>");
			pw.print("<form action='register_vote' method='post'>");
			for (Candidate c : names)
				pw.print(" <input type='radio' name='candidate' value='" + c.getId() + "'> " + c.getC_name() + " ( "
						+ c.getParty() + " )" + "<br>");
			pw.print("<input type='submit' value='Cast Vote'>");
			pw.print("<input type='submit' value='Logout' formaction='logout' method = 'post'>");

		} catch (Exception e) {
			throw new ServletException("Error in do-post : " + getClass().getName(), e);
		}

	}

}

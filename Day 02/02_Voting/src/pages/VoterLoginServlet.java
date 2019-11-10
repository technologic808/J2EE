package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VotingDaoImpl;
import pojos.Voter;

/**
 * Servlet implementation class VoterLoginServlet
 */
@WebServlet("/validate")
public class VoterLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private VotingDaoImpl dao;

	@Override
	public void destroy() {
		try {
			dao.cleanUp();
		} catch (Exception e) {
			throw new RuntimeException("Error in destroy ", e);
		}
	}

	@Override
	public void init() throws ServletException {
		try {
			dao = new VotingDaoImpl();
		} catch (Exception e) {
			throw new ServletException("Error in init :" + getClass().getName(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set Content Type
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {
			// Invoke DAO's method for authentication
			Voter v = dao.authenticateVoter(request.getParameter("email"), request.getParameter("password"));

			// Check for invalid login
			if (v == null)
				pw.print("<h4> Invalid Login ,<a href='login.html'>Login Again</a></h4>");
			else {

				// Get HttpSession object from Web Container
				HttpSession hs = request.getSession();

				// Debugging Code
				System.out.println("New HttpSession ? " + hs.isNew());
				System.out.println("Session ID " + hs.getId());

				// Save validated voter details to session scope
				hs.setAttribute("voter_details", v);

				// Add Data Access Objects to session scope
				hs.setAttribute("dao", dao);

				System.out.println("Voter status is " + v.getV_status());
				// Check if the voter has already voted
				if (v.getV_status())
					response.sendRedirect("thanks_for_voting.html");
				else // Redirect the voter to the voting page, in the NEXT request
					response.sendRedirect("vote");
			}
		} catch (Exception e) {
			throw new ServletException("Error in do-post : " + getClass().getName(), e);
		}

	}

}

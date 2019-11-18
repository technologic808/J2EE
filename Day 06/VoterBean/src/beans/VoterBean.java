package beans;

import dao.VotingDao;
import pojos.Voter;

public class VoterBean {

	// Declare members to store the conversational state of the Voter
	private String email, password;
	private VotingDao dao;

	// Declare members to store results
	private Voter details;
	private String message, status;

	public VoterBean() throws Exception {
		System.out.println("In Voter Bean constructor");
		dao = new VotingDao();
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public Voter getDetails() {
		return details;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Business Logic methods

	// 1. Authenticates voter
	public String validateVoter() {
		// Prints debugging message to console
		System.out.println("Validate voter " + email + " " + password);

		try {
			// Authenticates and stores voter details in data member
			details = dao.authenticateVoter(email, password);

			// Updates login status
			status = details.getRole() + ", " + details.getV_email() + ", Login Succcessful";

			// Checks if user is voter
			if (details.getRole().equals("voter")) {
				// Checks if user has already voted
				if (details.getV_status()) {
					message = "You have voted already.";
					// returns jsp page name to navigate to
					return "status";
				} else {
					message = "You are voting now.";
					// returns jsp page name to navigate to
					return "voting";
				}
			}
			// Checks if user is admin
			else if (details.getRole().equals("admin")) {
				// returns jsp page name to navigate to
				return "analysis";
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);

			// Updates message for failed login
			message = "Login Failed";
			// returns jsp page name to navigate to
			return "login";
		}
		// returns login page by default
		return "login";
	}

	// 2. Updates voter status on voting
	public String updateStatus() throws Exception {
		System.out.println("in update voter status method");
		message = dao.updateVoterStatus(details);
		return "";
	}
	
	// 3. Register Voter 
	public String registerVoter() {
		// Prints debugging message to console
		System.out.println("Register voter " + email + " " + password);

		try {
			// Authenticates and stores voter details in data member
			details = dao.registerVoter(email, password);

			// Updates login status
			status = details.getRole() + ", " + details.getV_email() + ", Registration Succcessful";

			// Checks if user is voter
			if (details.getRole().equals("voter")) {
					message = "You have been registered";
					// returns jsp page name to navigate to
					return "login";
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);

			// Updates message for failed login
			message = "Registration Failed";
			// returns jsp page name to navigate to
			return "login";
		}
		// returns login page by default
		return "login";		
	}

}

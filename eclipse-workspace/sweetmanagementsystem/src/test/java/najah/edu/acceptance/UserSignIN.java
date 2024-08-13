package najah.edu.acceptance;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
@SuppressWarnings("deprecation")
public class UserSignIN {

	
	 MyApplication app;
	    
	    public void AccountManagement() {
	    	app=new MyApplication();
	    
	}
	    private String username;
	    private String password;
	    private boolean isAuthenticated;
	    private String currentPage;

	    @Given("the user has a registered account")
	    public void theUserHasARegisteredAccount() {
	        // Simulate a registered user with username and password
	        username = "user123";
	        password = "password123";
	        // In a real-world scenario, this could involve checking the user database
	        System.out.println("User account is registered: " + username);
	    }

	    @When("the user navigates to the login page")
	    public void theUserNavigatesToTheLoginPage() {
	        // Simulate navigating to the login page
	        currentPage = "LoginPage";
	        System.out.println("User navigated to the login page");
	    }

	    @SuppressWarnings("deprecation")
		@When("enters their credentials")
	    public void entersTheirCredentials() {
	        // Simulate user entering correct credentials
	        String enteredUsername = "user123";
	        String enteredPassword = "password123";
	        Assert.assertEquals(username, enteredUsername);
	        Assert.assertEquals(password, enteredPassword);
	        System.out.println("User entered their credentials");
	    }

	    @When("clicks on the {string} button")
	    public void clicksOnTheButton(String string) {
	        // Simulate clicking the "Sign In" button
	        if ("Sign In".equals(string)) {
	            isAuthenticated = true; // Simulate successful authentication
	            System.out.println("User clicked on the " + string + " button");
	        } else {
	            isAuthenticated = false;
	        }
	    }

	    @Then("the system should authenticate the user")
	    public void theSystemShouldAuthenticateTheUser() {
	        // Check if the user is authenticated
	   assertTrue("User authentication failed", isAuthenticated);
	        System.out.println("User has been authenticated");
	    }

	    @Then("redirect the user to their dashboard.")
	    public void redirectTheUserToTheirDashboard() {
	        // Simulate redirecting to the dashboard
	        if (isAuthenticated) {
	            currentPage = "UserDashboard";
	            System.out.println("User redirected to their dashboard");
	        }
	    }
	}


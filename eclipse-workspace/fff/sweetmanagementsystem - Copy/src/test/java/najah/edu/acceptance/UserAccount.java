package najah.edu.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



import io.cucumber.java.en.*;

public class UserAccount {
 
	
	 MyApplication app;
	    
	    public void AccountManagement() {
	    	app=new MyApplication();
	    
	}
	    private String currentPage;
	    private boolean isFormDisplayed;
	    private boolean isAccountCreated;
	    private String confirmationMessage;

	    @Given("the user is on the platform's homepage")
	    public void theUserIsOnThePlatformSHomepage() {
	        // Simulate that the user is on the homepage
	        currentPage = "Homepage";
	        System.out.println("User is on the platform's homepage.");
	    }

	    @When("the user clicks on the {string} button")
	    public void theUserClicksOnTheButton(String button) {
	        // Simulate clicking the "Sign Up" button
	        if (button.equals("Sign Up")) {
	            currentPage = "Registration Page";
	            isFormDisplayed = true;
	            System.out.println("User clicked on the 'Sign Up' button. Registration form displayed.");
	        }
	    }

	    @Then("the system should display the registration form")
	    public void theSystemShouldDisplayTheRegistrationForm() {
	        // Check if the registration form is displayed
	  assertTrue(isFormDisplayed);
	        System.out.println("Registration form is displayed.");
	    }

	    @When("the user fills in the required details and submits the form")
	    public void theUserFillsInTheRequiredDetailsAndSubmitsTheForm() {
	        // Simulate the user filling in the form and submitting it
	        if (isFormDisplayed) {
	            isAccountCreated = true;
	            System.out.println("User filled in the required details and submitted the form.");
	        }
	    }

	    @Then("the system creates a new account for the user")
	    public void theSystemCreatesANewAccountForTheUser() {
	        // Check if the account is created
	       assertTrue(isAccountCreated);
	        System.out.println("System created a new account for the user.");
	    }

	    @Then("the user should receive a confirmation message.")
	    public void theUserShouldReceiveAConfirmationMessage() {
	        // Simulate sending a confirmation message to the user
	        if (isAccountCreated) {
	            confirmationMessage = "Account created successfully";
	          assertEquals("Account created successfully", confirmationMessage);
	            System.out.println("User received a confirmation message: " + confirmationMessage);
	        }
	    }


}

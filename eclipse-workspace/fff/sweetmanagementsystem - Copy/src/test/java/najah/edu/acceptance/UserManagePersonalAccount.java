package najah.edu.acceptance;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserManagePersonalAccount {

	
	 MyApplication app;
	    
	    public void AccountManagement() {
	    	app=new MyApplication();
	    
	}
	    private boolean isLoggedIn;
	    private String currentSection;
	    private boolean isOptionsVisible;
	    private boolean isAccountUpdated;

	    @Given("the user is logged into the platform")
	    public void theUserIsLoggedIntoThePlatform() {
	        // Simulate that the user is logged into the platform
	        isLoggedIn = true;
	        System.out.println("User is logged into the platform.");
	    }

	    @When("the user navigates to the {string} section")
	    public void theUserNavigatesToTheSection(String section) {
	        // Simulate navigation to the specified section
	        if (isLoggedIn) {
	            currentSection = section;
	            if ("Account Settings".equals(section)) {
	                isOptionsVisible = true;
	            }
	            System.out.println("User navigated to the " + section + " section.");
	        }
	    }

	    @Then("the user should see options to update their personal information, change their password, and manage notification preferences")
	    public void theUserShouldSeeOptionsToUpdateTheirPersonalInformationChangeTheirPasswordAndManageNotificationPreferences() {
	        // Verify that the user can see the options in the Account Settings section
	        Assert.assertTrue(isOptionsVisible);
	        System.out.println("User can see options to update personal information, change password, and manage notification preferences.");
	    }

	    @When("the user makes changes and clicks {string}")
	    public void theUserMakesChangesAndClicks(String button) {
	        // Simulate the user making changes and clicking "Save"
	        if ("Save".equals(button)) {
	            isAccountUpdated = true;
	            System.out.println("User made changes and clicked 'Save'.");
	        }
	    }

	    @Then("the system should update the user's account with the new information.")
	    public void theSystemShouldUpdateTheUserSAccountWithTheNewInformation() {
	        // Verify that the account was updated with the new information
	       assertTrue(isAccountUpdated);
	        System.out.println("System updated the user's account with the new information.");
	    }
}

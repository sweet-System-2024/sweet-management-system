package najah.edu.acceptance;

import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class CreatNewStoreOwner {

	 MyApplication app;
	    
	    public void AccountManagement() {
	    	app=new MyApplication();
	    
	}
	    private String currentUser;
	    private String currentPage;
	    private Map<String, String> newUserDetails;
	    private boolean isAccountCreated;

	    private Map<String, Map<String, String>> userManagementTable = new HashMap<>();

	    @Given("I am an admin")
	    public void iAmAnAdmin() {
	        // Simulate that the current user is an admin
	        currentUser = "admin";
	        System.out.println("Current user is an admin.");
	    }

	    @When("I navigate to the {string} page")
	    public void iNavigateToThePage(String pageName) {
	        // Simulate navigating to a specific page
	        currentPage = pageName;
	        System.out.println("Navigated to the " + pageName + " page.");
	    }

	    @When("I fill in the {string} field with {string}")
	    public void iFillInTheFieldWith(String fieldName, String value) {
	        // Simulate filling in a field on the form
	        if (newUserDetails == null) {
	            newUserDetails = new HashMap<>();
	        }
	        newUserDetails.put(fieldName, value);
	        System.out.println("Filled in the " + fieldName + " field with " + value + ".");
	    }

	    @When("I select {string} from the {string} dropdown")
	    public void iSelectFromTheDropdown(String value, String dropdownName) {
	        // Simulate selecting an option from a dropdown
	        if (newUserDetails == null) {
	            newUserDetails = new HashMap<>();
	        }
	        newUserDetails.put(dropdownName, value);
	        System.out.println("Selected " + value + " from the " + dropdownName + " dropdown.");
	    }

	    @When("I click {string}")
	    public void iClick(String buttonName) {
	        // Simulate clicking a button to submit the form
	        if ("Submit".equals(buttonName)) {
	            // Logic to "create" the account and add it to the management table
	            String username = newUserDetails.get("Username");
	            if (username != null && !userManagementTable.containsKey(username)) {
	                userManagementTable.put(username, newUserDetails);
	                isAccountCreated = true;
	                System.out.println("Clicked " + buttonName + ". Account created.");
	            } else {
	                isAccountCreated = false;
	                System.out.println("Clicked " + buttonName + ". Account creation failed.");
	            }
	        }
	    }

	    @Then("I should see a confirmation message {string}")
	    public void iShouldSeeAConfirmationMessage(String expectedMessage) {
	        // Simulate seeing a confirmation message
	        String actualMessage = isAccountCreated ? "Account created successfully" : "Account creation failed";
	        Assert.assertEquals(expectedMessage, actualMessage);
	        System.out.println("Expected message: " + expectedMessage + ". Actual message: " + actualMessage);
	    }

	    @Then("the new store owner account should be listed in the user management table")
	    public void theNewStoreOwnerAccountShouldBeListedInTheUserManagementTable() {
	        // Check if the new account is listed in the management table
	        String username = newUserDetails.get("Username");
	        Assert.assertTrue(userManagementTable.containsKey(username));
	        System.out.println("The new store owner account for " + username + " is listed in the user management table.");
	    }
	}



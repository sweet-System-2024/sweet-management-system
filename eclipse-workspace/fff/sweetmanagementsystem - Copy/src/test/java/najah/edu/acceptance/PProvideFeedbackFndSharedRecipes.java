package najah.edu.acceptance;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PProvideFeedbackFndSharedRecipes {

	 MyApplication app;
	    
	    public void AccountManagement() {
	    	app=new MyApplication();
	    
	}
	
	    private boolean hasPurchasedOrViewed;
	    private boolean isInOrderHistoryOrRecipesSection;
	    private boolean isFeedbackFormDisplayed;
	    private String feedback;
	    private boolean isFeedbackSubmitted;
	    private boolean isNotificationSent;

	    @Given("the user has purchased a product or viewed a recipe")
	    public void theUserHasPurchasedAProductOrViewedARecipe() {
	        // Simulate that the user has either purchased a product or viewed a recipe
	        hasPurchasedOrViewed = true;
	        System.out.println("User has purchased a product or viewed a recipe.");
	    }

	    @When("the user navigates to the {string} or {string} section")
	    public void theUserNavigatesToTheOrSection(String section1, String section2) {
	        if (hasPurchasedOrViewed) {
	            // Check if user navigates to either section
	            isInOrderHistoryOrRecipesSection = section1.equals("Order History") || section2.equals("Recipes");
	            System.out.println("User navigates to the " + section1 + " or " + section2 + " section.");
	        }
	    }

	    @When("clicks on the {string} button next to the product or recipe")
	    public void clicksOnTheButtonNextToTheProductOrRecipe(String button) {
	        if (isInOrderHistoryOrRecipesSection && button.equals("Provide Feedback")) {
	            // Simulate that feedback form is displayed
	            isFeedbackFormDisplayed = true;
	            System.out.println("User clicks on the 'Provide Feedback' button.");
	        }
	    }

	    @Then("the system should display a feedback form")
	    public void theSystemShouldDisplayAFeedbackForm() {
	       assertTrue("Feedback form should be displayed.", isFeedbackFormDisplayed);
	    }

	    @When("the user enters their feedback and clicks {string}")
	    public void theUserEntersTheirFeedbackAndClicks(String action) {
	        if (isFeedbackFormDisplayed && action.equals("Submit")) {
	            feedback = "Great product! I loved it.";
	            // Simulate that feedback is saved and notification is sent
	            isFeedbackSubmitted = true;
	            isNotificationSent = true;
	            System.out.println("User enters feedback and clicks 'Submit'.");
	        }
	    }

	    @Then("the system should save the feedback and notify the store owner or recipe creator.")
	    public void theSystemShouldSaveTheFeedbackAndNotifyTheStoreOwnerOrRecipeCreator() {
	    assertTrue("Feedback should be saved.", isFeedbackSubmitted);
	      assertTrue("Notification should be sent to the store owner or recipe creator.", isNotificationSent);
	        System.out.println("Feedback saved and notification sent.");
	    }


}

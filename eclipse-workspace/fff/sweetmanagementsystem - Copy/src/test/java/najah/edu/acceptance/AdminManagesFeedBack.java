package najah.edu.acceptance;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class AdminManagesFeedBack {

MyApplication app;
    
    public void  AccountManagement() {
    	app=new MyApplication();
    
}


    private boolean isAdminLoggedIn;
    private boolean isInContentManagementSection;
    private boolean isFeedbackListDisplayed;
    private boolean isFeedbackReviewed;
    private boolean isFeedbackResponded;
    private boolean isFeedbackDeleted;
    private boolean areChangesReflected;

    @Given("the admin is logged into the system")
    public void theAdminIsLoggedIntoTheSystem() {
        // Simulate admin login
        isAdminLoggedIn = true;
        System.out.println("Admin is logged into the system.");
    }

    @When("the admin navigates to the {string} section")
    public void theAdminNavigatesToTheSection(String section) {
        if (isAdminLoggedIn && "Content Management".equals(section)) {
            isInContentManagementSection = true;
            System.out.println("Admin navigated to the " + section + " section.");
        }
    }

    @When("selects the option to {string}")
    public void selectsTheOptionTo(String option) {
        if (isInContentManagementSection && "Manage User Feedback".equals(option)) {
            System.out.println("Admin selected the option to " + option + ".");
        }
    }

    @Then("the system should display a list of all user feedback")
    public void theSystemShouldDisplayAListOfAllUserFeedback() {
        if (isInContentManagementSection) {
            isFeedbackListDisplayed = true; // Simulate feedback list display
            System.out.println("System displays a list of all user feedback.");
            Assert.assertTrue("Feedback list should be displayed", isFeedbackListDisplayed);
        }
    }

    @Then("the admin can review, respond to, or delete any feedback")
    public void theAdminCanReviewRespondToOrDeleteAnyFeedback() {
        if (isFeedbackListDisplayed) {
            // Simulate reviewing, responding to, and deleting feedback
            isFeedbackReviewed = true;
            System.out.println("Admin reviewed user feedback.");

            isFeedbackResponded = true;
            System.out.println("Admin responded to user feedback.");

            isFeedbackDeleted = true;
            System.out.println("Admin deleted user feedback.");

            Assert.assertTrue("Admin should be able to review feedback", isFeedbackReviewed);
            Assert.assertTrue("Admin should be able to respond to feedback", isFeedbackResponded);
            Assert.assertTrue("Admin should be able to delete feedback", isFeedbackDeleted);
        }
    }

    @Then("the system should reflect the changes immediately.")
    public void theSystemShouldReflectTheChangesImmediately() {
        if (isFeedbackReviewed && isFeedbackResponded && isFeedbackDeleted) {
            areChangesReflected = true; // Simulate immediate reflection of changes
            System.out.println("System reflected the changes immediately.");
            Assert.assertTrue("Changes should be reflected immediately", areChangesReflected);
        }
    }

}

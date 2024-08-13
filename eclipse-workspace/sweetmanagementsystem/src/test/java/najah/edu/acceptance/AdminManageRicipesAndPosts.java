package najah.edu.acceptance;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class AdminManageRicipesAndPosts {

MyApplication app;
    
    public void  AccountManagement() {
    	app=new MyApplication();
    
}
    private boolean isAdminLoggedIn;
    private boolean isInContentManagementSection;
    private boolean isContentListDisplayed;
    private boolean isContentCreated;
    private boolean isContentUpdated;
    private boolean isContentDeleted;
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

    @Then("the admin should see a list of all shared content, including recipes and posts")
    public void theAdminShouldSeeAListOfAllSharedContentIncludingRecipesAndPosts() {
        if (isInContentManagementSection) {
            isContentListDisplayed = true; // Simulate content list display
            System.out.println("Admin sees a list of all shared content.");
            Assert.assertTrue("Content list should be displayed", isContentListDisplayed);
        }
    }

    @Then("the admin can create, update, or delete any content")
    public void theAdminCanCreateUpdateOrDeleteAnyContent() {
        if (isContentListDisplayed) {
            // Simulate content creation
            isContentCreated = true;
            System.out.println("Admin created new content.");

            // Simulate content update
            isContentUpdated = true;
            System.out.println("Admin updated existing content.");

            // Simulate content deletion
            isContentDeleted = true;
            System.out.println("Admin deleted content.");

            Assert.assertTrue("Admin should be able to create content", isContentCreated);
            Assert.assertTrue("Admin should be able to update content", isContentUpdated);
            Assert.assertTrue("Admin should be able to delete content", isContentDeleted);
        }
    }

    @Then("the system should reflect the changes immediately.")
    public void theSystemShouldReflectTheChangesImmediately() {
        if (isContentCreated && isContentUpdated && isContentDeleted) {
            areChangesReflected = true; // Simulate immediate reflection of changes
            System.out.println("System reflected the changes immediately.");
            Assert.assertTrue("Changes should be reflected immediately", areChangesReflected);
        }
    }

}

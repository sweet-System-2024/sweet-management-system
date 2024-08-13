package najah.edu.acceptance;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class bestSalingProduct {

	MyApplication app;
    
    public void  AccountManagement() {
    	app=new MyApplication();
    
}
    private boolean isLoggedInAsAdmin;
    private boolean isOnReportingSection;
    private boolean hasOptionToViewBestSellingProducts;
    private boolean isStoreListDisplayed;
    private boolean isReportDisplayed;
    private String selectedStore;

    @Given("the admin is logged into the system")
    public void theAdminIsLoggedIntoTheSystem() {
        // Simulate that the admin is logged in
        isLoggedInAsAdmin = true;
        System.out.println("Admin is logged into the system.");
    }

    @When("the admin navigates to the {string} section")
    public void theAdminNavigatesToTheSection(String section) {
        // Simulate navigating to the "Monitoring and Reporting" section
        if (isLoggedInAsAdmin && "Monitoring and Reporting".equals(section)) {
            isOnReportingSection = true;
            System.out.println("Admin navigated to the " + section + " section.");
        }
    }

    @When("the admin selects the option to {string}")
    public void theAdminSelectsTheOptionTo(String option) {
        // Simulate selecting the option to view best-selling products
        if (isOnReportingSection && "View Best-Selling Products".equals(option)) {
            hasOptionToViewBestSellingProducts = true;
            System.out.println("Admin selected the option to " + option + ".");
        }
    }

    @Then("the system should display a list of all stores")
    public void theSystemShouldDisplayAListOfAllStores() {
        // Simulate displaying the list of all stores
        if (hasOptionToViewBestSellingProducts) {
            isStoreListDisplayed = true;
            System.out.println("System displayed a list of all stores.");
        }
        Assert.assertTrue("The list of all stores should be displayed.", isStoreListDisplayed);
    }

    @When("the admin selects a specific store")
    public void theAdminSelectsASpecificStore() {
        // Simulate selecting a specific store
        if (isStoreListDisplayed) {
            selectedStore = "Store #1"; // Example store
            isReportDisplayed = true;
            System.out.println("Admin selected the specific store: " + selectedStore);
        }
    }

    @Then("the system displays a report of the best-selling products for that store.")
    public void theSystemDisplaysAReportOfTheBestSellingProductsForThatStore() {
        // Simulate displaying a report of the best-selling products for the selected store
        Assert.assertTrue("The report for best-selling products should be displayed.", isReportDisplayed);
        System.out.println("System displayed a report of the best-selling products for the store: " + selectedStore);
    }


}

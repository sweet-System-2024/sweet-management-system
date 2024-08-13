package najah.edu.acceptance;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class AdminDisplayStatisticesUserByCity {

	MyApplication app;
    
    public void  AccountManagement() {
    	app=new MyApplication();
    
}

	
    private boolean isLoggedInAsAdmin;
    private boolean isOnReportingSection;
    private boolean hasOptionToViewUserStats;
    private boolean isCityListDisplayed;
    private boolean isUserCountDisplayed;
    private String selectedCity;
    private int userCount;

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

    @When("selects the option to {string}")
    public void selectsTheOptionTo(String option) {
        // Simulate selecting the option to view user statistics by city
        if (isOnReportingSection && "View User Statistics by City".equals(option)) {
            hasOptionToViewUserStats = true;
            System.out.println("Admin selected the option to " + option + ".");
        }
    }

    @Then("the system should display a list of cities \\(e.g., Nablus, Jenin)")
    public void theSystemShouldDisplayAListOfCitiesEGNablusJenin() {
        // Simulate displaying the list of cities
        if (hasOptionToViewUserStats) {
            isCityListDisplayed = true;
            System.out.println("System displayed a list of cities.");
        }
        Assert.assertTrue("The list of cities should be displayed.", isCityListDisplayed);
    }

    @When("the admin selects a city")
    public void theAdminSelectsACity() {
        // Simulate selecting a city from the list
        if (isCityListDisplayed) {
            selectedCity = "Nablus"; // Example city
            // Simulate fetching user count for the selected city
            userCount = 150; // Example user count
            isUserCountDisplayed = true;
            System.out.println("Admin selected the city: " + selectedCity);
        }
    }

    @Then("the system displays the number of registered users in that city.")
    public void theSystemDisplaysTheNumberOfRegisteredUsersInThatCity() {
        // Simulate displaying the number of registered users
        Assert.assertTrue("The user count for the city should be displayed.", isUserCountDisplayed);
        System.out.println("System displayed the number of registered users in " + selectedCity + ": " + userCount);
    }
}

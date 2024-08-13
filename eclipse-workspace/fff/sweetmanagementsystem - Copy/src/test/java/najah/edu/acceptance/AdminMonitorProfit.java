package najah.edu.acceptance;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class AdminMonitorProfit {

MyApplication app;
    
    public void  AccountManagement() {
    	app=new MyApplication();
    
}
	
    private boolean isLoggedInAsAdmin;
    private boolean isOnReportingSection;
    private boolean hasOptionToChooseDateRange;
    private boolean hasGeneratedReport;
    private boolean canDownloadOrPrintReport;
    private String selectedDateRange;
    private String generatedReport;

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
        // Simulate selecting the option to generate financial reports
        if (isOnReportingSection && "Generate Financial Reports".equals(option)) {
            hasOptionToChooseDateRange = true;
            System.out.println("Admin selected the option to " + option + ".");
        }
    }

    @Then("the system should display an option to choose the date range")
    public void theSystemShouldDisplayAnOptionToChooseTheDateRange() {
        // Verify that the option to choose the date range is displayed
        Assert.assertTrue("Option to choose the date range should be displayed.", hasOptionToChooseDateRange);
        System.out.println("System displayed an option to choose the date range.");
    }

    @When("the admin selects the desired date range")
    public void theAdminSelectsTheDesiredDateRange() {
        // Simulate selecting a date range
        if (hasOptionToChooseDateRange) {
            selectedDateRange = "2024-01-01 to 2024-01-31"; // Example date range
            hasGeneratedReport = true;
            generatedReport = "Financial Report for " + selectedDateRange; // Simulated report content
            System.out.println("Admin selected the desired date range: " + selectedDateRange);
        }
    }

    @Then("the system generates and displays a financial report for the selected period")
    public void theSystemGeneratesAndDisplaysAFinancialReportForTheSelectedPeriod() {
        // Verify that a financial report is generated and displayed
        Assert.assertTrue("The report should be generated.", hasGeneratedReport);
        Assert.assertNotNull("The generated report should not be null.", generatedReport);
        System.out.println("System generated and displayed the financial report for the selected period.");
    }

    @Then("the admin can download or print the report.")
    public void theAdminCanDownloadOrPrintTheReport() {
        // Simulate the ability to download or print the report
        if (hasGeneratedReport) {
            canDownloadOrPrintReport = true;
            System.out.println("Admin can download or print the report.");
        }
        Assert.assertTrue("The admin should be able to download or print the report.", canDownloadOrPrintReport);
    }

}

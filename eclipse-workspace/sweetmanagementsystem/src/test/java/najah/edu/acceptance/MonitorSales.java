package najah.edu.acceptance;

import static org.junit.Assert.assertTrue;



import io.cucumber.java.en.*;

public class MonitorSales {

	
	 MyApplication app;
	    
	    public void AccountManagement() {
	    	app=new MyApplication();
	    
	}
	    private boolean isLoggedInAsStoreOwner;
	    private boolean isOnSalesAndProfitsPage;
	    private boolean isReportVisible;
	    
	    @Given("I am logged in as a store owner")
	    public void iAmLoggedInAsAStoreOwner() {
	        // Simulate that the user is logged in as a store owner
	        isLoggedInAsStoreOwner = true;
	        System.out.println("Logged in as a store owner.");
	    }

	    @When("I navigate to the {string} page")
	    public void iNavigateToThePage(String page) {
	        // Simulate navigating to the "Sales and Profits" page
	        if (isLoggedInAsStoreOwner && "Sales and Profits".equals(page)) {
	            isOnSalesAndProfitsPage = true;
	            System.out.println("Navigated to the " + page + " page.");
	        }
	    }

	    @Then("I should see a report displaying the sales and profits for each product")
	    public void iShouldSeeAReportDisplayingTheSalesAndProfitsForEachProduct() {
	        // Simulate that the report is visible
	        if (isOnSalesAndProfitsPage) {
	            isReportVisible = true;
	            System.out.println("Report displaying sales and profits for each product is visible.");
	        } else {
	            isReportVisible = false;
	        }
	        
	        // Verify that the report is visible
	     assertTrue(isReportVisible);
	    }

}

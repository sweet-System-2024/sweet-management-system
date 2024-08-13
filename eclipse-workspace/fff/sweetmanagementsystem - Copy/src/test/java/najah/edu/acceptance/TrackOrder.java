package najah.edu.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class TrackOrder {

	 MyApplication app;
	    
	    public void AccountManagement() {
	    	app=new MyApplication();
	    
	}
	    private boolean isLoggedInAsStoreOwner;
	    private boolean isOnOrderManagementPage;
	    private String selectedOrder;
	    private Map<String, String> orderStatuses = new HashMap<>();

	    @Given("I am logged in as a store owner")
	    public void iAmLoggedInAsAStoreOwner() {
	        // Simulate that the user is logged in as a store owner
	        isLoggedInAsStoreOwner = true;
	        System.out.println("Logged in as a store owner.");
	    }

	    @When("I navigate to the {string} page")
	    public void iNavigateToThePage(String page) {
	        // Simulate navigating to the "Order Management" page
	        if (isLoggedInAsStoreOwner && "Order Management".equals(page)) {
	            isOnOrderManagementPage = true;
	            System.out.println("Navigated to the " + page + " page.");
	        }
	    }

	    @When("I select {string} from the order list")
	    public void iSelectFromTheOrderList(String orderNumber) {
	        // Simulate selecting an order from the list
	        if (isOnOrderManagementPage) {
	            selectedOrder = orderNumber;
	            System.out.println("Selected order: " + orderNumber);
	        }
	    }

	    @Then("I should see the status of {string} displayed as {string}")
	    public void iShouldSeeTheStatusOfDisplayedAs(String orderNumber, String expectedStatus) {
	        // Verify that the order status is displayed as expected
	        String status = orderStatuses.get(orderNumber);
         	assertNotNull("Order status should not be null.", status);
	       assertEquals("Order status does not match the expected value.", expectedStatus, status);
	        System.out.println("Order " + orderNumber + " status displayed as: " + expectedStatus);
	    }

	    // Utility method for setting up test data
	    // You can use this method to initialize the status of orders before running the test
	    public void setupOrderStatus(String orderNumber, String status) {
	        orderStatuses.put(orderNumber, status);
	    }
}

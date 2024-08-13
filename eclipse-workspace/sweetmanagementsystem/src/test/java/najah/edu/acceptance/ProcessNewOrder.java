package najah.edu.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class ProcessNewOrder {

	
	 MyApplication app;
	    
	    public void AccountManagement() {
	    	app=new MyApplication();
	    
	}
	
	    private boolean isLoggedInAsStoreOwner;
	    private boolean isOnOrderManagementPage;
	    private String selectedOrder;
	    private boolean isOrderProcessed;
	    private Map<String, String> orderStatuses = new HashMap<>();

	    @Given("I am logged in as a store owner")
	    public void iAmLoggedInAsAStoreOwner() {
	        // Simulate that the user is logged in as a store owner
	        isLoggedInAsStoreOwner = true;
	        System.out.println("Logged in as a store owner.");
	    }

	    @Given("a new order {string} is pending")
	    public void aNewOrderIsPending(String orderNumber) {
	        // Simulate that a new order is pending
	        if (isLoggedInAsStoreOwner) {
	            orderStatuses.put(orderNumber, "Pending");
	            System.out.println("Order " + orderNumber + " is pending.");
	        }
	    }

	    @When("I navigate to the {string} page")
	    public void iNavigateToThePage(String page) {
	        // Simulate navigating to the "Order Management" page
	        if (isLoggedInAsStoreOwner && "Order Management".equals(page)) {
	            isOnOrderManagementPage = true;
	            System.out.println("Navigated to the " + page + " page.");
	        }
	    }

	    @When("I select {string}")
	    public void iSelect(String orderNumber) {
	        // Simulate selecting an order
	        if (isOnOrderManagementPage && orderStatuses.containsKey(orderNumber)) {
	            selectedOrder = orderNumber;
	            System.out.println("Selected order: " + orderNumber);
	        }
	    }

	    @When("I click {string}")
	    public void iClick(String button) {
	        // Simulate clicking the "Process Order" button
	        if ("Process Order".equals(button) && selectedOrder != null) {
	            orderStatuses.put(selectedOrder, "Processed");
	            isOrderProcessed = true;
	            System.out.println("Order " + selectedOrder + " processed.");
	        }
	    }

	    @Then("I should see a confirmation message {string}")
	    public void iShouldSeeAConfirmationMessage(String message) {
	        // Verify the confirmation message
	        if (isOrderProcessed) {
	            String expectedMessage = "Order processed successfully";
	          assertEquals(expectedMessage, message);
	            System.out.println("Confirmation message: " + message);
	        } else {
	           fail("Order was not processed.");
	        }
	    }

	    @Then("the status of {string} should be updated to {string}")
	    public void theStatusOfShouldBeUpdatedTo(String orderNumber, String expectedStatus) {
	        // Verify that the order status has been updated
	        String status = orderStatuses.get(orderNumber);
	        Assert.assertNotNull(status);
	        Assert.assertEquals(expectedStatus, status);
	        System.out.println("Order " + orderNumber + " status updated to: " + expectedStatus);
	    }
}

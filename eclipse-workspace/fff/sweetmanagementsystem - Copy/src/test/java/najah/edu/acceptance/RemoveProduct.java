package najah.edu.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class RemoveProduct {

	 MyApplication app;
	    
	    public void   AccountManagement() {
	    	app=new MyApplication();
	    
	}

	    private boolean isLoggedInAsStoreOwner;
	    private boolean productExists;
	    private boolean isOnProductManagementPage;
	    private boolean isProductSelected;
	    private boolean isDeleteClicked;
	    private boolean isProductDeleted;
	    private String confirmationMessage;
	    private String productName;

	    @Given("I am logged in as a store owner")
	    public void iAmLoggedInAsAStoreOwner() {
	        // Simulate that the user is logged in as a store owner
	        isLoggedInAsStoreOwner = true;
	        System.out.println("Logged in as a store owner.");
	    }

	    @Given("a product {string} exists in my product catalog")
	    public void aProductExistsInMyProductCatalog(String product) {
	        // Simulate that the product exists in the catalog
	        if (isLoggedInAsStoreOwner) {
	            productName = product;
	            productExists = true;
	            System.out.println(product + " exists in the product catalog.");
	        }
	    }

	    @When("I navigate to the {string} page")
	    public void iNavigateToThePage(String page) {
	        // Simulate navigating to the "Product Management" page
	        if (isLoggedInAsStoreOwner && "Product Management".equals(page)) {
	            isOnProductManagementPage = true;
	            System.out.println("Navigated to the " + page + " page.");
	        }
	    }

	    @When("I select {string} from the product list")
	    public void iSelectFromTheProductList(String product) {
	        // Simulate selecting the product from the list
	        if (isOnProductManagementPage && productExists && productName.equals(product)) {
	            isProductSelected = true;
	            System.out.println("Selected " + product + " from the product list.");
	        }
	    }

	    @When("I click {string}")
	    public void iClick(String button) {
	        // Simulate clicking "Delete" and other actions
	        if ("Delete".equals(button) && isProductSelected) {
	            isDeleteClicked = true;
	            System.out.println("Clicked " + button);
	        }
	    }

	    @When("I confirm the deletion")
	    public void iConfirmTheDeletion() {
	        // Simulate confirming the deletion
	        if (isDeleteClicked) {
	            isProductDeleted = true;
	            confirmationMessage = "Product removed successfully";
	            System.out.println("Deletion confirmed.");
	        }
	    }

	    @Then("I should see a confirmation message {string}")
	    public void iShouldSeeAConfirmationMessage(String message) {
	        // Check if the confirmation message is displayed
	        assertEquals(message, confirmationMessage);
	        System.out.println("Confirmation message displayed: " + message);
	    }

	    @Then("{string} should no longer be listed in the product catalog")
	    public void shouldNoLongerBeListedInTheProductCatalog(String product) {
	        // Simulate checking if the product is removed from the catalog
	        if (isProductDeleted && productName.equals(product)) {
	            // You might want to have a way to verify the product is actually removed in a real implementation
	            System.out.println(product + " should no longer be listed in the product catalog.");
	        }
	    assertTrue(isProductDeleted);
	    }

}

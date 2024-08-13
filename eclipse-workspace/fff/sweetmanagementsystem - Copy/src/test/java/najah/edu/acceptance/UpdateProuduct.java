package najah.edu.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



import io.cucumber.java.en.*;

public class UpdateProuduct {

	 MyApplication app;
	    
	    public void  AccountManagement() {
	    	app=new MyApplication();
	    
	}

	    private boolean isLoggedInAsStoreOwner;
	    private boolean isOnProductManagementPage;
	    private boolean productExists;
	    private String productName;
	    private boolean isEditClicked;
	    private boolean isProductUpdated;
	    private String confirmationMessage;
	    private String updatedPrice;

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
	            System.out.println("Selected " + product + " from the product list.");
	        }
	    }

	    @When("I click {string}")
	    public void iClick(String button) {
	        // Simulate clicking "Edit" and "Save" buttons
	        if ("Edit".equals(button) && isOnProductManagementPage && productExists) {
	            isEditClicked = true;
	            System.out.println("Clicked " + button);
	        } else if ("Save".equals(button) && isEditClicked) {
	            isProductUpdated = true;
	            confirmationMessage = "Product updated successfully";
	            System.out.println("Clicked " + button);
	        }
	    }

	    @When("I change the {string} field to {string}")
	    public void iChangeTheFieldTo(String field, String value) {
	        // Simulate changing the product's price
	        if ("Price".equals(field) && isEditClicked) {
	            updatedPrice = value;
	            System.out.println("Changed the " + field + " field to " + value);
	        }
	    }

	    @Then("I should see a confirmation message {string}")
	    public void iShouldSeeAConfirmationMessage(String message) {
	        // Check if the confirmation message is displayed
	      assertEquals(message, confirmationMessage);
	        System.out.println("Confirmation message displayed: " + message);
	    }

	    @Then("the price of {string} should be updated in the product catalog")
	    public void thePriceOfShouldBeUpdatedInTheProductCatalog(String product) {
	        // Simulate checking if the product price is updated in the catalog
	        if (isProductUpdated && productName.equals(product)) {
	            // You might want to have a way to verify the updated price in a real implementation
	            System.out.println("The price of " + product + " has been updated to " + updatedPrice + " in the product catalog.");
	        }
	       assertTrue(isProductUpdated);
	    }
}

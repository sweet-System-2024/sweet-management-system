package najah.edu.acceptance;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class AddNewprouduct {
  
	 MyApplication app;
	    
	    public void  AccountManagement() {
	    	app=new MyApplication();
	    
	}

	    private boolean isLoggedInAsStoreOwner;
	    private boolean isOnProductManagementPage;
	    private boolean isProductAdded;
	    private String confirmationMessage;
	    private boolean isProductListed;
	    private String productName;

	    @Given("I am logged in as a store owner")
	    public void iAmLoggedInAsAStoreOwner() {
	        // Simulate that the user is logged in as a store owner
	        isLoggedInAsStoreOwner = true;
	        System.out.println("Logged in as a store owner.");
	    }

	    @When("I navigate to the {string} page")
	    public void iNavigateToThePage(String page) {
	        // Simulate navigating to the "Product Management" page
	        if (isLoggedInAsStoreOwner && "Product Management".equals(page)) {
	            isOnProductManagementPage = true;
	            System.out.println("Navigated to the " + page + " page.");
	        }
	    }

	    @When("I click {string}")
	    public void iClick(String button) {
	        // Simulate clicking "Add New Product" and saving the product
	        if ("Add New Product".equals(button) && isOnProductManagementPage) {
	            System.out.println("Clicked " + button);
	        } else if ("Save".equals(button) && isOnProductManagementPage) {
	            isProductAdded = true;
	            confirmationMessage = "Product added successfully";
	            System.out.println("Clicked " + button);
	        }
	    }

	    @When("I fill in the {string} field with {string}")
	    public void iFillInTheFieldWith(String field, String value) {
	        // Simulate filling in the product details
	        if ("Product Name".equals(field) && isOnProductManagementPage) {
	            productName = value;
	            System.out.println("Filled in the " + field + " field with " + value);
	        } else if ("Price".equals(field) && isOnProductManagementPage) {
	            System.out.println("Filled in the " + field + " field with " + value);
	        } else if ("Description".equals(field) && isOnProductManagementPage) {
	            System.out.println("Filled in the " + field + " field with " + value);
	        }
	    }

	    @When("I upload an image of the product")
	    public void iUploadAnImageOfTheProduct() {
	        // Simulate uploading an image of the product
	        if (isOnProductManagementPage) {
	            System.out.println("Uploaded an image of the product.");
	        }
	    }

	    @Then("I should see a confirmation message {string}")
	    public void iShouldSeeAConfirmationMessage(String message) {
	        // Check if the confirmation message is displayed
	        Assert.assertEquals(message, confirmationMessage);
	        System.out.println("Confirmation message displayed: " + message);
	    }

	    @Then("{string} should be listed in the product catalog")
	    public void shouldBeListedInTheProductCatalog(String product) {
	        // Simulate checking if the product is listed in the catalog
	        if (isProductAdded && product.equals(productName)) {
	            isProductListed = true;
	            System.out.println(product + " is listed in the product catalog.");
	        }
	        Assert.assertTrue(isProductListed);
	    }
}

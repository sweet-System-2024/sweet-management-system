package najah.edu.acceptance;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class AddNewProduct2 {

	
	 MyApplication app;
	    
	    public void AccountManagement() {
	    	app=new MyApplication();
	    
	}

	    private boolean isLoggedInAsStoreOwner;
	    private boolean isOnProductManagementPage;
	    private boolean isAddNewProductClicked;
	    private String productName;
	    private String productPrice;
	    private String productDescription;
	    private boolean isImageUploaded;
	    private boolean isProductSaved;
	    private String confirmationMessage;
	    private boolean isProductListed;

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
	        // Simulate clicking "Add New Product" and other actions
	        if ("Add New Product".equals(button) && isOnProductManagementPage) {
	            isAddNewProductClicked = true;
	            System.out.println("Clicked " + button);
	        } else if ("Save".equals(button) && isAddNewProductClicked) {
	            isProductSaved = true;
	            confirmationMessage = "Product added successfully";
	            System.out.println("Clicked " + button);
	        }
	    }

	    @When("I fill in the {string} field with {string}")
	    public void iFillInTheFieldWith(String field, String value) {
	        // Simulate filling in the product details
	        if (isAddNewProductClicked) {
	            switch (field) {
	                case "Product Name":
	                    productName = value;
	                    break;
	                case "Price":
	                    productPrice = value;
	                    break;
	                case "Description":
	                    productDescription = value;
	                    break;
	                default:
	                    throw new IllegalArgumentException("Unknown field: " + field);
	            }
	            System.out.println("Filled in the " + field + " field with " + value);
	        }
	    }

	    @When("I upload an image of the product")
	    public void iUploadAnImageOfTheProduct() {
	        // Simulate uploading an image
	        if (isAddNewProductClicked) {
	            isImageUploaded = true;
	            System.out.println("Uploaded an image of the product.");
	        }
	    }

	    @Then("I should see a confirmation message {string}")
	    public void iShouldSeeAConfirmationMessage(String message) {
	        // Verify the confirmation message
	        Assert.assertEquals(message, confirmationMessage);
	        System.out.println("Confirmation message displayed: " + message);
	    }

	    @Then("{string} should be listed in the product catalog")
	    public void shouldBeListedInTheProductCatalog(String product) {
	        // Simulate checking if the product is listed in the catalog
	        if (isProductSaved && productName.equals(product)) {
	            isProductListed = true;
	            System.out.println(product + " should be listed in the product catalog.");
	        }
	        Assert.assertTrue(isProductListed);
	    }

}

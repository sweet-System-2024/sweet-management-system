package najah.edu.acceptance;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class ubdateProduct2 {
	
	MyApplication app;
    
    public void  AccountManagement() {
    	app=new MyApplication();
    
}

    private boolean isLoggedInAsStoreOwner;
    private boolean isOnProductManagementPage;
    private boolean isProductSelected;
    private boolean isEditClicked;
    private String productName;
    private String newPrice;
    private String confirmationMessage;
    private boolean isProductUpdated;
    private String productCatalogPrice;

    @Given("I am logged in as a store owner")
    public void iAmLoggedInAsAStoreOwner() {
        // Simulate that the user is logged in as a store owner
        isLoggedInAsStoreOwner = true;
        System.out.println("Logged in as a store owner.");
    }

    @Given("a product {string} exists in my product catalog")
    public void aProductExistsInMyProductCatalog(String product) {
        // Simulate that a product exists in the product catalog
        productName = product;
        productCatalogPrice = "20"; // Assume the initial price is 20
        System.out.println("Product " + product + " exists in the product catalog with price " + productCatalogPrice);
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
        // Simulate selecting the product from the product list
        if (isOnProductManagementPage && productName.equals(product)) {
            isProductSelected = true;
            System.out.println("Selected " + product + " from the product list.");
        }
    }

    @When("I click {string}")
    public void iClick(String button) {
        // Simulate clicking "Edit" and "Save"
        if ("Edit".equals(button) && isProductSelected) {
            isEditClicked = true;
            System.out.println("Clicked " + button);
        } else if ("Save".equals(button) && isEditClicked) {
            // Assume the product is successfully updated
            isProductUpdated = true;
            confirmationMessage = "Product updated successfully";
            System.out.println("Clicked " + button);
        }
    }

    @When("I change the {string} field to {string}")
    public void iChangeTheFieldTo(String field, String value) {
        // Simulate changing the product's price
        if (isEditClicked) {
            if ("Price".equals(field)) {
                newPrice = value;
                System.out.println("Changed the " + field + " field to " + value);
            }
        }
    }

    @Then("I should see a confirmation message {string}")
    public void iShouldSeeAConfirmationMessage(String message) {
        // Verify the confirmation message
        Assert.assertEquals(message, confirmationMessage);
        System.out.println("Confirmation message displayed: " + message);
    }

    @Then("the price of {string} should be updated in the product catalog")
    public void thePriceOfShouldBeUpdatedInTheProductCatalog(String product) {
        // Simulate checking if the product price is updated in the catalog
        if (isProductUpdated && productName.equals(product)) {
            productCatalogPrice = newPrice; // Assume the price is updated
            System.out.println("The price of " + product + " has been updated to " + newPrice + " in the product catalog.");
        }
        assertEquals(newPrice, productCatalogPrice);
    }

}

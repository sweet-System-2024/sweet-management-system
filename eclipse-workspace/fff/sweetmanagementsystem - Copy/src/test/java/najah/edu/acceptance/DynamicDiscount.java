package najah.edu.acceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class DynamicDiscount {
	
	
	 MyApplication app;
	    
	    public void AccountManagement() {
	    	app=new MyApplication();
	    
	}

	    private boolean isLoggedInAsStoreOwner;
	    private boolean isOnDiscountManagementPage;
	    private String selectedProduct;
	    private int discountPercentage;
	    private LocalDate discountStartDate;
	    private LocalDate discountEndDate;
	    private boolean isDiscountApplied;
	    private Map<String, Discount> productDiscounts = new HashMap<>();

	    @Given("I am logged in as a store owner")
	    public void iAmLoggedInAsAStoreOwner() {
	        // Simulate that the user is logged in as a store owner
	        isLoggedInAsStoreOwner = true;
	        System.out.println("Logged in as a store owner.");
	    }

	    @When("I navigate to the {string} page")
	    public void iNavigateToThePage(String page) {
	        // Simulate navigating to the "Discount Management" page
	        if (isLoggedInAsStoreOwner && "Discount Management".equals(page)) {
	            isOnDiscountManagementPage = true;
	            System.out.println("Navigated to the " + page + " page.");
	        }
	    }

	    @When("I select {string} from the product list")
	    public void iSelectFromTheProductList(String product) {
	        // Simulate selecting a product from the list
	        if (isOnDiscountManagementPage) {
	            selectedProduct = product;
	            System.out.println("Selected product: " + product);
	        }
	    }

	    @When("I set a {string} of {string}")
	    public void iSetAOf(String attribute, String value) {
	        if ("Discount".equals(attribute)) {
	            discountPercentage = Integer.parseInt(value.replace("%", ""));
	            System.out.println("Set discount: " + discountPercentage + "%");
	        }
	    }

	    @When("I set the {string} to {string}")
	    public void iSetTheTo(String attribute, String value) {
	        if ("Start Date".equals(attribute)) {
	            discountStartDate = LocalDate.parse(value);
	            System.out.println("Set start date: " + discountStartDate);
	        } else if ("End Date".equals(attribute)) {
	            discountEndDate = LocalDate.parse(value);
	            System.out.println("Set end date: " + discountEndDate);
	        }
	    }

	    @When("I click {string}")
	    public void iClick(String button) {
	        if ("Apply Discount".equals(button)) {
	            // Simulate applying the discount
	            if (isOnDiscountManagementPage && selectedProduct != null) {
	                productDiscounts.put(selectedProduct, new Discount(discountPercentage, discountStartDate, discountEndDate));
	                isDiscountApplied = true;
	                System.out.println("Discount applied to " + selectedProduct);
	            }
	        }
	    }

	    @Then("I should see a confirmation message {string}")
	    public void iShouldSeeAConfirmationMessage(String message) {
	        // Verify the confirmation message
	        if (isDiscountApplied) {
	            String expectedMessage = "Discount applied successfully";
	            Assert.assertEquals(expectedMessage, message);
	            System.out.println("Confirmation message: " + message);
	        } else {
	            Assert.fail("Discount was not applied.");
	        }
	    }

	    @Then("the {string} should be listed with a {int}% discount during the specified period")
	    public void theShouldBeListedWithADiscountDuringTheSpecifiedPeriod(String product, Integer discount) {
	        // Verify that the discount is correctly applied
	        Discount appliedDiscount = productDiscounts.get(product);
	    assertNotNull(appliedDiscount);
	      assertEquals(discount.intValue(), appliedDiscount.getPercentage());
	  assertTrue(!LocalDate.now().isBefore(appliedDiscount.getStartDate()) && !LocalDate.now().isAfter(appliedDiscount.getEndDate()));
	        System.out.println(product + " is listed with a " + discount + "% discount during the specified period.");
	    }

	    // Discount class to hold discount details
	    private static class Discount {
	        private final int percentage;
	        private final LocalDate startDate;
	        private final LocalDate endDate;

	        public Discount(int percentage, LocalDate startDate, LocalDate endDate) {
	            this.percentage = percentage;
	            this.startDate = startDate;
	            this.endDate = endDate;
	        }

	        public int getPercentage() {
	            return percentage;
	        }

	        public LocalDate getStartDate() {
	            return startDate;
	        }

	        public LocalDate getEndDate() {
	            return endDate;
	        }
	    }


}

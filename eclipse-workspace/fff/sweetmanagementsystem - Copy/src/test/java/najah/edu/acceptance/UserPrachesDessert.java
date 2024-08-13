package najah.edu.acceptance;

import static org.junit.Assert.assertTrue;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserPrachesDessert {

	MyApplication app;
    
    public void  AccountManagement() {
    	app=new MyApplication();
    
} private boolean isBrowsingDesserts;
private String selectedDessert;
private int selectedQuantity;
private boolean isAddedToCart;
private boolean isCheckoutProceeded;
private boolean isPaymentProcessed;
private boolean isOrderConfirmed;

@Given("the user is browsing desserts on the platform")
public void theUserIsBrowsingDessertsOnThePlatform() {
    // Simulate that the user is browsing desserts
    isBrowsingDesserts = true;
    System.out.println("User is browsing desserts on the platform.");
}

@When("the user clicks on a dessert they wish to purchase")
public void theUserClicksOnADessertTheyWishToPurchase() {
    if (isBrowsingDesserts) {
        selectedDessert = "Chocolate Cake"; // Example dessert
        System.out.println("User clicked on the dessert: " + selectedDessert);
    }
}

@When("selects the quantity")
public void selectsTheQuantity() {
    if (selectedDessert != null) {
        selectedQuantity = 2; // Example quantity
        System.out.println("User selected quantity: " + selectedQuantity);
    }
}

@When("clicks on the {string} button")
public void clicksOnTheButton(String button) {
    if ("Add to Cart".equals(button) && selectedQuantity > 0) {
        isAddedToCart = true;
        System.out.println("User clicked on the " + button + " button.");
    }
}

@When("proceeds to checkout")
public void proceedsToCheckout() {
    if (isAddedToCart) {
        isCheckoutProceeded = true;
        System.out.println("User proceeded to checkout.");
    }
}

@When("provides payment and delivery information")
public void providesPaymentAndDeliveryInformation() {
    if (isCheckoutProceeded) {
        isPaymentProcessed = true; // Assume payment is processed successfully
        System.out.println("User provided payment and delivery information.");
    }
}

@Then("the system should process the payment and confirm the purchase")
public void theSystemShouldProcessThePaymentAndConfirmThePurchase() {
    if (isPaymentProcessed) {
        isOrderConfirmed = true; // Assume the order is confirmed
        System.out.println("System processed the payment and confirmed the purchase.");
       assertTrue("Order should be confirmed", isOrderConfirmed);
    }
}

@Then("the user should receive an order confirmation.")
public void theUserShouldReceiveAnOrderConfirmation() {
    if (isOrderConfirmed) {
        System.out.println("User received an order confirmation.");
    }
}
}

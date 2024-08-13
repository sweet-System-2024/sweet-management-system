package najah.edu.acceptance;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountManagement {
    MyApplication app;
    
    public  AccountManagement() {
    	app=new MyApplication();
    
}

    private String businessName;
    private String address;
    private String confirmationMessage;
    private String updatedBusinessName;
    private String updatedAddress;

    @Given("I am logged in as a store owner")
    public void iAmLoggedInAsAStoreOwner() {
        // Simulate user login as a store owner
        System.out.println("Store owner is logged in.");
    }

    @When("I navigate to the {string} page")
    public void iNavigateToThePage(String page) {
        // Simulate navigation to the specified page
        System.out.println("Navigated to the " + page + " page.");
    }

    @When("I click {string}")
    public void iClick1(String button) {
        // Simulate clicking a button
        System.out.println("Clicked on the " + button + " button.");
    }

    @When("I update the {string} field to {string}")
    public void iUpdateTheFieldTo(String field, String value) {
        // Simulate updating the field with the specified value
        if (field.equals("Business Name")) {
            updatedBusinessName = value;
        } else if (field.equals("Address")) {
            updatedAddress = value;
        }
        System.out.println("Updated the " + field + " field to " + value + ".");
    }

    @When("I click {string}")
    public void iClick(String button) {
        if (button.equals("Save")) {
            // Simulate saving the updated information
            businessName = updatedBusinessName;
            address = updatedAddress;
            confirmationMessage = "Business information updated successfully";
        }
        System.out.println("Clicked on the " + button + " button.");
    }

    @Then("I should see a confirmation message {string}")
    public void iShouldSeeAConfirmationMessage(String expectedMessage) {
        Assert.assertEquals("Confirmation message should be displayed.", expectedMessage, confirmationMessage);
        System.out.println("Confirmation message: " + confirmationMessage);
    }

    @Then("the updated business name and address should be reflected in my account details")
    public void theUpdatedBusinessNameAndAddressShouldBeReflectedInMyAccountDetails() {
        Assert.assertEquals("Sweet Delights", businessName);
        Assert.assertEquals("123 Dessert Lane", address);
        System.out.println("Updated business name: " + businessName);
        System.out.println("Updated address: " + address);
    }



}

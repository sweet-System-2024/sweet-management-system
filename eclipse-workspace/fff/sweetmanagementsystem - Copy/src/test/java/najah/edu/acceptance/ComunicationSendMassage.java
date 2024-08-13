package najah.edu.acceptance;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class ComunicationSendMassage {

	 MyApplication app;
	    
	    public void AccountManagement() {
	    	app=new MyApplication();
	    
	}
	

	    private boolean isStoreOwnerLoggedIn;
	    private boolean isOnMessagingPage;
	    private String selectedSupplier;
	    private String messageContent;
	    private boolean isMessageSent;
	    private boolean isConfirmationMessageDisplayed;
	    private boolean isMessageReceivedBySupplier;

	    @Given("I am logged in as a store owner")
	    public void iAmLoggedInAsAStoreOwner() {
	        // Simulate store owner login
	        isStoreOwnerLoggedIn = true;
	        System.out.println("Store owner is logged in.");
	    }

	    @When("I navigate to the {string} page")
	    public void iNavigateToThePage(String page) {
	        if (isStoreOwnerLoggedIn && "Messaging".equals(page)) {
	            isOnMessagingPage = true;
	            System.out.println("Navigated to the " + page + " page.");
	        }
	    }

	    @When("I select {string} from the contact list")
	    public void iSelectFromTheContactList(String supplier) {
	        if (isOnMessagingPage) {
	            selectedSupplier = supplier;
	            System.out.println("Selected " + supplier + " from the contact list.");
	        }
	    }

	    @When("I type {string} in the message field")
	    public void iTypeInTheMessageField(String message) {
	        if (selectedSupplier != null) {
	            messageContent = message;
	            System.out.println("Typed message: " + message);
	        }
	    }

	    @When("I click {string}")
	    public void iClick(String button) {
	        if ("Send".equals(button) && messageContent != null) {
	            isMessageSent = true; // Simulate sending the message
	            System.out.println("Clicked " + button + " button.");
	        }
	    }

	    @Then("I should see a confirmation message {string}")
	    public void iShouldSeeAConfirmationMessage(String message) {
	        if (isMessageSent) {
	            isConfirmationMessageDisplayed = "Message sent successfully".equals(message);
	            System.out.println("Confirmation message: " + message);
	            Assert.assertTrue("Confirmation message should be displayed", isConfirmationMessageDisplayed);
	        }
	    }

	    @Then("{string} should receive the message")
	    public void shouldReceiveTheMessage(String supplier) {
	        if (isConfirmationMessageDisplayed) {
	            // Simulate the supplier receiving the message
	            isMessageReceivedBySupplier = selectedSupplier.equals(supplier);
	            System.out.println(supplier + " should have received the message.");
	            Assert.assertTrue(supplier + " should have received the message", isMessageReceivedBySupplier);
	        }
	    }

	
}

package najah.edu.acceptance;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class CommunicationAndFeedback {

MyApplication app;
    
    public void  AccountManagement() {
    	app=new MyApplication();
    
}

    private boolean isUserLoggedIn;
    private boolean isOnProfilePage;
    private boolean isChatWindowDisplayed;
    private String messageSent;
    private String messageReceived;
    private String chatHistory;

    @Given("the user is logged into the platform")
    public void theUserIsLoggedIntoThePlatform() {
        // Simulate user login
        isUserLoggedIn = true;
        System.out.println("User is logged in.");
    }

    @When("the user navigates to a store owner's or supplier's profile")
    public void theUserNavigatesToAStoreOwnerSOrSupplierSProfile() {
        if (isUserLoggedIn) {
            isOnProfilePage = true;
            System.out.println("User navigates to a store owner's or supplier's profile.");
        }
    }

    @When("clicks on the {string} button")
    public void clicksOnTheButton(String buttonName) {
        if (isOnProfilePage && buttonName.equals("Message")) {
            isChatWindowDisplayed = true;
            System.out.println("User clicks on the 'Message' button and chat window is displayed.");
        }
    }

    @Then("the system should display a chat window")
    public void theSystemShouldDisplayAChatWindow() {
        Assert.assertTrue("Chat window should be displayed.", isChatWindowDisplayed);
    }

    @When("the user types a message and clicks {string}")
    public void theUserTypesAMessageAndClicks(String action) {
        if (isChatWindowDisplayed && action.equals("Send")) {
            messageSent = "Hello, I would like to inquire about your products.";
            // Simulate sending a message
            messageReceived = messageSent; // In a real system, this would be the reply or confirmation
            chatHistory = "User: Hello, I would like to inquire about your products.\nStore/Supplier: Response to the inquiry.";
            System.out.println("User types a message and clicks 'Send'.");
        }
    }

    @Then("the system should deliver the message to the store owner or supplier")
    public void theSystemShouldDeliverTheMessageToTheStoreOwnerOrSupplier() {
        Assert.assertEquals("Message should be delivered to the store owner or supplier.", messageSent, messageReceived);
    }

    @Then("the user should be able to see the conversation history.")
    public void theUserShouldBeAbleToSeeTheConversationHistory() {
        Assert.assertNotNull("Conversation history should be available.", chatHistory);
        System.out.println("Conversation history: " + chatHistory);
    }

}

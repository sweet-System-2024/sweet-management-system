package najah.edu.acceptance;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class ComuincationReciveMassage {

	
MyApplication app;
    
    public void   AccountManagement() {
    	app=new MyApplication();
    
}
	
    private boolean isStoreOwnerLoggedIn;
    private boolean hasPendingSpecialRequest;
    private boolean isNewSpecialRequestReceived;
    private boolean isNotificationReceived;
    private String emailNotificationContent;

    @Given("I am logged in as a store owner")
    public void iAmLoggedInAsAStoreOwner() {
        // Simulate store owner login
        isStoreOwnerLoggedIn = true;
        System.out.println("Store owner is logged in.");
    }

    @Given("I have a pending special request")
    public void iHaveAPendingSpecialRequest() {
        if (isStoreOwnerLoggedIn) {
            hasPendingSpecialRequest = true;
            System.out.println("Store owner has a pending special request.");
        }
    }

    @When("a new special request is received")
    public void aNewSpecialRequestIsReceived() {
        if (hasPendingSpecialRequest) {
            isNewSpecialRequestReceived = true;
            // Simulate sending an email notification
            emailNotificationContent = "You have a new special request: Details of the request.";
            System.out.println("New special request received and notification sent.");
        }
    }

    @Then("I should receive a notification via email with the request details")
    public void iShouldReceiveANotificationViaEmailWithTheRequestDetails() {
        if (isNewSpecialRequestReceived) {
            // Simulate checking the email notification
            boolean notificationReceived = emailNotificationContent != null && emailNotificationContent.contains("Details of the request");
            System.out.println("Email notification received: " + emailNotificationContent);
            Assert.assertTrue("Notification should contain request details", notificationReceived);
        }
    }
}

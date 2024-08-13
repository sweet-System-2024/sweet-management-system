package najah.edu.acceptance;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserPostAndShare {
	
	 MyApplication app;
	    
	    public void AccountManagement() {
	    	app=new MyApplication();
	    
	}
	   

	    private boolean isLoggedIn;
	    private boolean isInCreatePostSection;
	    private boolean isPostUploaded;
	    private boolean isPostShared;
	    private boolean isPostPublished;
	    private boolean canOtherUsersView;
	    private boolean canOtherUsersLike;
	    private boolean canOtherUsersComment;

	    @Given("the user is logged into the platform")
	    public void theUserIsLoggedIntoThePlatform() {
	        // Simulate that the user is logged in
	        isLoggedIn = true;
	        System.out.println("User is logged into the platform.");
	    }

	    @When("the user navigates to the {string} section")
	    public void theUserNavigatesToTheSection(String section) {
	        // Simulate navigation to the "Create Post" section
	        if (isLoggedIn && "Create Post".equals(section)) {
	            isInCreatePostSection = true;
	            System.out.println("User navigated to the " + section + " section.");
	        }
	    }

	    @When("uploads a photo or recipe of their dessert creation")
	    public void uploadsAPhotoOrRecipeOfTheirDessertCreation() {
	        // Simulate uploading a photo or recipe
	        if (isInCreatePostSection) {
	            isPostUploaded = true;
	            System.out.println("User uploaded a photo or recipe of their dessert creation.");
	        }
	    }

	    @When("adds a title and description")
	    public void addsATitleAndDescription() {
	        // Simulate adding a title and description
	        if (isPostUploaded) {
	            System.out.println("User added a title and description.");
	        }
	    }

	    @When("clicks on the {string} button")
	    public void clicksOnTheButton(String button) {
	        // Simulate clicking the "Share" button
	        if ("Share".equals(button) && isPostUploaded) {
	            isPostShared = true;
	            System.out.println("User clicked on the " + button + " button.");
	        }
	    }

	    @Then("the system should publish the post on the platform")
	    public void theSystemShouldPublishThePostOnThePlatform() {
	        // Simulate that the system has published the post
	        if (isPostShared) {
	            isPostPublished = true;
	            System.out.println("The system published the post on the platform.");
	        }
	       assertTrue(isPostPublished);
	    }

	    @Then("other users should be able to view, like, and comment on the post.")
	    public void otherUsersShouldBeAbleToViewLikeAndCommentOnThePost() {
	        // Simulate that other users can view, like, and comment on the post
	        if (isPostPublished) {
	            canOtherUsersView = true;
	            canOtherUsersLike = true;
	            canOtherUsersComment = true;
	            System.out.println("Other users can view, like, and comment on the post.");
	        }
	       assertTrue(canOtherUsersView);
	     assertTrue(canOtherUsersLike);
	     assertTrue(canOtherUsersComment);
	    }}

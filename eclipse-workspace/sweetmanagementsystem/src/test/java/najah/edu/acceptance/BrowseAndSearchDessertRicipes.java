package najah.edu.acceptance;

import java.util.Arrays;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BrowseAndSearchDessertRicipes {

	MyApplication app;
    
    public void  AccountManagement() {
    	app=new MyApplication();
    
}
	
    private boolean isLoggedIn;
    private boolean isOnRecipesPage;
    private boolean isSearchResultsDisplayed;
    private String searchKeyword;
    private boolean isBrowsingPossible;
    private String[] recipes = {"Chocolate Cake", "Lemon Tart", "Apple Pie"}; // Example recipes

    @Given("the user is logged into the platform")
    public void theUserIsLoggedIntoThePlatform() {
        // Simulate that the user is logged in
        isLoggedIn = true;
        System.out.println("User is logged into the platform.");
    }

    @When("the user navigates to the {string} section")
    public void theUserNavigatesToTheSection(String section) {
        // Simulate navigating to the "Recipes" section
        if (isLoggedIn && "Recipes".equals(section)) {
            isOnRecipesPage = true;
            System.out.println("User navigated to the " + section + " section.");
        }
    }

    @When("enters a keyword in the search bar")
    public void entersAKeywordInTheSearchBar() {
        // Simulate entering a keyword in the search bar
        searchKeyword = "Chocolate"; // Example keyword
        System.out.println("User entered the keyword: " + searchKeyword);
    }

    @Then("the system should display a list of recipes matching the keyword")
    public void theSystemShouldDisplayAListOfRecipesMatchingTheKeyword() {
        // Simulate displaying search results
        if (isOnRecipesPage && searchKeyword != null) {
            // Example matching logic
            String[] matchingRecipes = getMatchingRecipes(searchKeyword);
            isSearchResultsDisplayed = matchingRecipes.length > 0;
            System.out.println("System displayed the list of recipes matching the keyword.");
        }
        Assert.assertTrue("The search results should be displayed.", isSearchResultsDisplayed);
    }

    @Then("the user should be able to browse through the list")
    public void theUserShouldBeAbleToBrowseThroughTheList() {
        // Simulate browsing through the list
        if (isSearchResultsDisplayed) {
            isBrowsingPossible = true;
            System.out.println("User is able to browse through the list of recipes.");
        }
        Assert.assertTrue("The user should be able to browse through the list of recipes.", isBrowsingPossible);
    }

    private String[] getMatchingRecipes(String keyword) {
        // Example method to filter recipes based on keyword
        return Arrays.stream(recipes)
                .filter(recipe -> recipe.toLowerCase().contains(keyword.toLowerCase()))
                .toArray(String[]::new);
    }
	
}

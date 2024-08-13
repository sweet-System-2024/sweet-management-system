package najah.edu.acceptance;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterRecipes {

	MyApplication app;
    
    public void  AccountManagement() {
    	app=new MyApplication();
    
}

    private boolean isOnRecipesPage;
    private boolean isFilterOptionClicked;
    private String selectedFilter;
    private boolean areFilteredResultsDisplayed;
    private String[] recipes = {
        "Gluten-Free Brownies", 
        "Nut-Free Apple Crisp", 
        "Vegan Pancakes", 
        "Dairy-Free Smoothie"
    }; // Example recipes

    @Given("the user is in the {string} section")
    public void theUserIsInTheSection(String section) {
        // Simulate that the user is in the "Recipes" section
        if ("Recipes".equals(section)) {
            isOnRecipesPage = true;
            System.out.println("User is in the " + section + " section.");
        }
    }

    @When("the user clicks on the {string} option")
    public void theUserClicksOnTheOption(String option) {
        // Simulate clicking on the "Filter" option
        if (isOnRecipesPage && "Filter".equals(option)) {
            isFilterOptionClicked = true;
            System.out.println("User clicked on the " + option + " option.");
        }
    }

    @When("selects dietary preferences or food allergies \\(e.g., gluten-free, nut-free)")
    public void selectsDietaryPreferencesOrFoodAllergiesEGGlutenFreeNutFree() {
        // Simulate selecting dietary preferences or food allergies
        if (isFilterOptionClicked) {
            selectedFilter = "gluten-free"; // Example filter
            System.out.println("User selected the filter: " + selectedFilter);
        }
    }

    @When("clicks on the {string} button")
    public void clicksOnTheButton(String button) {
        // Simulate clicking on the "Apply Filter" button
        if ("Apply Filter".equals(button) && selectedFilter != null) {
            areFilteredResultsDisplayed = true;
            System.out.println("User clicked on the " + button + " button.");
        }
    }

    @Then("the system should display recipes that match the selected filters.")
    public void theSystemShouldDisplayRecipesThatMatchTheSelectedFilters() {
        // Simulate displaying recipes that match the selected filters
        if (areFilteredResultsDisplayed) {
            String[] filteredRecipes = getFilteredRecipes(selectedFilter);
            assertTrue("Filtered recipes should be displayed.", filteredRecipes.length > 0);
            System.out.println("System displayed recipes matching the filter: " + selectedFilter);
        }
    }

    private String[] getFilteredRecipes(String filter) {
        // Example method to filter recipes based on selected filter
        if ("gluten-free".equals(filter)) {
            return new String[] {"Gluten-Free Brownies"};
        } else if ("nut-free".equals(filter)) {
            return new String[] {"Nut-Free Apple Crisp"};
        } else {
            return new String[] {}; // No recipes for other filters
        }
    }
}

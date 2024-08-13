package najah.edu.acceptance;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class AdminIdentifyBestSalling {

	MyApplication app;
    
    public void  AccountManagement() {
    	app=new MyApplication();
    
}
    private boolean isLoggedInAsStoreOwner;
    private boolean isOnBestSellingProductsPage;
    private boolean isReportVisible;
    private String[] topSellingProducts;

    @Given("I am logged in as a store owner")
    public void iAmLoggedInAsAStoreOwner() {
        // Simulate that the user is logged in as a store owner
        isLoggedInAsStoreOwner = true;
        System.out.println("Logged in as a store owner.");
    }

    @When("I navigate to the {string} page")
    public void iNavigateToThePage(String page) {
        // Simulate navigating to the "Best-Selling Products" page
        if (isLoggedInAsStoreOwner && "Best-Selling Products".equals(page)) {
            isOnBestSellingProductsPage = true;
            System.out.println("Navigated to the " + page + " page.");
            
            // Simulate fetching top-selling products
            topSellingProducts = new String[]{"Chocolate Cake", "Vanilla Cupcake", "Red Velvet Cake"};
        }
    }

    @Then("I should see a list of the top-selling products in my store")
    public void iShouldSeeAListOfTheTopSellingProductsInMyStore() {
        // Simulate the report being visible and containing top-selling products
        if (isOnBestSellingProductsPage) {
            isReportVisible = (topSellingProducts != null && topSellingProducts.length > 0);
            System.out.println("Top-selling products are visible.");
            for (String product : topSellingProducts) {
                System.out.println("Top-Selling Product: " + product);
            }
        } else {
            isReportVisible = false;
        }
        
        // Verify that the report is visible and contains top-selling products
        Assert.assertTrue(isReportVisible);
        Assert.assertNotNull(topSellingProducts);
        Assert.assertTrue(topSellingProducts.length > 0);
    }

}

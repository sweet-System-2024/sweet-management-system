Feature: Product Management

Scenario: Add a new product

Given I am logged in as a store owner
When I navigate to the "Product Management" page
And I click "Add New Product"
And I fill in the "Product Name" field with "Chocolate Cake"
And I fill in the "Price" field with "20"
And I fill in the "Description" field with "Delicious chocolate cake"
And I upload an image of the product
And I click "Save"
Then I should see a confirmation message "Product added successfully"
And "Chocolate Cake" should be listed in the product catalog

Scenario: Update an existing product

Given I am logged in as a store owner
And a product "Chocolate Cake" exists in my product catalog
When I navigate to the "Product Management" page
And I select "Chocolate Cake" from the product list
And I click "Edit"
And I change the "Price" field to "18"
And I click "Save"
Then I should see a confirmation message "Product updated successfully"
And the price of "Chocolate Cake" should be updated in the product catalog

Scenario: Remove a product
Given I am logged in as a store owner
And a product "Chocolate Cake" exists in my product catalog
When I navigate to the "Product Management" page
And I select "Chocolate Cake" from the product list
And I click "Delete"
And I confirm the deletion
Then I should see a confirmation message "Product removed successfully"
And "Chocolate Cake" should no longer be listed in the product catalog


Scenario: Add a new product



Given I am logged in as a store owner
When I navigate to the "Product Management" page
And I click "Add New Product"
And I fill in the "Product Name" field with "Chocolate Cake"
And I fill in the "Price" field with "20"
And I fill in the "Description" field with "Delicious chocolate cake"
And I upload an image of the product
And I click "Save"
Then I should see a confirmation message "Product added successfully"
And "Chocolate Cake" should be listed in the product catalog

Scenario: Update an existing product



Given I am logged in as a store owner
And a product "Chocolate Cake" exists in my product catalog
When I navigate to the "Product Management" page
And I select "Chocolate Cake" from the product list
And I click "Edit"
And I change the "Price" field to "18"
And I click "Save"
Then I should see a confirmation message "Product updated successfully"
And the price of "Chocolate Cake" should be updated in the product catalog

Scenario: Remove a product


Given I am logged in as a store owner
And a product "Chocolate Cake" exists in my product catalog
When I navigate to the "Product Management" page
And I select "Chocolate Cake" from the product list
And I click "Delete"
And I confirm the deletion
Then I should see a confirmation message "Product removed successfully"
And "Chocolate Cake" should no longer be listed in the product catalog

Scenario: Monitor sales and profits

Given I am logged in as a store owner
When I navigate to the "Sales and Profits" page
Then I should see a report displaying the sales and profits for each product

Scenario: Identify best-selling products

Given I am logged in as a store owner
When I navigate to the "Best-Selling Products" page
Then I should see a list of the top-selling products in my store

Scenario: Implement a dynamic discount feature

Given I am logged in as a store owner
When I navigate to the "Discount Management" page
And I select "Chocolate Cake" from the product list
And I set a "Discount" of "10%"
And I set the "Start Date" to "2024-08-01"
And I set the "End Date" to "2024-08-07"
And I click "Apply Discount"
Then I should see a confirmation message "Discount applied successfully"
And the "Chocolate Cake" should be listed with a 10% discount during the specified period






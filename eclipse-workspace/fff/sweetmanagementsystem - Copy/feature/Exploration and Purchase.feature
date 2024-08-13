Feature: Exploration and Purchase

Scenario: User browses and searches for dessert recipes

Given the user is logged into the platform
When the user navigates to the "Recipes" section
And enters a keyword in the search bar
Then the system should display a list of recipes matching the keyword
And the user should be able to browse through the list.

Scenario: User filters recipes based on dietary needs or food allergies


Given the user is in the "Recipes" section
When the user clicks on the "Filter" option
And selects dietary preferences or food allergies (e.g., gluten-free, nut-free)
And clicks on the "Apply Filter" button
Then the system should display recipes that match the selected filters.

Scenario: User purchases desserts directly from store owners

Given the user is browsing desserts on the platform
When the user clicks on a dessert they wish to purchase
And selects the quantity
And clicks on the "Add to Cart" button
And proceeds to checkout
And provides payment and delivery information
Then the system should process the payment and confirm the purchase
And the user should receive an order confirmation.
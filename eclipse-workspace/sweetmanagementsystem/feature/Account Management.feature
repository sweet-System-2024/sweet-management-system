Feature: Account Management

Scenario: Update business information

Given I am logged in as a store owner
When I navigate to the "Account Management" page
And I click "Edit Business Information"
And I update the "Business Name" field to "Sweet Delights"
And I update the "Address" field to "123 Dessert Lane"
And I click "Save"
Then I should see a confirmation message "Business information updated successfully"
And the updated business name and address should be reflected in my account details


Feature: User Management
Actor:admin
Scenario: Create a new store owner account
Given I am an admin
When I navigate to the "Create Account" page
And I fill in the "Username" field with "store_owner"
And I fill in the "Password" field with "password123"
And I select "Store Owner" from the "Role" dropdown
And I click "Submit"
Then I should see a confirmation message "Account created successfully"
And the new store owner account should be listed in the user management table
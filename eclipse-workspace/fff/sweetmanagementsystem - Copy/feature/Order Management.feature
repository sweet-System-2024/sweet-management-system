Feature: Order Management

Scenario: Process a new order

Given I am logged in as a store owner
And a new order "Order #12345" is pending
When I navigate to the "Order Management" page
And I select "Order #12345"
And I click "Process Order"
Then I should see a confirmation message "Order processed successfully"
And the status of "Order #12345" should be updated to "Processed"

Scenario: Track order status

Given I am logged in as a store owner
When I navigate to the "Order Management" page
And I select "Order #12345" from the order list
Then I should see the status of "Order #12345" displayed as "Processed"


Feature: Communication and Notification

Scenario: Send a message to a raw material supplier

Given I am logged in as a store owner
When I navigate to the "Messaging" page
And I select "Supplier A" from the contact list
And I type "Need more flour by next week" in the message field
And I click "Send"
Then I should see a confirmation message "Message sent successfully"
And "Supplier A" should receive the message

Scenario: Receive notifications for special requests 

Given I am logged in as a store owner
And I have a pending special request
When a new special request is received
Then I should receive a notification via email with the request details


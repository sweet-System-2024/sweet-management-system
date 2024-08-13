Feature: Content Management

Scenario: Admin manages content including recipes and posts
Given the admin is logged into the system
When the admin navigates to the "Content Management" section
Then the admin should see a list of all shared content, including recipes and posts
And the admin can create, update, or delete any content
And the system should reflect the changes immediately.

Scenario: Admin manages user feedback

Given the admin is logged into the system
When the admin navigates to the "Content Management" section
And selects the option to "Manage User Feedback"
Then the system should display a list of all user feedback
And the admin can review, respond to, or delete any feedback
And the system should reflect the changes immediately.


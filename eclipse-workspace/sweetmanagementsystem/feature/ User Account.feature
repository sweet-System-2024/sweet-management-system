Feature: User Account

Scenario: User signs up for a new account

Given the user is on the platform's homepage
When the user clicks on the "Sign Up" button
Then the system should display the registration form
When the user fills in the required details and submits the form
Then the system creates a new account for the user
And the user should receive a confirmation message.

Scenario: User signs in to the platform

Given the user has a registered account
When the user navigates to the login page
And enters their credentials
And clicks on the "Sign In" button
Then the system should authenticate the user
And redirect the user to their dashboard.

Scenario: User manages personal account


Given the user is logged into the platform
When the user navigates to the "Account Settings" section
Then the user should see options to update their personal information, change their password, and manage notification preferences
When the user makes changes and clicks "Save"
Then the system should update the user's account with the new information.

Scenario: User posts and shares personal dessert creations


Given the user is logged into the platform
When the user navigates to the "Create Post" section
And uploads a photo or recipe of their dessert creation
And adds a title and description
And clicks on the "Share" button
Then the system should publish the post on the platform
And other users should be able to view, like, and comment on the post.


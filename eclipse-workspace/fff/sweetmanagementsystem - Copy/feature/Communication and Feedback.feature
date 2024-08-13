Feature: Communication and Feedback

Scenario: User communicates directly with store owners and suppliers

Given the user is logged into the platform
When the user navigates to a store owner's or supplier's profile
And clicks on the "Message" button
Then the system should display a chat window
When the user types a message and clicks "Send"
Then the system should deliver the message to the store owner or supplier
And the user should be able to see the conversation history.

Scenario: User provides feedback on purchased products and shared recipes

Given the user has purchased a product or viewed a recipe
When the user navigates to the "Order History" or "Recipes" section
And clicks on the "Provide Feedback" button next to the product or recipe
Then the system should display a feedback form
When the user enters their feedback and clicks "Submit"
Then the system should save the feedback and notify the store owner or recipe creator.









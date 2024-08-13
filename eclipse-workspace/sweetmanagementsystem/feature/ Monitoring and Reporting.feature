Feature: Monitoring and Reporting

Scenario: Admin monitors profits and generates financial reports

Given the admin is logged into the system
When the admin navigates to the "Monitoring and Reporting" section
And selects the option to "Generate Financial Reports"
Then the system should display an option to choose the date range
When the admin selects the desired date range
Then the system generates and displays a financial report for the selected period
And the admin can download or print the report.

Scenario: Admin identifies best-selling products in each store

Given the admin is logged into the system
When the admin navigates to the "Monitoring and Reporting" section
And selects the option to "View Best-Selling Products"
Then the system should display a list of all stores
When the admin selects a specific store
Then the system displays a report of the best-selling products for that store.

Scenario: Admin gathers and displays statistics on registered users by city

Given the admin is logged into the system
When the admin navigates to the "Monitoring and Reporting" section
And selects the option to "View User Statistics by City"
Then the system should display a list of cities (e.g., Nablus, Jenin)
When the admin selects a city
Then the system displays the number of registered users in that city.






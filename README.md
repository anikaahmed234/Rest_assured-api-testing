# REST Assured API Project with Selenium in Java

# Introduction:
This project demonstrates the use of REST Assured API and Selenium to perform various actions on a web application. The web application used in this project is assumed to have features for creating customers and agents, logging in with a customer account, updating phone number of the customer, transferring funds from system account to agent account, cashing in funds to the customer account from agent account, checking balance of both customer and agent, and cashing out funds from the customer account.

# Prerequisites:

JDK 8 or later
IntelliJ IDEA or any other Java IDE
Selenium WebDriver
REST Assured API
TestNG

# You can get the collection from here: https://documenter.getpostman.com/view/18384612/2s93JxqgMZ

# Test Cases:

1. Create a customer and agent: This test case creates a new customer and agent in the web application.

2. Login with the customer: This test case logs in with the customer account created in the previous test case.

3. Update phone number of the customer: This test case updates the phone number of the customer account.

4. Give 2000 tk to the agent from System account: This test case transfers 2000 tk from the system account to the agent account.

5. Cash in tk 1000 to the customer from the agent account: This test case transfers 1000 tk from the agent account to the customer account.

6. Check balance of customer and agent: This test case checks the balance of both customer and agent accounts.

7. Cashout 500 tk from the customer: This test case withdraws 500 tk from the customer account.

8. Check the balance of customer again: This test case checks the balance of the customer account again after cashing out.

# Project Setup:

1. Clone this repository to your local machine.

2. Open the project in IntelliJ IDEA.

3. Add Selenium WebDriver and REST Assured API dependencies to the project.

4. Add TestNG library to the project.

5. Update the config.properties file with your web application URL, username and password.

@sauceDemo
Feature: SauceDemo
	@standardUser @oneProduct @passedTest
	Scenario: User Ordering Any One Product
		Given User launch the browser
		|chrome|
		And User goto Saucedemo login page
		|https://www.saucedemo.com/|
		When User login with valid username and password
		|standard_user|
		|secret_sauce|
		And User directed to the inventory page
		And User add the SauceLabs Backpack to the cart
		And User click the cart button
		And User click checkout option
		And User gives details
		|Sathish|
		|Kumar|
		|600042|
		And User click continue button
		And User click finish button
		Then Verify the order confirmation
		And User close the browser
	@standardUser @twoProduct @passedTest
	Scenario: User Ordering Any Two Products
		Given User launch the browser
		|chrome|
		And User goto Saucedemo login page
		|https://www.saucedemo.com/|
		When User login with valid username and password
		|standard_user|
		|secret_sauce|
		And User directed to the inventory page
		And User adds the Sauce Labs Backpack and SauceLabs Boult Tshirt to the cart
		And User click the cart button
		And User click checkout option
		And User gives details
		|Sathish|
		|Kumar|
		|600042|
		And User click continue button
		And User click finish button
		Then Verify the order confirmation
		And User close the browser
	@standardUser @allProduct @passedTest
	Scenario: User Ordering All The Products
		Given User launch the browser
		|chrome|
		And User goto Saucedemo login page
		|https://www.saucedemo.com/|
		When User login with valid username and password
		|standard_user|
		|secret_sauce|
		And User directed to the inventory page
		And User adds all the products to the cart
		And User click the cart button
		And User click checkout option
		And User gives details
		|Sathish|
		|Kumar|
		|600042|
		And User click continue button
		And User click finish button
		Then Verify the order confirmation
		And User close the browser
	@standardUser @maxProduct @passedTest
	Scenario: Order Sauce Labs Maximum Priced Product
		Given User launch the browser
		|chrome|
		And User goto Saucedemo login page
		|https://www.saucedemo.com/|
		When User login with valid username and password
		|standard_user|
		|secret_sauce|
		And User directed to the inventory page
		And User add the high value product to the cart
		And User click the cart button
		And User click checkout option
		And User gives details
		|Sathish|
		|Kumar|
		|600042|
		And User click continue button
		And User click finish button
		Then Verify the order confirmation
		And User close the browser
	@standardUser @minProduct @passedTest
	Scenario: Order Sauce Labs Minimum Priced Product
		Given User launch the browser
		|chrome|
		And User goto Saucedemo login page
		|https://www.saucedemo.com/|
		When User login with valid username and password
		|standard_user|
		|secret_sauce|
		And User directed to the inventory page
		And User add the low value product to the cart
		And User click the cart button
		And User click checkout option
		And User gives details
		|Sathish|
		|Kumar|
		|600042|
		And User click continue button
		And User click finish button
		Then Verify the order confirmation
		And User close the browser
	@lockedUser @oneProduct @failedTest
	Scenario: User Is Locked Out
		Given User launch the browser
		|chrome|
		And User goto Saucedemo login page
		|https://www.saucedemo.com/|
		When User login with valid username and password
		|locked_out_user|
		|secret_sauce|
		And User directed to the inventory page
		And User add the SauceLabs Backpack to the cart
		And User click the cart button
		And User click checkout option
		And User gives details
		|Sathish|
		|Kumar|
		|600042|
		And User click continue button
		And User click finish button
		Then Verify the order confirmation
		And User close the browser
	@glitchUser @failedTest @oneProduct
	Scenario: User Facing Performance Glitch While login
		Given User launch the browser
		|chrome|
		And User goto Saucedemo login page
		|https://www.saucedemo.com/|
		When User login with valid username and password
		|performance_glitch_user|
		|secret_sauce|
		And User directed to the inventory page
		And User add the SauceLabs Backpack to the cart
		And User click the cart button
		And User click checkout option
		And User gives details
		|Sathish|
		|Kumar|
		|600042|
		And User click continue button
		And User click finish button
		Then Verify the order confirmation
		And User close the browser
	@problemUser @oneProduct @failedTest
	Scenario: User Facing Problem In The Inventory Page
		Given User launch the browser
		|chrome|
		And User goto Saucedemo login page
		|https://www.saucedemo.com/|
		When User login with valid username and password
		|problem_user|
		|secret_sauce|
		And User directed to the inventory page
		And User add the SauceLabs Backpack to the cart
		And User click the cart button
		And User click checkout option
		And User gives details
		|Sathish|
		|Kumar|
		|600042|
		And User click continue button
		And User click finish button
		Then Verify the order confirmation
		And User close the browser
	
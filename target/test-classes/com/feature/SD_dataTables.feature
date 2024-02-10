@sauceDemo
Feature: sauceDemoDataTable
	Scenario Outline: User Ordering two products
		Given User launch the browser
		|chrome|
		And User goto Saucedemo login page
		|https://www.saucedemo.com/|
		When User login with "<userName>" username and "<passWord>" password
		And User directed to the inventoryPage
		And User adds the Sauce Labs Backpack and SauceLabsBoult Tshirt to the cart
		And User click the shopping cart button
		And User click order checkout option
		And User gives details
		|Sathish|
		|Kumar|
		|600042|
		And User click continue to order button
		And User click finish order button
		Then Verify the order is confirmation
		And User close browser
		
		Examples:
		|userName								|passWord			|
		|standard_user					|secret_sauce |
		|problem_user						|secret_sauce |
		|performance_glitch_user|secret_sauce |
		|locked_out_user				|secret_sauce |
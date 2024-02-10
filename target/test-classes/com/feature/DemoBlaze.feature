@demoBlaze
Feature: DemoBlaze
	@signup
	Scenario: User signup
		Given User go to demoBlaze home page
		When User click signup option
		And User enters the signup credentials
		|sathish88888|
		|sathish@12345|
		Then User click signup button
		And User accept alert
	@login
	Scenario: User login
		Given User go to demoBlaze home page
		When User click login option
		And User enters the login credentials
		|sathish88888 |
		|sathish@12345|
		Then User click login button
	@order @monitor @apple
	Scenario: User orders apple monitor
		Given User clicks monitor option
		When User select apple monitor
		And User adds apple monitor to cart
		And User clicks cart button
		And User clicks place order button
		And User enters personal details
		|SathishKumar|
		|India|
		|Chennai|
		|3579512584561234|
		|03|
		|2025|
		Then User clicks purchase button	
	@order @monitor @asus
	Scenario: User orders asus monitor
		Given User clicks monitor option
		When User select asus monitor
		And User adds asus monitor to cart
		And User clicks cart button
		And User clicks place order button
		And User enters personal details
		|SathishKumar|
		|India|
		|Chennai|
		|3579512584561234|
		|03|
		|2025|
		Then User clicks purchase button
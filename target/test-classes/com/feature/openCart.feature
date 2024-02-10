Feature: OpenCart Webpage Automation
	@openCart
	Scenario: Opencart register user page
		Given User go to opencart homepage
		Then User click myAccount Option
		And User click register option
		And User gives registration credentials
		|Sathish|
		|Kumar|
		|sathish@gmail.com|
		|12345678|
		Then User click read agreement checkbox
		And User click continue button to register
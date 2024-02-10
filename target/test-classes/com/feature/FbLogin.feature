@faceBook
Feature: FbLogin
	Scenario Outline: Login With Valid Credentials
		Given User opens facebook page
		When User enters "<email>" username input field
		And User enters "<password>" password input field
		And User click the login button
		Then User directed to their homepage
		And User closes the browser
		Examples:
		|email						|password		|
		|sathish@gmail.com|sathish@123|
		|ram@gmail.com		|ram@123		|
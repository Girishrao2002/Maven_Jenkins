Feature: Login Test

	@LoginTest
	Scenario: User logs in with valid credentials
		Given I navigate to the login page
	  When I enter valid login credentials
	  And I click the login button
	  Then I should see a successful login message



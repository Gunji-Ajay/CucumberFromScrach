#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Title of your feature
  I want to use this template for my feature file

  @sanity
  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser
    When User open URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on logout link
    Then Page Title should be "Your store. Login"
    And close browser 

  @Regression
  Scenario Outline: Unsuccessful login with invalid credentials
    Given User Launch Chrome browser
    When User open URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as <email> and password as <password>
    And Click on login
    And close browser 
    Examples: 
      | email | password| status  |
      | admin@yourstore.co | admin | Fail |
      | ghg@yourstore.com |   admin | Fail    |

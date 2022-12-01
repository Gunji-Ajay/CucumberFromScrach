Feature: Customer


    
   
#Background: Below the common steps for every scenario
    #Given User Launch Chrome browser
    #When User open URL "http://admin-demo.nopcommerce.com/login"
    #And User enters Email as "admin@yourstore.com" and password as "admin"
    #And Click on login
    #Then User can view Dashboard

 Scenario: Add a new Customer
    Given User Launch Chrome browser
    When User open URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User can view Dashboard
    When User click on customer Menu
    And click on customers Menu Item
    And click on Add button 
    Then User can view Add new customer page
    When User enter customer info
    And click on save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser
   #
#Scenario: Search customer by EmailID
 #Given User Launch Chrome browser
 #When User open URL "http://admin-demo.nopcommerce.com/login"
 #And User enters Email as "admin@yourstore.com" and password as "admin"
 #And Click on login
 #Then User can view Dashboard
 #When User click on customer Menu
 #And click on customers Menu Item 
 #And Enter customer Email
 #When Click on search button
 #Then User should found Email in the Search table
 #And close browser
 #
 #Scenario: Search customer by name
#Given User Launch Chrome browser
#When User open URL "http://admin-demo.nopcommerce.com/login"
#And User enters Email as "admin@yourstore.com" and password as "admin"
#And Click on login
#Then User can view Dashboard
 #When User click on customer Menu
 #And click on customers Menu Item 
 #And Enter Customer FirstName
 #And Enter Customer LastName
 #When Click on search button
 #Then User shold found Name in the Search table
 #And close browser 
    
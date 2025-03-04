#Author: Priyanka
@Regression
Feature: New Business Life Case creation
   
    
  @Platform2POCCheck
  Scenario Outline: Verify case creation
    Given User logs into Application with "<username>" and "<password>"
    Then Operator logs off the portal

    Examples: 
      | username     | password       |
      | user2@metlife | Insurance@2024 |
  

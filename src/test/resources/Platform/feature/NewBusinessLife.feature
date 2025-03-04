#Author: Priyanka
@Regression
Feature: New Business Life Case creation
   
    
  @PlatformPOCCheck
  Scenario Outline: Verify case creation
    Given User logs into Application with "<username>" and "<password>"
    When creates New Business Life case
    And enter Applicant information and submits case
    Then a new case should be created
    And Operator logs off the portal

    Examples: 
      | username     | password       |
      | user@metlife | Insurance@2024 |
  

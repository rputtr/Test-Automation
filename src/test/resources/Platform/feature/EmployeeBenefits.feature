#Author: Bichvan
@Regression
Feature: New Employee Benfits Case creation
   
    
  @EmployeeBenefits
  Scenario Outline: Verify Employee Benefits case creation
    Given User logs into Application with "<username>" and "<password>"
    When creates Employee Benefits case
    And enter Employee information and submits case
    Then a new EmployeeBenefits case should be created
    And Operator logs off the portal

    Examples: 
      | username     | password       |
      | user3@metlife | MetLife@2025 |
  

# Created by rprimero 04/05/2022
Feature: Exercise 1

  Scenario: User Performs Exercise 1 steps
    Given User is in KnowIt's homepage
    When User clicks search option
    And Tool gets default value in search box
    And User types automation in search box
    And User press enter
    And User scroll down the page
    And User clicks Facebook icon
    And User closes newly opened tab
    And User navigates back to original tab
    Then User takes screenshot

@focus
Feature: Amazon Purchase
I navigate to the Amazon website
I search for an item
I verify the book in search results
I add the book to my cart
I click on "Proceed to checkout"
Signin Screen should be present

Scenario Outline:
Given I navigate to the Amazon website
When I search for an item "<Book>"
When I verify the book in search results
And I add the book to my cart
And I click on Proceed to checkout
Then Signin screen should be present
Examples:
|  Book                                               |
|  Restore and Rebalance: Yoga for Deep Relaxation    |
|  Software Testing: An Iseb Intermediate Certificate |
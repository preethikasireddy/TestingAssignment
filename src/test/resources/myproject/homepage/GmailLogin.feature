@focus
Feature: Gmail SignIn
As a user of Gmail
I enter the  username and click Next
I enter the password and click Next
Search Mail icon should exist

Scenario Outline:
Given The website page type "<PageType>" is opened in "<ScreenSize>"
When I Click Next
Then the page error message should be "<error>"
Examples:
| PageType | ScreenSize |  error                           |
| SignIn   | desktop    |  Enter an email or phone number  |

Scenario Outline:
Given The website page type "<PageType>" is opened in "<ScreenSize>"
When I enter username "<UserName>" and click Next
When I Click Next
Then the page error message should be "<error>"
Examples:
| PageType | ScreenSize |UserName                    | error           |
| SignIn   | desktop    | seleniumtesting32@gmail.com | Enter a password|


Scenario Outline:
Given The website page type "<PageType>" is opened in "<ScreenSize>"
When I enter username "<UserName>" and click Next
Then the page error message should be "<error>"
Examples:
| PageType | ScreenSize | UserName                   | error   |
| SignIn   | desktop    | funtestingzapper@gmail.com | Couldn't find your Google Account|

Scenario Outline:
Given The website page type "<PageType>" is opened in "<ScreenSize>"
When I enter username "<UserName>" and click Next
When I enter password "<Password>" and click Next
Then the page error message should be "<error>"
Examples:
| PageType | ScreenSize | UserName                    | Password |error|
| SignIn   | desktop    | seleniumtesting32@gmail.com | cheese   |Wrong password. Try again or click Forgot password to reset it.|

Scenario Outline:
Given The website page type "<PageType>" is opened in "<ScreenSize>"
When I enter username "<UserName>" and click Next
When I enter password "<Password>" and click Next
Then the search mail icon exists
Examples:
| PageType | ScreenSize | UserName                     | Password   |
| SignIn   | desktop    | seleniumtesting32@gmail.com  | Selenium@18|


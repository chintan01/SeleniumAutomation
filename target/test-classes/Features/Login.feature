Feature: Login into Application 

Scenario Outline: Positive Test Validation Login
Given Initialize browser with chrome
And Navigate to "http://qaclickacademy.com" Site
And Click on login link in home page to land on secure sign in page
When user eneter <username> and <password> and login
Then Verify user is sucessfully login
And close browser


Examples:

|username         |password|
|test99@gmail.com |123456  |
|test123@gmail.com|12345  |


#Scenario: Home page default login
#Given user is on NetBanking landing page 
#When user login with username="Chintan1" and password="Pass1"
#Then Home page is populated
#And Carts display "false"
#
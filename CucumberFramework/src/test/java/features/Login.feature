
Feature: Application Login

Scenario: Login to application
Given Navigate to login page
When Login to application with "sathishsuresh984@gmail.com" and password "Satz@984"
Then Navigate to Homepage
And Product are displyed

#Feature is basically telling what application you are testing and what is that you are validating
Feature: Validate All the Endpoint of SimpleBooks by using Authenticating with right user credntials

  # is what i am trying to accomplish
  Scenario: Verify Login API to Fetch AccessToken
    # Given is a pre-condition
    Given Login API
    #when is my action item what i have to perform
    When Execute Login "/api-clients/" which provides accessToken
    #is the post condition, kind of verifing my result
    Then verify the status code for accesstoken 201
    #and is the extra then , gain the extra of then
    And verify accessToken in the response
    
    Scenario: Verify ordering a Book
    Given Login successfull with accessToken
    When order a book "/orders" and fetch the orderId
    Then verify the status code for orderId 201
    And verify orderId in the response
  
  
  
  
  
  
  
  # This is an example for understanding
  
    #selenium Login application in web
    #Given Validate Login
   # When Enter the Name
   # And Enter the Password
    #And Click on submit btn
    #Then Login should be successfull

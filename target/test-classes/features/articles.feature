@articles

  Feature: Testing article api service

    @get1
    Scenario: I should see the article list
      Given send a get request to "/articles" endpoint
      Then verify articles with size 5 and status code 200

    @get2
    Scenario: I shouldn't see articles list with invalid url
      Given send a get request to "/article" endpoint
      Then verify response with status code 404

    @get3
      Scenario: Article Schema Validation
      Given send a get request to "/articles/2" endpoint
      Then validate the article response body with schema validation

    @post1
    Scenario: I should be able to create a new Article
      Given attempt a post request to "/articles" with valid article body
      Then verify response with status code 201 and body properties


    @put1
    Scenario: I should be able to update an article body
      Given attempt a put request with updated body to "/articles/" endpoint for article 2
      Then verify  response with status code 200 and response body


    @delete
    Scenario: I should be able to delete an article from article list
      Given attempt a delete request "/articles/" endpoint for article 2
      Then verify response with status code 204

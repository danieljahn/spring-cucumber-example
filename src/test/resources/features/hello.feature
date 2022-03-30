Feature: Hello

  Scenario: Say Hello
    When I request to greet "Bob"
    Then The response code is 200
    And The body field "message" is "Hello, Bob!"

Feature: Simple test for the TestDomain concept

  Scenario: Create a test

    Given there is a (User) "user" with attributes
      | name | id |
      | mateus | 1234 |

    When the (User) "user" executes (CreateTestCommand) "command" with attributes
      | id     | name    |
      | tr1    | James   |

    Then the (CreateTestCommand) "command" outcome is "SUCCESS"
    And the (CreateTestCommand) "command" result {id} is equals to "1"
    And the (CreateTestCommand) "command" result  {name} is equals to "james"

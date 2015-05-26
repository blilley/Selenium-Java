Feature: FizzBuzz
  Scenario Outline: Return Fizz for number divisible by 3
    Given I am on the Fizzbuzz page
    When I process <number>
    Then I should see "Fizz"

    Examples:
      | number |
      |   3    |
      |   6    |
      |   9    |

  Scenario Outline: Return Fizz for number divisible by 5
    Given I am on the Fizzbuzz page
    When I process <number>
    Then I should see "Buzz"

    Examples:
      | number  |
      |   5     |
      |   10    |
      |   20    |

  Scenario Outline: Return Fizz for number divisible by 3 and 5
    Given I am on the Fizzbuzz page
    When I process <number>
    Then I should see "FizzBuzz"

    Examples:
      | number  |
      |   15    |
      |   30    |
      |   45    |

  Scenario: Returns error for numbers less than 1
    Given I am on the Fizzbuzz page
    When I process zero
    Then the error should be visible
    And the message should be "Input cannot be less than 1"
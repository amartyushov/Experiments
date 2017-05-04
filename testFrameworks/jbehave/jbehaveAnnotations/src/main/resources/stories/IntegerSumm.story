Scenario: Summarising two integers
Given integer 3 is inserted
And integer 5 is inserted
When I summ integers
Then I have 8 result

Scenario: Incorrect summarising two integers
Given integer 3 is inserted
And integer 5 is inserted
When I summ integers
Then I have 9 result
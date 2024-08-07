Feature: The user can change their own password
  Rule: As a user
  I want to be able to change my own password within the guidelines of password policy
  So that the integrity of my account security requirements are met.

    Scenario: Verify user should able to change the password with valid credentials
      When User enter "Good@luck" in to username field
      And User enter "1zZ" in to password field
      And User enter "1AA" in to new password field
      And User enter "1AA" in to verify password field
      And User should click on submit button
      Then User should able to change the password successfully

    Scenario Outline: Verify user shouldn't able to change the password with invalid credentials
      When User enter "<username>" in to username field
      And User enter "<password>" in to password field
      And User enter "<new password>" in to new password field
      And User enter "<verify password>" in to verify password field
      And User should click on submit button
      Then User should see error message "<error message>"

      Examples:
        |username  |password  |new password  |verify password  |error message        |
        |Good@luck |1zZ       |111           |111              |not meet the criteria|
        |Good@luck |1zZ       |1a            |1a               |not meet the criteria|
        |Good@luck |1zZ       |BBB           |BBB              |not meet the criteria|
        |Good@luck |1zZ       |1zZ           |1zZ              |password and new password are same|
        |Good@luck |1zZ       |bc4           |4bc              |mismatch the new password and verify password|
        |Good@luck |1zz       |bc4           |bc4              |password is incorrect |
        |Good@luck |          |bc4           |bc4              |password is empty     |
        |Good@luck |1zZ       |              |bc4              |new password is empty |
        |Good@luck |          |              |bc4              |password and new password is empty |
        |Good@luck |1zZ       |bc4           |                 |verify the new password |


Feature:user panel setup


  @wordpress @login @userProfile
  Scenario: Setup user profile
    Given User start on main page
    When user loged in to the user page
    Then user can modified user profile
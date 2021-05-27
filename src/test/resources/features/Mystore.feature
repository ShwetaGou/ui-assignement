Feature: Add products to cart and place the order
  As a registed signed in user user should be able to add products to the cart and place order successfuly

  @smoketest @test
  Scenario Outline: Add two items to cart and place order
    Given user logs into automation practice Website "<username>" "<password>" "<loggedinUserName>"
    And user selects Category "<category>"
    And user adds products to cart and navigates to shopping cart summary  "<product1>" "<product2>"
    And user proceed to checkout from shopping cart summary
    And user proceed to checkout from Address page
    And user agrees to terms  and  proceed to checkout from shipping page
    And user verify the "<total_amount>" and select paymenttype "<selectPaymentType>" on payment page
    When user confirms the order
    Then verify order is successfully placed
    And user logs out of the application

    Examples: 
      | username              | password  | loggedinUserName            | category | product1              | product2 | total_amount | selectPaymentType |
      | assignment01@test.com | test@1234 | Shweta Goudar Siddalingappa | Women    | Printed Chiffon Dress | Blouse   | $45.40       | Pay by check.     |

  @regresiontest @test
  Scenario Outline: User adds product to cart and create an account and then place order
    Given user is on automation practice website
    And user selects Sub Category Dresses- Summer Dresses
    And user adds products to cart and navigates to shopping cart summary  "<product>"
    And user proceed to checkout from shopping cart summary
    And user enter "<email>" in signin page
    And user enter all the details to register to create account "<firstname>"  "<lastname>" "<password>"  "<address>"  "<city>"  "<state>"  "<postcode>" "<mobphone>"
    And user proceed to checkout from Address page
    And user agrees to terms  and  proceed to checkout from shipping page
    And user verify the "<total_amount>" and select paymenttype "<selectPaymentType>" on payment page
    When user confirms the order
    Then verify order is successfully placed
    And user logs out of the application

    Examples: 
      | email           | password  | firstname | lastname | address | city  | state    | postcode | mobphone   | product              | total_amount | selectPaymentType |
      | test01@pink.com | test@1234 | jack      | ryan     | newyork | Adams | New York |    20021 | 1234567893 | Printed Summer Dress | $30.98       | Pay by check.     |

Feature: User Login

        Scenario: User logs in to Adactin Hotel App
          Given the user is on the login page
          When the user enters username through testData
          Then the user should be redirected to the search hotel page

          When the user enters <location>, <checkin>, and <checkout>
          Then the user should see available hotels

          When the user selects a hotel
          Then the user should be redirected to the booking page

          When the user enters personal details and credit card information with name <name> , last name <lastName> , credit card <creditCard> , address <address> , credit card type <CreditCardType> , expiry Month <Expirymonth> , expiry year <Expiryyear> and CVV no <cvvnumber>
          Then the booking confirmation should be displayed



          Examples:
            | location   | checkin     | checkout    | name    | lastName  | creditCard    | address    | CreditCardType    | Expirymonth    | Expiryyear    | cvvnumber    |
            | "New York"   | "22/10/2024"  | "23/10/2024"  | "a"    | "khan"  | "1231312313312313"    | "karachi"    | "VISA"    | "January"    | "2029"    | "212"    |
            | "Los Angeles" | "25/10/2024"  | "28/10/2024"  | "a"    | "khan"  | "1231312313312313"    | "karachi"    | "VISA"    | "January"    | "2029"    | "212"    |
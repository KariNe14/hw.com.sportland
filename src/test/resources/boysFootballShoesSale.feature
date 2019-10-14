Feature: Create a list of boys football shoes on sale with price under 50 eur

  Scenario: Find the product list of boys shoes on sale
    Given Sportland homepage
    When select gender "ZĒNI", select division "APAVI", select product "Futbols"
    When sort products by price filter "Izpārdošana"
    When select product filters:
      | Futbola apavi mākslīgajam segumam |
      | Nike                              |

    Then assert that all opened products have "NIKE" brand
    Then assert that all products contains a discount
#    Then create text file with all info about products below "50,00" euro
#    Then export to json file
#  Then driver quit





Feature: Generating Activities
    To verify that gumtree appears in google search results

@Google
Scenario: I can create perform a google search for cars in london
  Given we have connected to google
  And we search for 'cars in london'
  Given we can see search results from gumtree
  Then we can verify the title of each link



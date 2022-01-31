Scenarios
==============

As a End User
I want the stories of the companies in the "Companies in the News Section" to be viewed and accessed
So that I can get a view of top stories and navigate to read the full text

Scenario: Verify "Companies in the News" section layout
Given User navigates to https://www.afr.com/
When User scrolls to "COMPANIES IN THE NEWS" section
Then User views the section follows the "Opinion and analysis" section
And the heading is on the left
And 6 tiles are present for 6 companies in the news
And a dynamic text "Updated: Jan 31, 2022 – 12.28pm. Data is 20 mins delayed." below the tiles
And a link to the list of comapnies with a text "Äll Companies" and a forward arrow
And a search box tosearch for companies

Scenario: Verify fonts and text of the section.
Given User navigates to https://www.afr.com/
When User scrolls to "COMPANIES IN THE NEWS" section
Then User can view each tile having a heading in bold 
And ASX code in blue bold font
And dollar value in normal font
And Percentage rise in green font with a small upward triangle and % sign
And Percentage decline in red font with a small downward triangle and % sign

Scenario: Hover over the company name
Given User navigates to https://www.afr.com/
When User scrolls to "COMPANIES IN THE NEWS" section
And hovers on the Company name 
Then the comapny name is underlined

Scenario: Navigation to company page via company name
Given User navigates to https://www.afr.com/
When User scrolls to "COMPANIES IN THE NEWS" section
And clicks on the Company name
Then the user is navigated to the company page representing statistics for the company

Scenario: Navigation to company page via ASX code
Given User navigates to https://www.afr.com/
When User scrolls to "COMPANIES IN THE NEWS" section
And clicks on the ASX code
Then the user is navigated to the company page representing statistics for the company

Scenario: Navigation to comapnies list page
Given User navigates to https://www.afr.com/
When User scrolls to "COMPANIES IN THE NEWS" section
And clicks on the "All Companies" link
Then the user is navigated to the page representing the list of comapanies

Scenario: Validate search box layout
Given User navigates to https://www.afr.com/
When User scrolls to "COMPANIES IN THE NEWS" section
Then the user views the default text in the search box equals "Search ASX code or company name"
And satic text "Search companies
View stories and data from an ASX listed company" to the right of search box

Scenario: Search using ASX code
Given User navigates to https://www.afr.com/
When User scrolls to "COMPANIES IN THE NEWS" section
And types ASX code in the search box
Then the available option are displayed as a drop down list
And the user clicks on the company name or asx code from the options
Then the user is navigated to the company page

Scenario: Search using company name
Given User navigates to https://www.afr.com/
When User scrolls to "COMPANIES IN THE NEWS" section
And types Compnay name in the search box
Then the available option are displayed as a drop down list
And the user clicks on the company name or asx code from the options
Then the user is navigated to the company page

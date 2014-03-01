zappos-api
==========

Sample application that uses the Zappos API.<br>
Takes two inputs: numItems, the number of items the user wants to purchase, and totalPrice, the total amount the user wants to spend.<br>
Displays combinations of products that fit the user's criteria, with the sets of items closest to totalPrice displayed first. (Does not discriminate between combos that are higher vs. lower than total.)

<h1>How to use it</h1>
Just compile it and run! Make sure to run the GiftSearch class. It will prompt you for all necessary information and display results to System.out.<br>
Keep in mind that this application uses json-simple, so if it's not running then try manually adding the jar (in lib folder) to your classpath.
If you're still having issues, it's probably best to load it up into Eclipse and run from there.

<h1>Some notes</h1>
Gets really laggy for any dollar amount over about $35. (With $40+, needs to pull over 150 pages of results before it can begin calculations.)<br>
Works in a timely manner for dollar amounts $35 or below. Does calculations (sans API calls) relatively quickly if only 2 or 3 items.<br>
<br>
Some obvious ways to improve:<br>
<ul>
  <li>If could get more than 100 results at a time, would speed up immensely</li>
  <li>Better price combination optimization algorithm</li>
</ul>

Also, note that this does not decode HTML special characters (e.g., &#174).

## Spring MVC Film C.R.U.D.

### Overview

This project simulates a film query website by incorporating full-stack development fundamentals. The client-side of the project presents a user with a simple website from which they can query a film by ID number or by keyword search. The site allows users to create a film with various attributes, update data on existing films, and also to delete films.  The back-end of the project contains logic allowing client-side input to be used to send and receive data from a database and be displayed to the user.  

### Technologies Used

* Java
* Conditionals
* Looping
* Object-Oriented Design
* Try-Catch Statements
* Exceptions
* SQL
* Spring
* MVC
* Gradle

### How to Run

Upon landing on the website, a user is presented with a site title and various sections from which they can choose to query a database, including: Enter a Film ID number, Enter keyword Search Criteria, and Enter New Film Data.  When a user chooses to enter a film ID number, they are taken to a page displaying data for a single film associated with the ID they entered.  The data includes: title, description, release year, rental rate, length, replacement cost, rental duration, special features, category, rating, language name and ID number, and cast.  Each of the film attributes can be changed by the user.  Once the user is done viewing the film data, they can choose to return to the home page and continue another query, or they can submit their data if they made changes by using the button options at the bottom of the page.  The user can also choose to delete the film entirely using the red "delete film" button, also at the bottom of the page.  After changing film data and choosing to submit, the user is taken to a page where they are presented with a message of either a successful or unsuccessful change.  Likewise, if a user chooses to delete a film, they are taken to a page where they are presented with a message as to whether or not the deletion was successful.  

From the home page, when the user chooses to query by entering a keyword, the titles and descriptions of all films in the database are searched and appropriate matches are presented to the user on a redirected page.  Unlike searching by ID number, searching by keyword can display multiple films and associated data.  The data is displayed on a single page, where the user can scroll down to the end of the list.  If their keyword yields no results, the user is presented with a message informing them of such.  If a keyword produces multiple film results, each film section is divided by a line for easier viewing, and the same "submit," "delete film," and "return to the home page" buttons as listed above are at the bottom of each film section for easier navigation.  Multiple films can be updated, and only one submit button needs pushed for all changes to be registered in the database.  Each delete button will delete only the film within the respective section.  Similar to mentioned prior, the user will be presented with a message based on the success or lack of success to updates and deletions.  

If the user chooses to enter new film data, they are able to do so directly on the home page.  After clicking the "submit" button at the bottom of the home page, the user is redirected to another page where a message is presented as to whether or not the addition was successful.  The user can click to return to the home page by using the "return to the home page" button.  

### Lessons Learned

This was the most complex project our cohort has completed to date, and it presented several challenges for successful completion.  The most significant challenge was connecting all of the many moving pieces together between the front and back ends of the project.  It is one thing to tie several Java classes together to make a successful application within an app class, but it is entirely more complex to tie back-end logic to front-end design.  While many of these challenges can eventually be overcome with more experience, as new developers it was--at times--daunting.  The slightest misdirection of code resulted in several errors to appear, causing many delays for troubleshooting.  Querying multiple tables at once for information also proved a difficult task, as it amplified the aforementioned complexity of "connecting the dots."  While challenging, it was a fun and exciting project.  

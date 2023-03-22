# Sysc4806-Project
Amazon Book Store web application 
status: search page still in progress, Login/Signup is done, Bookdetails is done

Team members:
 - Zinah Al-Najjar
 - Tooba Sheikh 
_____________________________________________________________________________

[![Java CI with Maven](https://github.com/zinahalnajjar/Sysc4806-Project/actions/workflows/maven.yml/badge.svg)](https://github.com/zinahalnajjar/Sysc4806-Project/actions/workflows/maven.yml)
_____________________________________________________________________________
Background:
 - Book owner: upload and edit book information, and inventory (in-stock)
 - Users can search and browse
  	- Sort and filter
 - Add book to cart
 	- proceed to checkout
   	- purchases are simulated, but edits the inventory
 - Jaccard distance: recommend books based on history by looking at other similar users
 _________________________________________________________________________________
 Package Description:
 Entity: represents an entity in the repository- we are using Crud Repository for all of   our repositories 
 Repository: using for performing methods such as sorting, paginating data and CRUD operations to access the entities. we currenlty have two repositories UserRepository and BookRepositry 
 Controller: used in connecting the model to the view and we have UserController and BookController 
Resources/Templates: include all HTML pages along with CSS and images 
______________________________________________________________________________
 Main Features:
 we will have two views in the systme: one is a buyer view and the other is an owner view 
 Buyer View:
 Search bar to search the different books available 
 - Filter results:
	 - Range of prices
 	- By language 
 	- By Genre
 	- Range of Ages
- Sort by of the results:
 	- Price low to high 
 	- Price high to low 
 	- Sort by title - Alphabetical 
 	- Sort by author- Alphabetical

Recommendation/main page 
-will include one section for recommended books based on Jaccard distance

Book Details page -will show information for each book 
Account Page - to show the buyer their perosnal information such as their names and email 

Order history Page -> show all the books that the buyer user have purchased 
Cart Page - this will be a dummy payment system to mimic the process of buying a book and removing the bought book from the inventory. 

Owner View:
Add new Book Page - owner will be able to add/post a new book 
View List of books - shows alll the books in the systme 
Update inventory by deleting books 
no payment system 
Search bar to search the different books available 
 - Filter results:
	 - Range of prices
 	- By language 
 	- By Genre
 	- Range of Ages
- Sort by of the results:
 	- Price low to high 
 	- Price high to low 
 	- Sort by title - Alphabetical 
 	- Sort by author- Alphabetical

_____________________________________________________________________________________
Milestone#1: Breakdown 
Features:
two Entity:
 - User - Customer and Book Owner - Zinah
 - Books - Tooba

Two Repository:
 - User - Zinah
 - Books - Tooba

Controllers:
 - BookController - Recomendations and search-Tooba
 - UserController - For creating a new user - Zinah 

For this Milestone, the main focus was on the buyer view 

Tooba:
 - Book Details page
 - Naviagtion Bar (Home, Seacrh, Cart, Account)
 - Account page
 - Sort and Filter HTML Only 

Zinah:
 - Search bar - html element NOT functional yet 
 - Sort - only logic is added
 - Table display of results in search page
 - login and signup pages
 
 Documentation:
 Git repository - Both 
  - Kanban
  - CI/CD
  - Issues 
  - Scrums
  - README - Zinah 
  
___________________________________________________________________________________________
Milestone#2: Breakdown 
Features:
two Entity:
 - User - Customer and Book Owner - Zinah
 - Books - Tooba

Two Repository:
 - User - Zinah
 - Books - Tooba

Controllers:
 - BookController - Recomendations and search-Tooba
 - UserController - For creating a new user - Zinah 

For this Milestone, the main focus was on the buyer view 

Tooba:
 - Filter Feature
 - added CSS to search page 
 - recommendation logic
 - Created UML 
 - Created Junit and integration tests 

Zinah:
 - Search feature 
 - Sort feature
 - recommendation html
 - created Schema
 - Created Junit and integration tests 
 
 Documentation:
 Git repository - Both 
  - Kanban
  - CI/CD
  - Issues 
  - Scrums
  - README - Zinah
  
 
 

 


 

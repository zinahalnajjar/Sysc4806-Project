# Sysc4806-Project
Amazon Book Store web application 
status: search page still in progress, Login/Signup is done, Bookdetails is done

Team members:
Zinah Al-Najjar
Tooba Sheikh 

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
 Entity: represents an entity in the repository- we are using Crud Repository for all of our repositories 
 Repository: using for performing methods such as sorting, paginating data and CRUD operations to access the entities. we currenlty have two repositories UserRepository and BookRepositry 
 Controller: used in connecting the model to the view and we have UserController and BookController 
Resources/Templates: include all HTML pages along with CSS and images 
______________________________________________________________________________
 

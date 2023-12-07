---------------------- Product ---------------------->

    - Project description:
      This project has been developed with React in the front and 
      Spring Boot in the backend. All data are persisted using the H2 database
      of spring boot allowing us to share all the data via an API call handled by Axios 
      The user can do a simple CRUD of a product with content: ID, name, description,
      price, status, image, and an action where the user can edit or delete a product.

      The user can also add a new product by clicking on the button "Add item" which
      will open a modal where the user can add a new product description. The user can also 
      edit a product by clicking on the button "Edit" which will open a modal, and load the selected
      product content that the user can edit. The user can also delete a product by clicking on the 
      delete button.

      The user can sort the table by clicking on the table header ID or name. 
      The user can also search for a product by ID or name.

      Every action of the user is combined with a specific API call to the backend to handle
      the task the user wants to perform
    
--------
    - Functionalities:
      The backend and the front end are completely separated and communicate via an API call.
      The image upload by the user is first sent to Firebase storage and then the link
      is sent back to be rendered in the frontend via API call.
    

--------
The dashboard of the application is the following:

![Dashboard Image](images/dashboard.png)

Search a product by ID:

![Search by id](images/searchID.png)

Search a product by name:

![Search by name](images/byname.png)

Upload an image from the computer:

![Dashboard Image](images/upload.png)

Click on the id or name to sort the table:

![Sort by id](images/sortid.png)
![Sort by n](images/sortname.png)

Edit a product:

![Edit](images/Edit.png)

Add a product:

![Add](images/add.png)

API call to the backend code:

![API call](images/API.png)

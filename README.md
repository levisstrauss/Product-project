---------------------- Product ---------------------->

    - Project description:
      The project has been developed with React in the frontend and 
      Spring Boot in the backend. All data are persisted using the H2 database
      of springboot allowing us to share all the data via an API call handle by Axios 
      The user can do a simple CRUD of a product which content: id, name, description,
      price, status, image and an action where the user can edit or delete a product.

      The user can also add a new product by clicking on the button "Add item" which
      will open a modal where the user can add a new product description. The user can also 
      edit a product by clicking on the button "Edit" which will open a modal, load the selected
      product content where the user can edit. The user can also delete a product by cliking on the 
      delete button.

      The user can sort the table my clicking on the table header ID or name. 
      The user can also search a product by ID or name.

      Every action of the user is combined with a specific API call to the backend to handle
      the task the user want to perform
    
--------
    - Functionalities:
      The backend and the frontend are completely separated and communicate via an API call.
      The image upload by the user is first send to firebase storage and then the link
      is send back to be render in the frontend via api call.
    

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

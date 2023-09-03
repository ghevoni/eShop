# Description
***The eShop Project***

-This is my second project and is thought as an online Romanian application that sells various household appliances, televisions and telephones.

-For household appliances products, I chose refrigerators and washing machines.

-This project is more complex that first, contain many more products, I realised two pagination methods, I sorted products with many criteria, shopping cart is more complex with more features and for each brand of fridges I added a method to decrease stocks when user buy a product.

-This application could be much bigger, but I decided to make some functionalities only for refrigerators, and later if I consider it necessary to extend all the logic to the other products as well. If I had done this, the application would have grown a lot and this was not my interest.

-Besides refrigerators, I also introduced other products, just for educational purposes, to help me interact with as much data as possible within the project.

-By making this application, I just wanted to code as much as possible, without immersing myself too much in the project and doing repetitive things.

-My interest was and is to learn as many new things as possible. 

## Description of the project interface

***Front side up***

-I created a fictitious company "Pegas", I created the company logo and in the upper front part, I added the possibility for users to search for the products they are interested in. Also there, user can register, log in and access the shopping cart.
Also, he can select the products he are interested in.
-If the user click on the "All refrigerators" button, all refrigerator brands are displayed, with a more complex pagination made in JavaScript, which I took from the net and adapted to my project.
-If he clicks on the "Sort refrigerators by criteria" button, the user will be introduced to a page, where in the front left side, he will be able to sort the brands of refrigerators according to some criteria. These brands have the existing stocks displayed on them, each separately.
In order to see all the products exposed for sale, I have created another type of pagination in this area, Bootstrap type.
-If he selects the other buttons, the user can find out some information about the other products, such as: description, stocks, prices.

[top](#description)

***Front left side***

-First of all, I have included some general information about the application products.
-Then I created several buttons arranged vertically, with all the brands in the application. For example, if a user presses the "Samsung" button, all the products from the Samsung range will appear, regardless of whether they are refrigerators, washing machines, televisions or telephones.
-Under these buttons, I created two posters with various information about the existing promotions and about the company.

[top](#description)

***The central part of the application***

-When the user enters the application for the first time, here he will see a carousel with all the products, which will successively walk before his eyes.
-Below, he will have access to all refrigerators that have sales promotions.
If the user is interested in a particular refrigerator, which is on sale, he will click on it and will reach the page where this product is located, where he will find its description, stock and price.

***Registration and Logging***

-The user can register and then log in as Admin or as a simple user with the name chosen during registration.
-If he logs in as Admin, he can add a new product, edit it to make the changes he considers necessary and delete it, if it is no longer up-to-date.
-If he logs in as an existing user, he can find out details about the products - description, stocks, prices and can buy the product if he is satisfied with it.
-If he does not log in, the user can only find out details about the products for sale.

[top](#description)

***Shopping cart***

-When the logged-in user purchases a product, he can add the products to the shopping cart, one by one, or delete them one by one or all at once.
-Also, in the shopping cart, once the user has bought one or more products, he has information about them, such as: the type of products purchased, the chosen brand, the products in stock at the time of purchase, the quantity of products ordered, the value per piece, the total value per type of purchased products, as well as the total value of all purchased products.
-The user has the possibility to return to the shopping cart at any time and review the information there. 
Also here he has two buttons "Continue shopping" and "Complete order."
-With the help of the first button, he returns to the application to continue shopping, and with the second button, after he has purchased everything he wants, he completes the order. 
Once it has done this, all ordered fridges are deducted from the existing stocks and this thing is clearly highlighted in the application.

[top](#description)

### Screenshots from project
-First page
https://i.postimg.cc/ZqYD4HyV/first-Page1.png
https://i.postimg.cc/KY9pzTPF/first-Page2.png

-Fridges
https://i.postimg.cc/L4gQ9nnK/fridges.png

-Televisions
https://i.postimg.cc/CxScs7JS/tvs.png

-Washing machines
https://i.postimg.cc/Twz9LJp8/washing-Machines.png

-Phones
https://i.postimg.cc/c4Nhdhpw/phones.png

-Login page
https://i.postimg.cc/V6C9804K/login-Page.png

-Shopping cart page - example with Paul user who buy some products
https://i.postimg.cc/7ZtSJnWB/shopping-Cart.png

-Error page
https://i.postimg.cc/BQqFhzWY/error-Page.png

[top](#description)

### Technologies used
-Programming language - Java

-Frameworks - Spring Boot, Bootstrap

-Database - MySQL

-I have also used - HTML5, CSS3, JavaScript
-Integrated Development Environment(IDE) - 
Intellij Community

-Where it was necessary, I processed images with the help of PosterMyWall, Microsoft Office Picture Manager, Paint, Photos applications.

[top](#description)

### Features
-The non-logged user can see the products displayed in the application.

-The logged-in user can see these products, as well as add them to the shopping cart and make orders.

-The Admin can add products to the application, edit them, make changes to them and delete them if they are no longer up-to-date.

[top](#description)

### System requirements

To run this application, make sure you have the following installed:
-Java Development Kit (JDK) - version 8 or more recent
[Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

-MySQL Server - for storing application data
[Download MySQL](https://www.mysql.com/downloads/)

-Integrated Development Environment(IDE) - 
it recommend Intellij IDEA, but you can use anything other IDE you prefer [Download Intellij IDEA](https://www.jetbrains.com/idea/download/)

[top](#description)

### Installation and running

-Make sure you have installed the Java Development Kit (JDK) and MySQL Server.

-Clone this repository using 'git clone 
https://github.com/mitnaru/eShop.git'

-Configure a MySQL database on your personal computer, called 'eShop'.

-Open the 'application.properties' file and complete the database connection settings with the specific information - username and password - of your personal database. Keep in mind that this information is sensitive and must be kept safe.

```
###Database configuration
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=username
spring.datasource.password=password
spring.datasource.url= jdbc:mysql://localhost:3306/eshop?createDatabaseIfNotExist=true
###JPA Configuration
spring.jpa.database=MYSQL
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```
-Start the application using './mvn spring-boot:run'

-Access the application in the browser at the address
[http:localhost:8080](http://localhost:8080)

### License
-"eShop" project is licensed under the MIT license. Please see the license document for more information.

[top](#description)
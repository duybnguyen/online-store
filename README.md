# Online Store
## Description of the Project
This is a console-based online store written in Java. It lets users browse a list of products, add them to a shopping cart, and check out. It’s a mini shopping system that demonstrates working with arrays, hash maps, file I/O, user input, and some basic object-oriented design in Java.


### Prerequisites

- IntelliJ IDEA: Ensure you have IntelliJ IDEA installed, which you can download from [here](https://www.jetbrains.com/idea/download/).
- Java SDK: Make sure Java SDK (version 17 or above) is installed and properly configured in IntelliJ.

### Running the Application in IntelliJ

Follow these steps to get your application running within IntelliJ IDEA:

1. Open IntelliJ IDEA.
2. Select "Open" and navigate to the directory where you cloned or downloaded the project.
3. After the project opens, wait for IntelliJ to index the files and set up the project.
4. Find the main class with the `public static void main(String[] args)` method.
5. Right-click on the file and select 'Run 'YourMainClassName.main()'' to start the application.

## Technologies Used

- Java 17
- File I/O (java.io package)
- Scanner
- File Writer
- java.time package

## Demo

<img src="../../workshops/OnlineStore/README-images/addingProduct.PNG" alt="deposit" width="400">
<img src="../../workshops/OnlineStore/README-images/showCart.PNG" alt="payment" width="400">
<img src="../../workshops/OnlineStore/README-images/checkout.PNG" alt="deposit" width="400">

## Interesting Piece of Code
Originally, the cart was an ArrayList<Product>, which made tracking quantities awkward, I had to loop through the list to count duplicates. Switching to a HashMap<Product, Integer> simplified everything: the key is the product, and the value is its count.

Adding an item is now just: cart.put(product, cart.getOrDefault(product, 0) + 1);


Displaying items and calculating totals is also easier, since you can directly access both the product and its count without extra loops.


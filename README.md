# pound
## _Java Library for operations with Pound before 1970_

This library release the 4 basic operations for English Pound before 1970:
1 Pound (p) = 20 Shellings (s)
1 Shelling (s) = 12 pennies (d)

For example: 12p 6s 10d stands for 12 pounds 6 shellings 10 pennies

## How use library
- Create a Pound: 
>Pound myPound = new Pound("12p 6s 10d");

It is possible create a Pound instance using this constructor:

>Pound myPound = new Pound(12, 6, 10); // three integers: pounds, shelings, pennies

- Display a price
>Pound myPound = new Pound("12p 6s 10d");
>System.out.println(myPound.toString());

- Operations
All operations return an OperationResult Object. You can display it using method toString. With method getPound() you can retrieve the Pound inside the operation.
Please view it.ventura.pound.oldfashion.Main.java for examples of use



## For running the program are needed:
- Java 11
- Maven (for running unit test)

## Compile and running Unit Test:
- mvn clean verify

## Running example
- cd target 
- java -classpath pound-1.0.0.jar it.ventura.pound.oldfashion.Main



/*
 	A2_1.java
 	Nicholas Fleischhauer
  	CIS 254
  	9/10/2018
  	
    This program utilizes an Invoice class, a TestInvoice class, the System.out.print()
    and System.out.println(). java.util.Scanner detects the user's input and captures that
    information for being used in Invoice instances. Every time we set ALL the values for
    our invoice instance, it will print the information of that instance. 
*/

/* 3.12 (Invoice Class) Create a class called Invoice that a hardware store
 might use to represent an invoice for an item sold at the store. An Invoice should include four
 pieces of information as instance variables-a part number (type String), a part description
 (type String), a quantity of the item being purchased (type int) and a price per item (double).
 Your class should have a constructor that initializes the four instance variables. Provide a set
 and a get method for each instance variable. In addition, provide a method named getInvoiceAmount
 that calculates the invoice amount (i.e., multiplies the quantity by the price per item), then
 returns the amount as a double value. If the quantity is not positive, it should be set to 0. 
 If the price per item is not positive, it should be set to 0.0. Add a main method to the class
 that demonstrates class Invoice's capabilities by reading in valuies from stdin and prints to
 stdout the complete state of the object each time the state of the object is changed. 

 Printing out each time the state of the object changes seems to be a bit of overkill.
 I'm currently using a single setter method as opposed to multiple setters with multiple prints
 of the entire object's state.

 The alternative would be to break up that single set method into multiple set methods
 for an Invoice. I'll pseudocode the other way of formatting this and mark it as OPTION B.
 */

import java.util.Scanner;

class TestInvoice {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    // I refactored my code to show a second instance to demonstrate that my class is properly
    // creating unique instance variables. I did it this way, so I don't have to duplicate
    // the user prompt logic. If this was independent of user input, I would have just done
    // something like..
    // Invoice invoiceOne = new Invoice(partNum, partDesc, qty, pricePer);
    // Invoice invoiceTwo = new Invoice(partNum, partDesc, qty, pricePer);
    Invoice invoiceOne = createInvoice(input);
    Invoice invoiceTwo = createInvoice(input);

    invoiceOne.printState();
    invoiceTwo.printState();

    input.close();
  }

  public static Invoice createInvoice(Scanner input) {
    String partNum;
    String partDesc;
    int qty;
    double pricePer;

    Invoice invoice = new Invoice();

    System.out.print("Enter the part number: ");
    partNum = input.next();
    // OPTION B
    // pseudocode: set partNum here by adding a partNum method to Invoice.
    // inside that method, it will use basic set logic and then 
    // invoke a print state prints that newly made change. Rinse and repeat this step
    // for all other setting performed. I preferred a modest increase in
    // left to right length of parameters typed out versus creating new lines of code.
    System.out.print("Enter the part description: ");
    partDesc = input.next();
    System.out.print("Enter the quantity of items: ");
    qty = input.nextInt();
    System.out.print("Enter the price per item with cents in decimals: ");
    pricePer = input.nextDouble();

    invoice.set(partNum, partDesc, qty, pricePer);
    return invoice;
  }
}

class Invoice {
  public String partNum;
  public String partDesc;
  public int qty = 0;
  double pricePer;

  public void printState() {
    System.out.println("============ Invoice ==============");
    System.out.println("Part number: " + this.partNum);
    System.out.println("Part description: " + this.partDesc);
    System.out.println("Amount ordered: " + this.qty);
    System.out.println("Price per: " + this.pricePer);
    this.getInvoiceAmount();
  }

  public void set(String partNum, String partDesc, int qty, double pricePer) {
    this.partNum = partNum;
    this.partDesc = partDesc;
    this.qty = qty > 0 ? qty : 0;
    this.pricePer = pricePer;
    this.printState();
  }

  public String getPartNum() {
    return this.partNum;
  }

  public String getPartDesc() {
    return this.partDesc;
  }

  public int getQty() {
    return this.qty;
  }

  public double getPricePer() {
    return this.pricePer;
  }

  public void getInvoiceAmount() {
    double invoiceAmount = this.qty * this.pricePer;
    System.out.println("Invoice amount: " + invoiceAmount);
    System.out.println("===================================");
  }
}

/*
Enter the part number: 4
Enter the part description: Hammer
Enter the quantity of items: 2
Enter the price per item with cents in decimals: 1.5
============ Invoice ==============
Part number: 4
Part description: Hammer
Amount ordered: 2
Price per: 1.5
Invoice amount: 3.0
===================================
                                    <---- End of first instance and start of second prompt
Enter the part number: 3
Enter the part description: Fork
Enter the quantity of items: 50
Enter the price per item with cents in decimals: 1.3
============ Invoice ==============
Part number: 3
Part description: Fork
Amount ordered: 50
Price per: 1.3
Invoice amount: 65.0
===================================
                                    <---- End of second instance and start printing both invoice's states
 
============ Invoice ==============
Part number: 4
Part description: Hammer
Amount ordered: 2
Price per: 1.5
Invoice amount: 3.0
===================================
 
============ Invoice ==============
Part number: 3
Part description: Fork
Amount ordered: 50
Price per: 1.3
Invoice amount: 65.0
===================================
*/

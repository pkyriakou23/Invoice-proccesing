# JAVA PROJECT

## Problem representation	
A project which requested to implement an application that will manage the invoicing of a company’s customer accounts based on the services their customers use.
First needs to hold information about the customer such as name, address, account number and account balance.
Second needs the company's service with name, description and price.
Third has to make and print the invoice of a service purchase so need the invoice number, date, services and the total amount
## Libraries added
I have added the ![javatuples] (https://www.javatuples.org/) library (version 1.2) to manage the 3 dimension list for services and invoices.

## Implementation details
From the JavaDoc!
### mainextra package
#### MAIN class:
It has the main method that gets from the user input about what they want to do. The user has 4 options, to create a new customer account, to get information about the customer's account, to purchase services and to get information about an invoice.

		
### mypackage package
#### App class: 
Take the input that the user gives to Main and get from the user more detail such as the account number to complete the command.
#### CustomerProfile class: 
Represent the customer's profile with the necessary information.
#### Invoices class: 
Represent an invoice with the necessary information

### Extra
Any method that has never been  used is about to easily add new features
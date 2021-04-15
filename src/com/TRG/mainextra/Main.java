package com.TRG.mainextra;

import com.TRG.mypackage.App;

import java.util.Scanner;

/**
 *  It has the main method that gets from the user input about what they want to do. The user has 4 options,
 *  to create a new customer account,
 *  to get information about the customer's account,
 *  to purchase services and
 *  to get information about an invoice.
 * @author Panayiotis Kyriacou
 */
public class Main {

    public static void main(String[] args) {
        App a=new App();
        String com="";
        String commands="Create account (crt) ,Show customers information,(info) Get Invoice (inv) , Get services(gts) , Exit (exit)";
        do
        {
            System.out.println('\n'+commands+'\n'+"What you want to do? (please write the command at())");
            com=new Scanner(System.in).nextLine();
            switch (com) {
                case "crt":
                    a.createCustomer();
                    break;
                case "info":
                    a.showInformation();
                    break;
                case "inv":
                    a.printInvoice(false,null);
                    break;
                case "gts":
                    a.getService();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("This is not an option");
            }


        }while(!com.equals("exit"));
    }

}

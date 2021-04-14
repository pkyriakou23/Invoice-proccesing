package com.TRG.mainextra;

import java.util.Scanner;

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

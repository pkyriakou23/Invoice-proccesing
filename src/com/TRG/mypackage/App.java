package com.TRG.mypackage;

import com.TRG.mypackage.CustomerProfile;

//library added
import org.javatuples.Triplet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class App {

    ArrayList<Triplet<String, String, Double>> companiesServices;
    ArrayList<CustomerProfile> cus;
    ArrayList<Triplet<String,Integer,Double>> cusServices;
    int accNum;

        public App()
        {

             companiesServices = fillServices();
            accNum =0;
            cus=new ArrayList<>();
        }
        public void createCustomer()
        {
            String name, add;

            do{
                System.out.println("Give a name:");
                name = new Scanner(System.in).nextLine();
            }
            while (name.equals(""));


            do {
                System.out.println("Give an address:");
                add = new Scanner(System.in).nextLine();
            }
            while (add.equals(""));
            CustomerProfile cus = new CustomerProfile((++accNum), name, add);
            System.out.println("HERE IS YOU INFORMATION: "+'\n'+cus.toString(false,false));
            this.cus.add(cus);
        }
        public void showInformation()
        {
            int num;
            System.out.println("Give the account number or -1 to exit:");
            num = new Scanner(System.in).nextInt();
            if(num==-1)
                return;

            for (CustomerProfile c : cus)
                if (num == c.getAccNumber()) {
                    System.out.println(  c.toString(true,false) );
                    return;
                }

            System.out.println("Couldn't find your account number ");
        }
         public void getService()
         {
             ArrayList<Triplet<String,Integer,Double>> cusServices = new ArrayList<>();
             int num;
             String s = "";

            do {
                boolean flag = false;
                System.out.println("give service you want or 'done' to get the invoice:");
                s = new Scanner(System.in).nextLine();
                for (Triplet<String, String, Double> service : companiesServices) {

                    if (s.equals(service.getValue0()))
                    {
                        flag = true;
                        System.out.println("give the quantity:");
                        int n = new Scanner(System.in).nextInt();

                        while (n < 1)
                        {
                            System.out.println("give an integer bigger than 0:");
                            n = new Scanner(System.in).nextInt();
                        }
                        Triplet<String, Integer, Double> temp = Triplet.with(service.getValue0(), n, n * service.getValue2());
                        cusServices.add(temp);

                    }

                }
                if (!flag && !s.equals("done"))
                    System.out.println("This is not a service");
            }
            while (!s.equals("done"));
            printInvoice(true,cusServices);
         }
       public void printInvoice(boolean makeNew, ArrayList<Triplet<String,Integer,Double>> cusServices)
        {
            int num;
            boolean flag=false;

            while(!flag) {

                    System.out.println("Give the account number or -1 to exit:");
                    num = new Scanner(System.in).nextInt();
                    if(num==-1)
                        return;

                 for (CustomerProfile c : cus)
                    if (num == c.getAccNumber()) {
                        if(makeNew)
                                c.makeInvoice(cusServices);

                        else
                        {
                            System.out.println("Give the invoice number:");
                            num = new Scanner(System.in).nextInt();
                            c.printInvoices(num);
                        }
                      flag=true;
                        break;
                    }
                 if (!flag)
                    System.out.println("Couldn't find your account number ");
            }

        }



    public static ArrayList<Triplet<String,String,Double>> fillServices()
    {
        ArrayList<Triplet<String,String,Double>> companiesServices = new ArrayList<>();
        Triplet<String, String, Double> service = Triplet.with("", "", 0.0);
        try {
            File file = new File("services.txt");
            Scanner read = new Scanner(file);

            while (read.hasNextLine())
            {
                service = service.setAt0(read.nextLine());
                service = service.setAt1(read.nextLine());
                service = service.setAt2(Double.parseDouble(read.nextLine()));
                companiesServices.add(service);
            }
            System.out.println(companiesServices);

            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return companiesServices;
    }
}





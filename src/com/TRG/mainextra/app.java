package com.TRG.mainextra;

import com.TRG.mypackage.CustomerProfile;
import com.TRG.mypackage.Services;
import org.javatuples.Triplet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class app {

    public static void main(String[] args) {

        ArrayList<Triplet<String,String,Double>> companiesServices = fillServices();
        CustomerProfile cus=new CustomerProfile(0001,"PANOS","NY CITY");
        ArrayList<Triplet<String,Integer,Double>> cusServices=new ArrayList<>();
        String s="";



       do {
           System.out.println("give service you want");
           s = new Scanner(System.in).nextLine();
           for (Triplet<String, String, Double> service : companiesServices) {
               if (s.equals(service.getValue0())) {
                   System.out.println("give the quantity");
                   int n=new Scanner(System.in).nextInt();
                  // String buffer=new Scanner(System.in).nextLine();
                   Triplet<String,Integer,Double> temp=Triplet.with(service.getValue0(),n,n*service.getValue2());
                   cusServices.add(temp);
               }
           }
       }
        while(!s.equals("done"));
        cus.makeInvoice(cusServices);
        System.out.println(cus.toString(true,true));


    }

    public static ArrayList<Triplet<String,String,Double>> fillServices()
    {
        ArrayList<Triplet<String,String,Double>> companiesServices = new ArrayList<>();
        Triplet<String, String, Double> service = Triplet.with("", "", 0.0);
        try {
            File file = new File("services.txt");
            Scanner read = new Scanner(file);
            for (int i = 0; i < 3; i++) {
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



package com.TRG.mypackage;

import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Services {
    ArrayList<Triplet<String,String,Double>> services;

    public Services()
    {
        services=new ArrayList<>();
    }
   public void addService()
   {

       Scanner s=new Scanner(System.in);
       System.out.println("Give services name,discription and price");
       for(int i=0;i<2;i++) {
           Triplet<String, String, Double> service = Triplet.with(s.nextLine(), s.nextLine(), s.nextDouble());
           s.nextLine();
           services.add(service);
       }
   }

   public boolean contains(String name)
   {
       Iterator<Triplet<String,String,Double>> iter= services.iterator();
       while(iter.hasNext())
           if(iter.next().contains(name))
               return true;
       return false;
   }

    /*
    private String name;
    private String description;
    private float price;

    public Services(String name,String description,float price)
    {

        this.name=name;
        this.description=description;
        this.price=price;
    }
*/
}

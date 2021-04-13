package com.TRG.mypackage;

import org.javatuples.Triplet;

import java.util.*;

public class CustomerProfile {
    private final int accNumber;
    private String name;
    private String address;
    private float accBalance;
    private Set<String> service;
    private List<Invoices> invoices;

    /**
     *
     * @param num   ->The account number
     * @param name
     * @param address
     */
    public CustomerProfile(int num,String name,String address)
    {
        accNumber=num;
        this.name=name;
        this.address=address;
        accBalance=0;
        service=new HashSet<>();
        invoices=new ArrayList<>();
    }


    public int getAccNumber() { return accNumber; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public float getAccBalance() { return accBalance; }

    public Set<String> getService() { return service; }

    public boolean setName(String name) {
        if(name == null ||name.equals(""))
            return false;
        this.name = name;
        return true;
    }
    public boolean setAddress(String address)
    {
        if(address == null ||address.equals(""))
          return false;
        this.address = address;
        return true;
    }

    /**
     *
     * @param services -> An ArrayList of Triplet<String,Integer,Double>
     *
     * </String,Integer,Double>     -> String is the name of the service
     *                              -> Integer is the quantity
     *                              -> Double is the final price(price*quantity)
     */
    public void makeInvoice(ArrayList<Triplet<String,Integer,Double>> services)
    {
        for (Triplet<String, Integer, Double> service : services) {
            this.service.add(service.getValue0());
        }
            Invoices invoice = new Invoices(this.invoices.size() + 1, services);
            invoices.add(invoice);

        accBalance = accBalance + invoices.get(invoices.size() - 1).getAmount();
    }


    public String toString(boolean services, boolean invoice) {
        String s= "accNumber=" + accNumber +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", accBalance=" + accBalance +'\n';

        if(services)
                s+="service=" + service +'\n';
        if(invoice)
                s+="invoices=" + invoices;
        return s;
    }
}

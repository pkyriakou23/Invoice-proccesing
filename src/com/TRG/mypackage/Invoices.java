package com.TRG.mypackage;

import org.javatuples.Triplet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *  Represent an invoice with the necessary information.
 *  Protected class and constructor
 *
 *  number -> invoice number
 *  date
 *  item -> items/services customer purchased
 *       -> which include Service name, Quantity, Amount(quantity*price)
 */
class Invoices {
    private  int number;
    private String date;
    ArrayList<Triplet<String,Integer,Double>> items;
    float amount;

    /**
     *
     *
     *
     * @param num
     * @param services -> String is the name of service
     *                 -> Integer is the quantity
     *                 -> Double is the price
     */
    protected Invoices(int num, ArrayList<Triplet<String,Integer,Double>> services)
    {
        amount=0;
        items= new ArrayList<>();
        number=num;
         date=(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
        for (Triplet<String, Integer, Double> service : services)
        {
            amount+=service.getValue2();
            items.add(service);
        }

    }

    public int getNumber() { return number; }
    public String getDate() { return date; }
    public ArrayList<Triplet<String,Integer,Double>> getItems() { return items; }
    public float getAmount() { return amount; }


    public String toString() {
        return "Invoice number=" + number +
                ", date=" + date + '\n' +
                "items=" + items
                + " amount=" + amount ;
    }

}

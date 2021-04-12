package com.TRG.mypackage;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Iterator;

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
        String date=(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
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
        return "number=" + number +
                ", date='" + date + '\n' +
                "items=" + items
                + " amount=" + amount ;
    }

}

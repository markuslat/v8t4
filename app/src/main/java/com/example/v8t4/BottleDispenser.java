package com.example.v8t4;

import android.content.Intent;
import android.widget.TextView;
import java.util.ArrayList;

public class BottleDispenser {

    private String name;
    private int bottles;
    private double money;

    String [] names = {"Pepsi Max", "Pepsi Max", "Coca-Cola Zero",
            "Coca-Cola Zero", "Fanta Zero"};
    double [] prices = {1.8, 2.2, 2.0, 2.5, 1.95};
    double [] sizes = {0.5, 1.5, 0.5, 1.5, 0.5};

    ArrayList<Bottle> bottles_array = new ArrayList<>();

    private static BottleDispenser bd = new BottleDispenser();

    private BottleDispenser() {
        bottles = 5;
        money = 0.0;

        for(int i = 0;i<bottles;i++) {
            Bottle bottle = new Bottle(names[i], sizes[i], prices[i]);
            bottles_array.add(i, bottle);
        }
    }

    public static BottleDispenser getInstance() {
        return bd;
    }

    public void addMoney(TextView text, int progress) {
        money = progress;
        text.setText("Klink! Added more money!");
    }

    public void buyBottle(TextView text) {

        if (bottles_array.get(0).getPrice()<money) {

            text.setText("KACHUNK! " +
                    bottles_array.get(0).getName() + " came out of the dispenser!");
            money -= bottles_array.get(0).getPrice();
            bottles_array.remove(0);
            bottles -= 1;
        }
        else {
            text.setText("Add money first!");
        }
    }


    public void returnMoney(TextView text) {

        text.setText("Klink klink. Money came out! "
                + "You got " + money + "€ back\n");
        money = 0;
    }
/*
    public void list() {
        for (int s = 0;s < bottles_array.size(); s++) {
            System.out.print(s+1 + ". Name: " + bottles_array.get(s).getName()
                    + "\n\tSize: " + bottles_array.get(s).getSize() +
                    "\tPrice: " + bottles_array.get(s).getPrice() + "\n");
        }
    }*/
}

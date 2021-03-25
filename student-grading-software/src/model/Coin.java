package model;

import java.util.ArrayList;
import java.util.Random;

public class Coin {

    private String status;
    private ArrayList<String> headtail = new ArrayList<String>(2);
    Random randomizer = new Random();

    public Coin(){
        setup();
        status = "head";
    }

    //Adds head and tail to the list of possibilities
    public void setup(){
        headtail.add("head");
        headtail.add("tail");
    }

    //MODIFIES: this
    //EFFECT: flips a coin and changes the status
    public void flip(){
        status = headtail.get(randomizer.nextInt(headtail.size()));
        System.out.println("Coin flipped");
    }

    //EFFECT: prints the status of the coin
    public String checkStatus(){
        System.out.println(status);
        return status;
    }
}

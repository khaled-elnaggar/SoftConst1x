package ui;

import model.Coin;

public class MainCoin {

    public static void main(String[] args) {
        Coin c = new Coin();
        for (int i = 0; i < 5; i++) {
            c.flip();
            c.checkStatus();
        }
    }
}
package main;

import model.Transaction;
import model.TransactionSummary;

import static model.TransactionType.ENTERTAINMENT;
import static model.TransactionType.FOOD;

public class main {
    public static void main(String[] args) {
        TransactionSummary ts = new TransactionSummary("Ada Lovelace");
        Transaction t1 = new Transaction("Movie", "May 1st", 10, ENTERTAINMENT);
        Transaction t2 = new Transaction("Restaurant", "May 11th", 20, FOOD);

        System.out.println(ts.averageTransactionCost());
    }
}

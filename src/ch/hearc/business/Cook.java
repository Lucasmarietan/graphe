package ch.hearc.business;

// Arc pour la cuisine
public class Cook extends Edge {

    public Cook(String name, Receipt ReceiptDest, int metric){
        super(name, ReceiptDest, metric);
    }
}

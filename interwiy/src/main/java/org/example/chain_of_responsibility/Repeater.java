package org.example.chain_of_responsibility;

public class Repeater extends Handler{
    private Order order;


    public void handle(Order order){
        if(this.order == order){
            System.out.println("All cars busy, repeat search...");
        }else {
            this.order = order;
        }
        super.handle(order);
    }
}

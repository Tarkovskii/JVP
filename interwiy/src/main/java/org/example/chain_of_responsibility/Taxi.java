package org.example.chain_of_responsibility;

public class Taxi extends Handler {
    private final String number;

    public Taxi(String number) {
        this.number = number;
    }

    public void handle(Order order){
        if(checkIsBusy()){
            System.out.printf("Car with number %s is busy, check next car\n", number);
            super.handle(order);
        }else
            System.out.printf("Car with number %s go for yoo order - %s\n", number,order.getId());
    }

    private boolean checkIsBusy(){
        return  Math.random() < 0.85;
    }
}

package org.example.chain_of_responsibility;

public abstract class Handler {
    private Handler next; //записывается ссылка на след обработчик

    public void handle(Order order){ // обработчик
        if(next !=null){
            next.handle(order);
        }
    }

    public Handler bind(Handler next){ // связывает текущий обработчик сос лед. обработчиком
        this.next = next;
        return next;
    }
}

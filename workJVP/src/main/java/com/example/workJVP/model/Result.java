package com.example.workJVP.model;

public class Result <T>{

    private Erorr err;
    private T result;

    public Result(T result, Erorr err) {
        this.err = err;
        this.result = result;
    }

    public Erorr getErr() {
        return err;
    }

    public T getResult(){
        return result;
    }


}

package org.example.decorator;

public class RedDecoratorShape extends ShapeDecorator{
    public RedDecoratorShape(Shape decoratorShape) {
        super(decoratorShape);
    }

    public void draw(){
        decoratorShape.draw();
        setRedBorder(decoratorShape);
    }

    private void setRedBorder(Shape decoratorShape){
        System.out.println("Message for RedDecoratorShape/ Now you hav read borders");
    }
}

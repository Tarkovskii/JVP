package org.example.command;

public class TurnOnLightCommand implements Command{
    Light theLight;

    public TurnOnLightCommand(Light theLight) {
        this.theLight = theLight;
    }

    @Override
    public void execute() {
        theLight.turnOn();
    }
}

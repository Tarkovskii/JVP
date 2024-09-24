package org.example.command;

public class TurnOffLightCommand implements Command{
    Light theLight;

    public TurnOffLightCommand(Light theLight) {
        this.theLight = theLight;
    }

    @Override
    public void execute() {
        theLight.turnOff();
    }
}

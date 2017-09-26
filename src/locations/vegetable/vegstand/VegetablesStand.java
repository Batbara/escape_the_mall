package locations.vegetable.vegstand;


public class VegetablesStand {
    private String description;
    private boolean pressedStatus;
    public VegetablesStand(){
        pressedStatus = false;
        description = "Стойка с овощами. Может, взять помидорку?";

    }

    public void setPressedStatus(boolean pressedStatus) {
        this.pressedStatus = pressedStatus;
    }

    public boolean isPressed(){
        return pressedStatus;
    }

    public String getDescription() {
        return description;
    }
}

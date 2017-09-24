package locations.vegetable.vegcloseup;

import locations.ClickableObject;

public class Lemonz implements ClickableObject{
    private String description;
    private boolean pressedStatus;
    public Lemonz(){
        description = "Пакет лимонов";
        pressedStatus = false;
    }
    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public boolean isPressed() {
        return pressedStatus;
    }

    @Override
    public void setPressedStatus(boolean pressedStatus) {
        this.pressedStatus = pressedStatus;
    }
}

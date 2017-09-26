package locations.thedoor.neardoor;

public class Keyhole {
    private boolean isLocked;
    public Keyhole(){
        isLocked = true;
    }
    public void unlock(){
        isLocked = false;
    }
    public boolean isLocked(){
        return isLocked;
    }
}

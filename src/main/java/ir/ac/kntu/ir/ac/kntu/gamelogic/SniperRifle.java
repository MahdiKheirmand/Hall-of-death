package ir.ac.kntu.ir.ac.kntu.gamelogic;

public class SniperRifle extends Gun {
    private boolean zoom;

    public SniperRifle(boolean zoom) {
        super("SniperRifle",60, 20);
        this.zoom = zoom;
        if(zoom){
            setZoomAccuracy();
        }
    }

    private void setZoomAccuracy() {
        setAccuracy(getAccuracy() + RandomHelper.nextInt(10)+5);
    }
}
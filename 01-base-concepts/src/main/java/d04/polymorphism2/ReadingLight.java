package d04.polymorphism2;

public class ReadingLight implements ElectricalDevice {

    private int lumen;

    public ReadingLight(int lumen) {
        this.lumen = lumen;
    }

    public int getLumen() {
        return lumen;
    }

    @Override
    public void powerOn() {
        // TODO
    }

}

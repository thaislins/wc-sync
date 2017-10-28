public class Person extends Thread {
    private boolean isWoman;
    private int duration;
    private WashroomManager washroomManager;

    public Person(boolean isWoman, int duration, String name, WashroomManager washroomManager) {
        super(name);
        this.isWoman = isWoman;
        this.duration = duration;
        this.washroomManager = washroomManager;
    }

    public boolean isWoman() {
        return isWoman;
    }

    public void setWoman(boolean woman) {
        isWoman = woman;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void run() {
        super.run();
        washroomManager.nextInLine(this);
    }
}

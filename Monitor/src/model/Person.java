package model;

/**
 * Class that simulates a person
 *
 * @author Elton Vieira, Thais Lins
 * @since 2017-10-25
 */
public class Person extends Thread {
    private boolean isWoman;
    private int duration;
    private WashroomManagerMonitor washroomManager;

    /**
     * Parameterized constructor
     *
     * @param isWoman         defines whether the person is a woman or not
     * @param duration        defines duration of time that a person may spend in a washroom
     * @param name            defines name of a person
     * @param washroomManager object used for managing washroom traffic
     */
    public Person(boolean isWoman, int duration, String name, WashroomManagerMonitor washroomManager) {
        super(name);
        this.isWoman = isWoman;
        this.duration = duration;
        this.washroomManager = washroomManager;
    }

    /**
     * Method that returns whether a person is a woman or not
     *
     * @return boolean value
     */
    public boolean isWoman() {
        return isWoman;
    }

    /**
     * Method that defines whether a person is a woman or not
     *
     * @param woman
     */
    public void setWoman(boolean woman) {
        isWoman = woman;
    }

    /**
     * Method that returns duration of time a person can spend inside a washroom
     *
     * @return integer that specifies duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Method that defines duration of time a person can spend inside a washroom
     *
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void run() {
        super.run();
        washroomManager.enter(this);
        try {
            washroomManager.useWashroom(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        washroomManager.exit(this);
    }
}

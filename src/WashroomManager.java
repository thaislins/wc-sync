public interface WashroomManager {
    void nextInLine(Person person);

    void useWashroom(Person person) throws InterruptedException;
}

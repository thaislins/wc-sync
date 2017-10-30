import java.util.Random;

public class PersonGenerator {
    public static Person generate(int maxDuration, WashroomManagerSemaphore manager) {
        boolean isWoman = new Random().nextBoolean();
        int duration = new Random().nextInt(maxDuration) + 1;
        int id = new Random().nextInt(100);
        String name = isWoman ? "woman_" + id : "man_" + id;
        return new Person(isWoman, duration, name, manager);
    }
}

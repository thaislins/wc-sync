import java.util.Scanner;

/**
 * Class that executes a simulation of washroom
 * synchronization with monitors
 *
 * @author Elton Vieira, Thais Lins
 * @since 2017-10-25
 */
public class MainMonitor {
    /**
     * Main method
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Define maximum washroom capacity: ");
        int maxCapacity = scanner.nextInt();

        while (maxCapacity <= 0) {
            System.out.print("Error! Define maximum washroom capacity: ");
            maxCapacity = scanner.nextInt();
        }

        System.out.print("Define how many people will use the washroom: ");
        int maxPeople = scanner.nextInt();
        System.out.print("Define the maximum amount of time a person can spend inside the washroom: ");
        int maxDuration = scanner.nextInt();

        WashroomManagerMonitor manager = new WashroomManagerMonitor(new Washroom(maxCapacity));

        for (int i = 0; i < maxPeople; i++) {
            Person person = PersonGenerator.generate(maxDuration, manager);
            person.start();
        }
    }
}

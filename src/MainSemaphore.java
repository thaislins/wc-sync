import java.util.ArrayList;

public class MainSemaphore {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        WashroomManager manager = new WashroomManagerSemaphore(new Washroom(3));
        people.add(new Person(true, 2, "Maria", manager));
        people.add(new Person(false, 1, "Jose", manager));
        people.add(new Person(true, 3, "Maria", manager));
        people.add(new Person(false, 4, "John", manager));

        for (Person p : people) {
            p.start();
        }
    }
}

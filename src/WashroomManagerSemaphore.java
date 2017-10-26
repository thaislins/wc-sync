import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class WashroomManagerSemaphore {

	private Semaphore semaphore;
	private ArrayList<Person> people;
	private Washroom washroom;

	public WashroomManagerSemaphore(ArrayList<Person> people, Washroom washroom) {
		this.semaphore = new Semaphore(washroom.getMaxCapacity(), true);
		this.people = people;
		this.washroom = washroom;
	}

}

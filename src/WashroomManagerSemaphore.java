import java.util.concurrent.Semaphore;

public class WashroomManagerSemaphore implements WashroomManager {
    private Semaphore semaphore;
    private Washroom washroom;

    public WashroomManagerSemaphore(Washroom washroom) {
        this.washroom = washroom;
        semaphore = new Semaphore(washroom.getMaxCapacity(), true);
    }

    @Override
    public void nextInLine(Person person) {
        try {
            semaphore.acquire();
            useWashroom(person);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    @Override
    public void useWashroom(Person person) throws InterruptedException {
        System.out.println("Entered");
        Thread.sleep(person.getDuration() * 1000);
        System.out.println("Exited");
    }
}

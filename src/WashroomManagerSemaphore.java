import java.util.concurrent.Semaphore;

public class WashroomManagerSemaphore {
    private Semaphore semaphore;
    private Washroom washroom;

    public WashroomManagerSemaphore(Washroom washroom) {
        this.washroom = washroom;
        semaphore = new Semaphore(washroom.getMaxCapacity(), true);
    }

    public void enter(Person person) {
        boolean entered = false;
        while (!entered) {
            try {
                semaphore.acquire();
                if (washroom.isEmpty() || (!washroom.isFull() && washroom.hasWoman() == person.isWoman())) {
                    entered = true;
                    useWashroom(person);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

    public void useWashroom(Person person) throws InterruptedException {
        washroom.addPerson(person);
        washroomLog(person.getName(), washroom.getPeopleInside().size(), true);
        Thread.sleep(person.getDuration() * 1000);
        washroom.removePerson(person);
        washroomLog(person.getName(), washroom.getPeopleInside().size(), false);
    }


    public synchronized void washroomLog(String name, int peopleInsideAmount, boolean entered) {
        System.out.println("---------------------------------------");
        System.out.println(name + (entered ? " entered" : " exited"));
        System.out.println("There are " + peopleInsideAmount + " people inside the washroom");
        System.out.println("---------------------------------------");
    }
}

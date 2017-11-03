package controller;

import model.Person;
import model.Washroom;

import java.util.concurrent.Semaphore;

/**
 * Class that manages traffic inside a washroom
 * with the use of semaphores
 *
 * @author Elton Vieira, Thais Lins
 * @since 2017-10-25
 */
public class WashroomManagerSemaphore {
    private Semaphore semaphore;
    private Semaphore mutex;
    private Washroom washroom;

    /**
     * Parameterized constructor
     *
     * @param washroom object that defines a washroom to be managed
     */
    public WashroomManagerSemaphore(Washroom washroom) {
        this.washroom = washroom;
        semaphore = new Semaphore(washroom.getMaxCapacity(), true);
        mutex = new Semaphore(1, true);
    }

    /**
     * Method that simulates the act of a person entering a washroom
     * with the use of semaphores
     *
     * @param person object that enters the washroom
     */
    public void enter(Person person) {
        boolean entered = false;
        while (!entered) {
            try {
                semaphore.acquire();
                if (washroom.isEmpty() || (!washroom.isEmpty() && !washroom.isFull() && washroom.hasWoman() == person.isWoman())) {
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

    /**
     * Method that adds and removes a person from a washroom
     *
     * @param person
     */
    public void useWashroom(Person person) throws InterruptedException {
        mutex.acquire();
        washroom.addPerson(person);
        washroomLog(person.getName(), washroom.getPeopleInside().size(), true);
        mutex.release();

        Thread.sleep(person.getDuration() * 1000);

        mutex.acquire();
        washroom.removePerson(person);
        washroomLog(person.getName(), washroom.getPeopleInside().size(), false);
        mutex.release();
    }


    /**
     * Method that lists actions and amount of people inside a washroom
     *
     * @param name               defines name of person using the washroom
     * @param peopleInsideAmount defines amount of people inside the washroom
     * @param entered            defines whether a person is entering or exiting a washroom
     */
    public void washroomLog(String name, int peopleInsideAmount, boolean entered) {
        System.out.println("---------------------------------------");
        System.out.println(name + (entered ? " entered" : " exited"));
        System.out.println("There are " + peopleInsideAmount + " people inside the washroom");
        System.out.println("---------------------------------------");
    }
}

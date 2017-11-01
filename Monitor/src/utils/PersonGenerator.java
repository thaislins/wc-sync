package utils;

import model.Person;

import java.util.Random;

/**
 * Class that generates a random model.Person
 *
 * @author Elton Vieira, Thais Lins
 * @since 2017-10-25
 */
public class PersonGenerator {
    /**
     * Static method that generates a random person
     *
     * @param maxDuration maximum time a person is allowed to stay inside a washroom
     * @param manager     object that manages traffic inside a washroom
     * @return object of class model.Person
     */
    public static Person generate(int maxDuration, WashroomManagerMonitor manager) {
        boolean isWoman = new Random().nextBoolean();
        int duration = new Random().nextInt(maxDuration) + 1;
        int id = new Random().nextInt(100);
        String name = isWoman ? "woman_" + id : "man_" + id;
        return new Person(isWoman, duration, name, manager);
    }
}

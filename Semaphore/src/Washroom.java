import java.util.ArrayList;

/**
 * Class that simulates a washroom
 *
 * @author Elton Vieira, Thais Lins
 * @since 2017-10-25
 */
public class Washroom {
    private ArrayList<Person> peopleInside;
    private int maxCapacity;

    /**
     * Parameterized constructor
     *
     * @param maxCapacity defines maximum capacity of people allowed in a washroom
     */
    public Washroom(int maxCapacity) {
        peopleInside = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    /**
     * Method that returns array of people inside the washroom
     *
     * @return arraylist that specifies people that are inside the washroom
     */
    public ArrayList<Person> getPeopleInside() {
        return peopleInside;
    }

    /**
     * Method that defines array of people inside the washroom
     *
     * @param peopleInside
     */
    public void setPeopleInside(ArrayList<Person> peopleInside) {
        this.peopleInside = peopleInside;
    }

    /**
     * Method that returns maximum capacity of people allowed inside the washroom
     *
     * @return integer that specifies maximum capacity of people allowed inside the washroom
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Method that defines maximum capacity of people allowed inside the washroom
     *
     * @param maxCapacity
     */
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * Method that adds a Person object to peopleInside
     *
     * @param person
     */
    public void addPerson(Person person) {
        peopleInside.add(person);
    }

    /**
     * Method that removes a Person object from peopleInside
     *
     * @param person
     */
    public void removePerson(Person person) {
        peopleInside.remove(person);
    }

    /**
     * Method that verifies whether washroom is full
     *
     * @return boolean that indicates whether washroom is full
     */
    public boolean isFull() {
        return peopleInside.size() == maxCapacity;
    }

    /**
     * Method that verifies whether washroom is empty
     *
     * @return boolean that indicates whether washroom is empty
     */
    public boolean isEmpty() {
        return peopleInside.size() == 0;
    }

    /**
     * Method that verifies whether washroom has a woman inside
     *
     * @return boolean that indicates whether washroom has a woman inside
     */
    public boolean hasWoman() {
        return peopleInside.get(0).isWoman();
    }
}

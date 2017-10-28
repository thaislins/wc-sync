import java.util.ArrayList;

public class Washroom {
    private ArrayList<Person> peopleInside;
    private int maxCapacity;

    public Washroom(int maxCapacity) {
        peopleInside = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    public ArrayList<Person> getPeopleInside() {
        return peopleInside;
    }

    public void setPeopleInside(ArrayList<Person> peopleInside) {
        this.peopleInside = peopleInside;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void addPeople(Person person) {
        peopleInside.add(person);
    }

    public boolean isFull() {
        return peopleInside.size() == maxCapacity;
    }

    public boolean isEmpty() {
        return peopleInside.size() == 0;
    }
}

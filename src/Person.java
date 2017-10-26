
public class Person {

	private boolean isWoman;
	private int duration;

	public Person(boolean isWoman, int duration) {
		this.isWoman = isWoman;
		this.duration = duration;
	}

	public boolean isWoman() {
		return isWoman;
	}

	public void setWoman(boolean isWoman) {
		this.isWoman = isWoman;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}

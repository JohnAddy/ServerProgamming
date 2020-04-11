
public class Mammal {

	protected double weight;

	protected void breeth() {
		System.out.println("I am breething");
	}

	protected double getWeight() { // protected as we want only subclass to have access to this!!
		// We could have set these to public also if that would have been our aim!!
		return weight;
	}

	protected void setWeight(double weight) { // protected as we want only subclass to have access to this!!
		// We could have set these to public also if that would have been our aim!!
		this.weight = weight;
	}

	public void eat() {
		System.out.println("I want to eat lunch!");
	}

}

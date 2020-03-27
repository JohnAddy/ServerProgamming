
public class Human extends Mammal {
	private String sosnumber;

	public Human() {
		this.sosnumber = "------A----";
	}

	public Human(String sosnumber) {

		if (sosnumber.matches("\\d{6}A\\d{4}")) {
			this.sosnumber = sosnumber;
		}

		weight = 4;

	}

	public void eat() {
		System.out.println("I hate dinner, so I waited for lunch!");
	}

	public void speak() {
		System.out.println("I am speaking now!");
	}

	public String getSosnumber() {
		return sosnumber;
	}

	public void setSosnumber(String sosnumber) {
		if (sosnumber.matches("\\d{6}A\\d{4}")) {
			this.sosnumber = sosnumber;
		}
	}

}

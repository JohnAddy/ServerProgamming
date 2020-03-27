
public class RunClassGarage {
	
	public static void main(String[] args) {
		Garage myGarage = new Garage();
		System.out.println("my Garage is " + myGarage.getLength());
		System.out.println("my Garage is " + myGarage.getWidth());
		System.out.println("my Garage is " + myGarage.getArea());
		System.out.println("my Garage is " + myGarage.getTotal_tax());
		
		Garage myGarage2 = new Garage(4,3);
		System.out.println("my Garage2 is " + myGarage2.getLength());
		System.out.println("my Garage2 is " + myGarage2.getWidth());
		System.out.println("my Garage2 is " + myGarage2.getArea());
		System.out.println("my Garage2 is " + myGarage2.getTotal_tax());
		
		
		myGarage.print();
		myGarage2.print();
	}

}


public class RunClass {
	public static void main(String[] args) {
		Human johnny = new Human();
		Human lisa = new Human("111111A2222"); // Correct sos.number format
		Human lisa_no = new Human("1A2"); // Incorrect sos.number format

	
		
		
		//Tests for nobody
        System.out.println("johnny's weight:" + johnny.getWeight());
        System.out.println("lisa's sos.number:" + johnny.getSosnumber());
        johnny.breeth();
        johnny.setSosnumber("101010A1234");
        System.out.println("nobody's sos.number:" + johnny.getSosnumber());
        johnny.setWeight(5);
        System.out.println("nobody's weight:" + johnny.getWeight());
        johnny.speak();
        johnny.eat();
       
        // Now you should try writing the remaining tests yourself
	}
}

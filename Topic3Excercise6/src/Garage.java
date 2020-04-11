
public class Garage {
	private double width;
	private double length;
	private double area;
	private double tax;
	private double total_tax;

	public Garage() {
		this.width = 10;
		this.length = 20;
		this.area = width * length;
		this.total_tax = area * tax;
	}

	public Garage(double w, double l) {
		this.width = w;
		this.length = l;
		this.area = w * l;
		this.total_tax = area * tax;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (true) {
			this.width = width;
		}
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		if (true) {
			this.length = length;
		}
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		if (true) {
			this.area = area;
		}
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTotal_tax() {
		return total_tax;
	}

	public void setTotal_tax(double total_tax) {
		if (true) {
			this.total_tax = total_tax;
		}
	}

	public void print() {
		System.out.println("width :" + width);
		System.out.println("length :" + length);
		System.out.println("area :" + area);
		System.out.println("tax :" + total_tax);
	}

}

package data;

public class Laptop {
	private String brand;
	private float price;
	private int weight;
	
	public Laptop(String string, int i, int j) {
		this.brand=string;
		this.price=i;
		this.weight=j;
	}
	public Laptop() {
		// TODO Auto-generated constructor stub
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setPrice(String price) {
		try {
			this.price=Float.parseFloat(price);
		}
		catch(NumberFormatException e) {
			
		}
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setWeight(String weight) {
		try {
			this.weight=Integer.parseInt(weight);
		}
		catch(NumberFormatException e) {
			
		}
	}
	
	public String tostring() {
		return "Brand:"+brand+" price: "+price+" weight: "+weight;
	}

}

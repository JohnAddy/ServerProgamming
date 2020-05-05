package app;

public class Laptop {
	private int id;
	private String brand;
	private float price ;
	private float weight;
	
	public Laptop(int i, String string, float f, int j) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laptop(int id,String brand) {
		super();
		this.brand = brand;
		this.id = id;
	}

	public Laptop(int id,String brand,float weight,float price) {
		super();
		this.price = price;
		this.weight = weight;
		this.id = id;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getbrand() {
		return brand;
	}

	public void setbrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", brand=" + brand + ", price=" + price + ", weight=" + weight + "]";
	}


	
	
	
	
	

}

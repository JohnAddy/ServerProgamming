package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prey {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String breed;
	private float weight;
	
	public Prey() {
		super();
	}
	public Prey(String breed, float weight) {
		super();
		this.breed = breed;
		this.weight = weight;
	}
	public Prey(int id, String breed, float weight) {
		super();
		this.id = id;
		this.breed = breed;
		this.weight = weight;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String toString() {
		return id+": "+breed+" "+weight;
	}
}

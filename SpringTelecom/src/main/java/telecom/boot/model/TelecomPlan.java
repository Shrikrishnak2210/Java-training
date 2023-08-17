package telecom.boot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TelecomPlan {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String planName;
	private double price;
	private long dataLimit;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getDataLimit() {
		return dataLimit;
	}

	public void setDataLimit(long dataLimit) {
		this.dataLimit = dataLimit;
	}

}

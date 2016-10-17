package ws2.java2.entity;

public class Bike extends Vehicle {
	int tire;
	
	public Bike() {
		// TODO Auto-generated constructor stub
	}

	public Bike(String modelName, int maxSpeed, int numberLimit, int tire) {
		super(modelName, maxSpeed, numberLimit, true);
		this.tire = tire;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		super.displayInfo();
		System.out.println("Å¸ÀÌ¾î °¹¼ö : "+tire);
	}

	public int getTire() {
		return tire;
	}

	public void setTire(int tire) {
		this.tire = tire;
	}
	
	
}

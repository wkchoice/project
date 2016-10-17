package ws2.java2.entity;

public class Airplane extends Vehicle {
//	private String modelName;
//	private int maxSpeed;
//	private int numberLimit;
//	private boolean available;
	private int numOfEngine;
	
	public Airplane() {}
	
	public Airplane(String modelName, int maxSpeed, int numberLimit, int numOfEngine) {
//		this.modelName = modelName;
//		this.maxSpeed = maxSpeed;
//		this.numberLimit = numberLimit;
		super(modelName, maxSpeed, numberLimit, true);
		this.numOfEngine = numOfEngine;
	}

//	public String getModelName() {
//		return modelName;
//	}
//
//	public void setModelName(String modelName) {
//		this.modelName = modelName;
//	}
//
//	public int getMaxSpeed() {
//		return maxSpeed;
//	}
//
//	public void setMaxSpeed(int maxSpeed) {
//		this.maxSpeed = maxSpeed;
//	}
//
//	public int getNumberLimit() {
//		return numberLimit;
//	}
//
//	public void setNumberLimit(int numberLimit) {
//		this.numberLimit = numberLimit;
//	}

	public int getNumOfEngine() {
		return numOfEngine;
	}

	public void setNumOfEngine(int numOfEngine) {
		this.numOfEngine = numOfEngine;
	}

//	public boolean isAvailable() {
//		return available;
//	}
//
//	public void setAvailable(boolean available) {
//		this.available = available;
//	}
	
	public void displayInfo() {
//		System.out.println("-------------------------------------------");
//		System.out.println(" 모 델 명 : " + modelName);
//		System.out.println(" 최고속도 : " + maxSpeed + "km/h");
//		System.out.println(" 최대정원 : " + numberLimit + "명");
		super.displayInfo();
		System.out.println(" 엔진개수 : " + numOfEngine + "개");
	}
}

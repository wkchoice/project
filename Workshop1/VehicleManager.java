package ws2.java2.controller;

import ws2.java2.entity.*;

public class VehicleManager {
	Airplane[] airplaneArr;
	Car[] carArr;
	Ship[] shipArr;
	
	public VehicleManager() {
		airplaneArr = new Airplane[2];
		carArr = new Car[3];
		shipArr = new Ship[2];
		
		airplaneArr[0] = new Airplane("보잉747", 1300, 300, 4);
		airplaneArr[1] = new Airplane("F-16", 1600, 1, 1);
		
		carArr[0] = new Car("소나타3", 180, 5, 10);
		carArr[1] = new Car("티코", 130, 4, 15);
		carArr[2] = new Car("스타렉스", 150, 10, 11);
		
		shipArr[0] = new Ship("크루즈2", 30, 400, 35000);
		shipArr[1] = new Ship("노틸러스", 25, 150, 15000);
	}
	
	public void displayVehicles(String title) {
		System.out.println(title);
		
		for (int inx = 0 ; inx < airplaneArr.length ; inx++) {
			airplaneArr[inx].displayInfo();
			airplaneArr[inx].setAvailable(true);
		}
		
		for (int inx = 0 ; inx < carArr.length ; inx++) {
			carArr[inx].displayInfo();
			carArr[inx].setAvailable(true);
		}
		
		for (int inx = 0 ; inx < shipArr.length ; inx++) {
			shipArr[inx].displayInfo();
			shipArr[inx].setAvailable(true);
		}
		
		System.out.println();
	}
}


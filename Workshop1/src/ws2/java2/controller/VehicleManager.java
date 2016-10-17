package ws2.java2.controller;

import ws2.java2.entity.*;

public class VehicleManager {
	Airplane[] airplaneArr;
	Car[] carArr;
	Ship[] shipArr;
	Vehicle[] vehicle;
	Bike[] bikeArr;
	
	public VehicleManager() {
		airplaneArr = new Airplane[2];
		carArr = new Car[3];
		shipArr = new Ship[2];
		bikeArr = new Bike[2];
		vehicle = new Vehicle[9];
		
		int i=0;
		vehicle[i++] = airplaneArr[0] = new Airplane("����747", 1300, 300, 4);
		vehicle[i++] = airplaneArr[1] = new Airplane("F-16", 1600, 1, 1);
		
		vehicle[i++] = shipArr[0] = new Ship("ũ����2", 30, 400, 35000);
		vehicle[i++] = shipArr[1] = new Ship("��ƿ����", 25, 150, 15000);
		
		vehicle[i++] = carArr[0] = new Car("�ҳ�Ÿ3", 180, 5, 10);
		vehicle[i++] = carArr[1] = new Car("Ƽ��", 130, 4, 15);
		vehicle[i++] = carArr[2] = new Car("��Ÿ����", 150, 10, 11);
		
		vehicle[i++] = bikeArr[0] = new Bike("��õ�� ������", 50, 2, 2);
		vehicle[i++] = bikeArr[1] = new Bike("�޸��� ����ũ", 45, 3, 3);
		
	}
	
	public void displayVehicles(String title) {
		System.out.println(title);
		
//		for (int i = 0 ; i < airplaneArr.length ; i++) {
//			airplaneArr[i].displayInfo();
//			airplaneArr[i].setAvailable(true);
//		}
//		
//		for (int i = 0 ; i < carArr.length ; i++) {
//			carArr[i].displayInfo();
//			carArr[i].setAvailable(true);
//		}
//		
//		for (int i = 0 ; i < shipArr.length ; i++) {
//			shipArr[i].displayInfo();
//			shipArr[i].setAvailable(true);
//		}
		
		for (int i = 0 ; i < vehicle.length ; i++) {
			vehicle[i].displayInfo();
			vehicle[i].setAvailable(true);
		}
		
//		System.out.println();
		System.out.printf("---wkchoi----- -------------------\n");
	}

	public void sortByModelName() {
		// TODO Auto-generated method stub
				
	}
}


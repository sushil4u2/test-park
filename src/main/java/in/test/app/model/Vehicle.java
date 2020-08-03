package in.test.app.model;

import in.test.app.parking.enums.VehicleType;

public abstract class Vehicle {
	private String vehicleNumber;
	private final VehicleType type;

	public Vehicle(VehicleType type) {
		this.type = type;
	}
	public VehicleType getType() {
		return type;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
}
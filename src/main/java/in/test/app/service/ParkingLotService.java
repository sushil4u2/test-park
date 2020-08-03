package in.test.app.service;

import org.springframework.stereotype.Service;

import in.test.app.model.BikeSpot;
import in.test.app.model.CompactSpot;
import in.test.app.model.LargeSpot;
import in.test.app.model.ParkingLot;
import in.test.app.model.ParkingSpot;
import in.test.app.model.Receipt;
import in.test.app.model.Vehicle;
import in.test.app.parking.enums.ParkingSpotType;
import in.test.app.parking.enums.VehicleType;
import in.test.app.parking.exceptions.ParkingFullException;

@Service
public class ParkingLotService {

	public ParkingSpot getNewParkingSpot(Vehicle vehicle, ParkingLot lot) throws ParkingFullException {
		if (this.isFull(vehicle.getType(), lot)) {
			throw new ParkingFullException("Parking is full");
		}
		ParkingSpot parkingSpot = null;
		if(vehicle.getType().equals(VehicleType.HATCHBACK)) {
			parkingSpot = new ParkingSpot(ParkingSpotType.COMPACT);
			lot.setCurrentCompactSpotCount(lot.getCurrentCompactSpotCount()-1);
		}
		else if(vehicle.getType().equals(VehicleType.SUV)) {
			parkingSpot = new ParkingSpot(ParkingSpotType.LARGE);
			lot.setCurrentLargeSpotCount(lot.getCurrentLargeSpotCount()-1);
			
		}
		else if(vehicle.getType().equals(VehicleType.BIKE)) {
			parkingSpot = new ParkingSpot(ParkingSpotType.BIKE);
			lot.setCurrentBikeSpotCount(lot.getCurrentBikeSpotCount()-1);
		}
		
		parkingSpot.setVehicle(vehicle);
		return parkingSpot;
	}
	
	public boolean isFull(VehicleType type, ParkingLot lot) {
		if (VehicleType.SUV.equals(type)) {
			return lot.getCurrentLargeSpotCount() >= lot.getLargeSpotCapacity();
		}else if (VehicleType.HATCHBACK.equals(type)) {
			return lot.getCurrentCompactSpotCount() >= lot.getCompactSpotCapacity();
		}else if (VehicleType.BIKE.equals(type)) {
			return lot.getCurrentBikeSpotCount() >= lot.getBikeSpotCapacity();
		}
		return true;
	}
	
	public Receipt exitParking(ParkingSpot spot) {
		Receipt receipt = new Receipt();
		switch (spot.getType()) {
		case COMPACT:{
			spot.getParkingLot().setCurrentCompactSpotCount(spot.getParkingLot().getCurrentCompactSpotCount()+1);
			//calculate fare
			break;
		}
		case LARGE:{
			spot.getParkingLot().setCurrentLargeSpotCount(spot.getParkingLot().getCurrentLargeSpotCount()+1);
			//calculate fare
			break;
		}
		case BIKE:{
			spot.getParkingLot().setCurrentBikeSpotCount(spot.getParkingLot().getCurrentBikeSpotCount()+1);
			//calculate fare
			break;
		}
		default:
			System.out.println("Incorrect Parking Spot");
		}
		
		return receipt;
	}
}

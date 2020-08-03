package in.test.app.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.Data;

@Data
public class ParkingLot {
	
	private Long id;
	private int compactSpotCapacity;
	private int largeSpotCapacity;
	private int bikeSpotCapacity;
	
	private int currentCompactSpotCount;
	private int currentLargeSpotCount;
	private int currentBikeSpotCount;
	
	public ParkingLot(Long id, int compactSpotCapacity, int largeSpotCapacity, int bikeSpotCapacity) {
		this.id = id;
		this.compactSpotCapacity = compactSpotCapacity;
		this.largeSpotCapacity = largeSpotCapacity;
		this.bikeSpotCapacity = bikeSpotCapacity;
	}
	
	private HashMap<String, CompactSpot> compactSpots;
	private HashMap<String, LargeSpot> largeSpots;
	private HashMap<String, BikeSpot> bikeSpots;
	
	public void addParkingSpot(ParkingSpot spot) {
		switch (spot.getType()) {
		case COMPACT:{
			compactSpots.put(spot.getNumber(), (CompactSpot) spot);
			currentCompactSpotCount++;
			break;
		}
		case LARGE:{
			largeSpots.put(spot.getNumber(), (LargeSpot) spot);
			currentLargeSpotCount++;
			break;
		}
		case BIKE:{
			bikeSpots.put(spot.getNumber(), (BikeSpot) spot);
			currentBikeSpotCount++;
			break;
		}
		default:
			System.out.println("Incorrect Parking Spot");
		}
	}
	
}

package in.test.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import in.test.app.model.ParkingLot;

@Component
public class ParkingLotManager {
	
	Map<Long, ParkingLot> lots = new HashMap<Long, ParkingLot>();
	
	public ParkingLotManager() {
		this.lots.put(100L, new ParkingLot(100L, 10, 5, 20));
		this.lots.put(100L, new ParkingLot(101L, 20, 15, 10));
		this.lots.put(100L, new ParkingLot(101L, 10, 20, 30));
	}
	
	public void addParkingLot(ParkingLot lot) {
		this.lots.put(lot.getId(), lot);
	}
	
	public ParkingLot getParkingLot(Long id) {
		return lots.get(id);
	}

}

package in.test.app.model;

import lombok.Data;

@Data
public class ParkingRequest {

	Vehicle vehicle;
	Long parkingLotId;
	
}

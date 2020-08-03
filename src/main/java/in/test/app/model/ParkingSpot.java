package in.test.app.model;

import java.util.Date;

import in.test.app.parking.enums.ParkingSpotType;
import lombok.Data;

@Data
public class ParkingSpot {

	  private String number;
	  private ParkingLot parkingLot;
	  private boolean free;
	  private Vehicle vehicle;
	  private final ParkingSpotType type;
	  private Date bookedTime;

	  public ParkingSpot(ParkingSpotType type) {
	    this.type = type;
	    this.free = false;
	  }
}

package in.test.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.test.app.model.BookingResponse;
import in.test.app.model.ParkingLot;
import in.test.app.model.ParkingRequest;
import in.test.app.model.ParkingSpot;
import in.test.app.model.Receipt;
import in.test.app.service.ParkingLotManager;
import in.test.app.service.ParkingLotService;
import in.test.app.util.ApiResponse;

@RestController
@RequestMapping("/parking")
public class PakingController {

	@Autowired
	ParkingLotManager parkingLotmanager;
	@Autowired
	ParkingLotService parkingLotService;
	
	@PostMapping("/park")
	public ApiResponse<ParkingSpot> parkVehicle(@RequestBody ParkingRequest parkingRequest){
		ParkingLot lot = parkingLotmanager.getParkingLot(parkingRequest.getParkingLotId());
		return new ApiResponse<>(parkingLotService.getNewParkingSpot(parkingRequest.getVehicle(), lot), HttpStatus.OK.value());
	}
	
	@PostMapping("/exit")
	public ApiResponse<Receipt> exitParking(ParkingSpot spot){
		return new ApiResponse<>(parkingLotService.exitParking(spot), HttpStatus.OK.value());
	}
	
	@PostMapping("/history")
	public ApiResponse<BookingResponse> getParkinghistory(){
		
		return null;
	}
}

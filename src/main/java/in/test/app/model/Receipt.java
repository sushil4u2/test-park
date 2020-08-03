package in.test.app.model;

import java.util.Date;

import lombok.Data;

@Data
public class Receipt {

	Date intime;
	Date outTime;
	double fare;
}

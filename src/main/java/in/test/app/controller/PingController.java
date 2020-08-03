package in.test.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.test.app.util.ApiResponse;
import in.test.app.util.Constants;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = Constants.TEST)
@Slf4j
public class PingController {

	@GetMapping(path = "/ping")
	ApiResponse<String> getUser() {
		return new ApiResponse<>("pong", HttpStatus.OK.value());
	}
}

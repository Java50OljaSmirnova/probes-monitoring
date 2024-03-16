package telran.probes.controller;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import telran.probes.UrlConstants;
import telran.probes.dto.*;
import telran.probes.service.AdminConsoleService;

@RequiredArgsConstructor
@RequestMapping("sensors")
@RestController
@Slf4j
public class AdminConsoleController {
	final AdminConsoleService adminConsoleService;
	
	@PostMapping(UrlConstants.RANGE)
	SensorRange addSensorRange(@RequestBody @Valid SensorRange sensorRange) {
		log.debug("adding received sensor range: {}", sensorRange);
		return adminConsoleService.addSensorRange(sensorRange);
	}
	
	@PostMapping(UrlConstants.EMAILS)
	SensorEmails addSensorEmails(@RequestBody @Valid SensorEmails sensorEmails) {
		log.debug("adding received sensor emails: {}", sensorEmails);
		return adminConsoleService.addSensorEmails(sensorEmails);
	}
	
	@PutMapping(UrlConstants.RANGE)
	SensorRange updateSensorRange(@RequestBody @Valid SensorRange sensorRange) {
		log.debug("updating received sensor range: {}", sensorRange);
		return adminConsoleService.updateSensorRange(sensorRange);
	}
	
	@PutMapping(UrlConstants.EMAILS)
	SensorEmails updateSensorEmails(@RequestBody @Valid SensorEmails sensorEmails) {
		log.debug("updating received sensor emails: {}", sensorEmails);
		return adminConsoleService.updateSensorEmails(sensorEmails);
	}

}

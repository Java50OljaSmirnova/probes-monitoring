package telran.probes.controller;

import static telran.probes.messages.ValidationErrorMessages.*;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import telran.probes.UrlConstants;
import telran.probes.service.SensorEmailsService;

@RequiredArgsConstructor
@RestController
@Slf4j
public class SensorEmailsController {
	final SensorEmailsService sensorEmails;
	
	@GetMapping(UrlConstants.SENSOR_EMAILS + "{" + UrlConstants.SENSOR_ID + "}")
	String[] getSensorEmails(@PathVariable @NotNull(message = MISSING_SENSOR_ID) long sensorId) {
		log.debug("controller: get sensor emails with id {}", sensorId);
		return sensorEmails.getSensorEmails(sensorId);
	}

}

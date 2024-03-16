package telran.probes.controller;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import telran.probes.UrlConstants;
import telran.probes.dto.Range;
import telran.probes.service.SensorRangeService;

import static telran.probes.messages.ValidationErrorMessages.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SensorRangeController {
	final SensorRangeService sensorRange;
	
	@GetMapping(UrlConstants.SENSOR_RANGE + "{" + UrlConstants.SENSOR_ID + "}")
	Range getSensorRange(@PathVariable @NotNull(message = MISSING_SENSOR_ID) long sensorId) {
		log.debug("controller: get sensor range with id {}", sensorId);
		return sensorRange.getSensorRange(sensorId);
	}

}

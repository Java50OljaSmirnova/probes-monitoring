package telran.probes.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import telran.exceptions.SensorNotFoundException;
import telran.probes.dto.Range;
import telran.probes.model.SensorRangeDoc;
import telran.probes.repo.SensorRangeRepo;

@Service
@RequiredArgsConstructor
@Slf4j
public class SensorRangeServiceImpl implements SensorRangeService {
	final SensorRangeRepo sensorRangeRepo;

	@Override
	public Range getSensorRange(long sensorId) {
		SensorRangeDoc sensorRangeDoc = sensorRangeRepo.findById(sensorId)
				.orElseThrow(() -> new SensorNotFoundException());
		Range range = sensorRangeDoc.getRange();
		log.debug("found sensor range {} by id {}", range, sensorId);
		return range;

	}

}

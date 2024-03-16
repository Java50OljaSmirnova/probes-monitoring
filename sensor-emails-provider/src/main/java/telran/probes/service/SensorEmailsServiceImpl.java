package telran.probes.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import telran.exceptions.SensorNotFoundException;
import telran.probes.model.SensorEmailsDoc;
import telran.probes.repo.SensorEmailsRepo;

@Service
@RequiredArgsConstructor
@Slf4j
public class SensorEmailsServiceImpl implements SensorEmailsService {
	final SensorEmailsRepo sensorEmailsRepo;

	@Override
	public String[] getSensorEmails(long sensorId) {
		SensorEmailsDoc sensorEmails = sensorEmailsRepo.findById(sensorId)
				.orElseThrow(() -> new SensorNotFoundException());
		String[] emails = sensorEmails.getEmails();
		log.debug("found sensor emails {} by id {}", emails, sensorId);
		return emails;
	}

}

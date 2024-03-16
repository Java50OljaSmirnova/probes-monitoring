package telran.probes;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import telran.probes.dto.SensorEmails;
import telran.probes.model.SensorEmailsDoc;
import telran.probes.repo.SensorEmailsRepo;

@Component
@RequiredArgsConstructor
public class TestDb {
	final SensorEmailsRepo sensorEmailsRepo;

	// ID's
	static final long ID1 = 123;
	static final long ID2 = 124;
	static final long ID_NOT_EXIST = 1000;
	// Email's
	static final String EMAIL_1 = "email1@gmail.com";
	static final String EMAIL_2 = "email2@gmail.com";
	static final String EMAIL_3 = "email3@gmail.com";
	static final String EMAIL_4 = "email4@gmail.com";
	static final String EMAIL_NOT_EXIST = "gmail.com";
	
	static String[] emails1 = {
			EMAIL_1,
			EMAIL_2
	};
	static String[] emails2 = {
			EMAIL_3,
			EMAIL_4
	};
	//SensorEmails
	static SensorEmails[] sensorEmails = {
			new SensorEmails(ID1, emails1),
			new SensorEmails(ID2, emails2)
	};
	
	void createDb() {
		sensorEmailsRepo.deleteAll();
		List<SensorEmailsDoc> sensorEmailsDocs = IntStream.range(0, sensorEmails.length)
				.mapToObj(this::indexToSensorEmails).toList();
		sensorEmailsRepo.saveAll(sensorEmailsDocs);
	}
	
	SensorEmailsDoc indexToSensorEmails(int index) {
		return new SensorEmailsDoc(sensorEmails[index]);
	}
	
	

}

package telran.probes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static telran.probes.TestDb.*;
import telran.probes.repo.SensorEmailsRepo;
import telran.probes.service.SensorEmailsService;

@SpringBootTest
class SensorEmailsServiceTest {
	@Autowired
	SensorEmailsService sensorEmailsService;
	@Autowired
	SensorEmailsRepo emailsRepo;
	@Autowired
	TestDb testDb;

	@BeforeEach
	void setUp(){
		testDb.createDb();
	}

	@Test
	void getSensorEmailsTest() {
		assertArrayEquals(emails1, sensorEmailsService.getSensorEmails(ID1));
	}

}

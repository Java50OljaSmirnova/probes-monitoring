package telran.probes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static telran.probes.TestDb.*;
import telran.probes.repo.SensorRangeRepo;
import telran.probes.service.SensorRangeService;

@SpringBootTest
class SensorRangeServiceTest {
	
	@Autowired
	SensorRangeService sensorRangeService;
	@Autowired
	SensorRangeRepo rangeRepo;
	@Autowired
	TestDb testDb;

	@BeforeEach
	void setUp(){
		testDb.createDb();
	}

	@Test
	void getSensorRangeTest() {
		assertEquals(sensorRanges[0].range(), sensorRangeService.getSensorRange(ID1));
	}

}

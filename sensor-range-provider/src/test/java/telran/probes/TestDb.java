package telran.probes;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import telran.probes.dto.Range;
import telran.probes.dto.SensorRange;
import telran.probes.model.SensorRangeDoc;
import telran.probes.repo.SensorRangeRepo;

@Component
@RequiredArgsConstructor
public class TestDb {
	final SensorRangeRepo sensorRangeRepo;
	//ID's
		static final long ID1 = 123;
		static final long ID2 = 124;
		static final long ID_NOT_EXIST = 1000;
	
	//Value's
		static final double MIN_VALUE1 = 50;
		static final double MIN_VALUE2 = 60;
		static final double MAX_VALUE1 = 100;
		static final double MAX_VALUE2 = 120;
		
	//Range's	
		static final Range RANGE1 = new Range(MIN_VALUE1, MAX_VALUE1);
		static final Range RANGE2 = new Range(MIN_VALUE2, MAX_VALUE2);
		static final Range RANGE_NOT_EXIST = new Range(MIN_VALUE1, MAX_VALUE2);
		
	//SensorRange	
		static SensorRange [] sensorRanges = {
				new SensorRange(ID1, RANGE1),
				new SensorRange(ID2, RANGE2),
		};
		static SensorRange sensorRangeNotExist = new SensorRange(ID_NOT_EXIST, RANGE_NOT_EXIST);
		
		void createDb() {
			sensorRangeRepo.deleteAll();
			List<SensorRangeDoc> sensorRangeDocs = IntStream.range(0, sensorRanges.length)
					.mapToObj(this::indexToSensorRange).toList();
			sensorRangeRepo.saveAll(sensorRangeDocs);
		}
		
		SensorRangeDoc indexToSensorRange(int index) {
			return new SensorRangeDoc(sensorRanges[index]);
			
		}
}

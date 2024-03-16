package telran.probes.model;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;
import telran.probes.dto.Range;
import telran.probes.dto.SensorRange;

@Document(collection = "sensor_ranges")
@Getter
@ToString
@NoArgsConstructor
public class SensorRangeDoc {
	@Id
	long sensorId;
	@Setter
    Range range;
    
 public SensorRangeDoc(SensorRange sensorRange)   {
	 sensorId = sensorRange.id();
	 range = sensorRange.range();
	 
 }
 public SensorRange build() {
	 return new SensorRange(sensorId, range);
 }
}

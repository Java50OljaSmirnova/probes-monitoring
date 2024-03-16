package telran.probes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import telran.probes.dto.SensorEmails;

@Document(collection = "sensor-emails")
@Getter
@ToString
@NoArgsConstructor
public class SensorEmailsDoc {
	@Id
	long sensorId;
	@Setter
	String[] emails;
	
	public SensorEmailsDoc(SensorEmails sensorEmails) {
		sensorId = sensorEmails.id();
		emails = sensorEmails.mails();
	}
	
	public SensorEmails build() {
		return new SensorEmails(sensorId, emails);
	}

}

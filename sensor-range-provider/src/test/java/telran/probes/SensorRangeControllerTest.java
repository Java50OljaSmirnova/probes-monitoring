package telran.probes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import telran.probes.dto.Range;
import telran.probes.service.SensorRangeService;

@WebMvcTest
class SensorRangeControllerTest {
	
	@MockBean
	SensorRangeService sensorRange;
	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper mapper;
	
	private static final String CONTROLLER_TEST = "controller test: ";
	private static final long SENSOR_ID = 123;
	private static final double MIN_VALUE = 50;
	private static final double MAX_VALUE = 250;
	private static final String HOST = "http://localhost:8080/";
	private static final String SENSOR_RANGE = HOST + UrlConstants.SENSOR_RANGE + SENSOR_ID;
	private Range rangeNormal = new Range(MIN_VALUE, MAX_VALUE);

	@Test
	@DisplayName(CONTROLLER_TEST + TestDisplayNames.RANGE_GET_NORMAL)
	void range_getData_normal() throws Exception {
		when(sensorRange.getSensorRange(SENSOR_ID)).thenReturn(rangeNormal);
		String jsonRange = mapper.writeValueAsString(rangeNormal);
		String actualJSON = mockMvc.perform(get(SENSOR_RANGE)).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		assertEquals(jsonRange, actualJSON);
	}

}

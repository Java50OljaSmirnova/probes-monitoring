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

import telran.probes.service.SensorEmailsService;

@WebMvcTest
public class SensorEmailsControllerTest {

		@MockBean
		SensorEmailsService sensorEmails;
		@Autowired
		MockMvc mockMvc;
		@Autowired
		ObjectMapper mapper;
		
		private static final String CONTROLLER_TEST = "controller test: ";
		private static final long SENSOR_ID = 123;
		private static final String HOST = "http://localhost:8080/";
		private static final String SENSOR_EMAILS = HOST + UrlConstants.SENSOR_EMAILS + SENSOR_ID;
		private String[] emails = {
				"email1@gmail.com",
				"email2@gamil.com"
		};
		

		@Test
		@DisplayName(CONTROLLER_TEST + TestDisplayNames.EMAILS_GET_NORMAL)
		void range_getData_normal() throws Exception {
			when(sensorEmails.getSensorEmails(SENSOR_ID)).thenReturn(emails);
			String jsonRange = mapper.writeValueAsString(emails);
			String actualJSON = mockMvc.perform(get(SENSOR_EMAILS)).andExpect(status().isOk())
					.andReturn().getResponse().getContentAsString();
			assertEquals(jsonRange, actualJSON);
		}
}

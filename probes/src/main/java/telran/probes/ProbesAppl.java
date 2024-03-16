package telran.probes;

import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import telran.probes.configuration.ProbesConfiguration;
import telran.probes.dto.ProbeData;
import telran.probes.service.ProbesService;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class ProbesAppl {
	final ProbesService probesService;
	private static final long TIMEOUT = 10000;
	final ProbesConfiguration probesConfiguration;
	
	
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(ProbesAppl.class, args);
		Thread.sleep(TIMEOUT);
		ctx.close();

	}
	@Bean
	Supplier<ProbeData> probesSupplier()  {
		return this::probeGeneration;
	}
	
	ProbeData probeGeneration() {
		return getProbeData();
	}
	private ProbeData getProbeData() {
		String bindingName = "probesSupplier-out-0";
		ProbeData probeData = probesService.getRandomProbeData();
		log.debug("probe data: {} has been sent to {}", probeData, bindingName);
		return probeData;
	}
	
}

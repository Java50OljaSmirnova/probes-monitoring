package telran.probes.controller;

import static telran.probes.messages.ValidationErrorMessages.MISSING_EMAILS;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import telran.probes.dto.AccountDto;
import telran.probes.service.AccountProviderService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AccountProviderController {
	final AccountProviderService providerService;
	
	@GetMapping("${app.accounts.provider.url}" + "/{email}")
	AccountDto getAccount(@PathVariable @NotEmpty(message = MISSING_EMAILS) String email) {
		log.debug("AccountsProviderController: request fro account {}", email);
		return providerService.getAccount(email);
	}
	

}

package telran.probes.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import telran.exceptions.AccountNotFoundException;
import telran.probes.dto.AccountDto;
import telran.probes.model.Account;
import telran.probes.repo.AccountRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountProviderServiceImpl implements AccountProviderService {
	
	final AccountRepository accountRepo;

	@Override
	public AccountDto getAccount(String email) {
		log.debug("AccountProviderService: received request for email {}", email);
		Account account = accountRepo.findById(email).orElseThrow(() -> new AccountNotFoundException());
		return account.build();
	}

}

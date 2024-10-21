package net.moujahid.bankaccountapp.accountservice.services;

import net.moujahid.bankaccountapp.accountservice.clientRest.CustomerClientRest;
import net.moujahid.bankaccountapp.accountservice.entities.Account;
import net.moujahid.bankaccountapp.accountservice.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    CustomerClientRest customerClientRest;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(String accountId) {

        Optional<Account> account=accountRepository.findById(accountId);
        account.get().setCustomer(customerClientRest.findCustomerById(account.get().getCustomerId()));
        return account;
    }

    public List<Account> getAccountsByCustomerId(Long customerId) {
        return accountRepository.findByCustomerId(customerId);
    }

    public Account createAccount(Account account) {
        account.setAccountId(UUID.randomUUID().toString());
        return accountRepository.save(account);
    }

    public Account updateAccount(String accountId, Account accountDetails) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setBalance(accountDetails.getBalance());
            account.setCreateAt(accountDetails.getCreateAt());
            account.setType(accountDetails.getType());
            account.setCustomerId(accountDetails.getCustomerId());
            return accountRepository.save(account);
        } else {
            throw new RuntimeException("Account not found with id " + accountId);
        }
    }

    public void deleteAccount(String accountId) {
        accountRepository.deleteById(accountId);
    }
}

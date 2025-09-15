package com.example.bankapp.service;

import com.example.bankapp.model.Account;
import com.example.bankapp.model.Transaction;
import com.example.bankapp.repository.AccountRepository;
import com.example.bankapp.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow();
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account deposit(Long id, double amount) {
        Account account = getAccountById(id);
        account.setBalance(account.getBalance() + amount);

        Transaction transaction = new Transaction("deposit", amount, account);
        account.addTransaction(transaction);

        transactionRepository.save(transaction);
        return accountRepository.save(account);
    }

    public Account withdraw(Long id, double amount) {
        Account account = getAccountById(id);
        if (account.getBalance() < amount) {
            throw new RuntimeException("Saldo insuficiente!");
        }
        account.setBalance(account.getBalance() - amount);

        Transaction transaction = new Transaction("withdraw", amount, account);
        account.addTransaction(transaction);

        transactionRepository.save(transaction);
        return accountRepository.save(account);
    }
}

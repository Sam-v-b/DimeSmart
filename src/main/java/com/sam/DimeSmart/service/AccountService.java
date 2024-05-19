package com.sam.DimeSmart.service;

import com.sam.DimeSmart.dto.AccountDto;
import com.sam.DimeSmart.dto.TransactionDto;
import com.sam.DimeSmart.dto.TransferFundDto;
import com.sam.DimeSmart.exception.AccountException;

import java.util.List;


public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id) throws AccountException;
    AccountDto deposit(Long id, double amount) throws AccountException;
    AccountDto withdraw(Long id, double amount) throws AccountException;
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long id) throws AccountException;
    void transferFunds(TransferFundDto transferFundDto);
    List<TransactionDto> getAccountTransactions(Long accountId);
}

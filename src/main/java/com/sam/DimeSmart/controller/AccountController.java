package com.sam.DimeSmart.controller;

import com.sam.DimeSmart.dto.AccountDto;
import com.sam.DimeSmart.dto.TransactionDto;
import com.sam.DimeSmart.dto.TransferFundDto;
import com.sam.DimeSmart.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Add account REST API
    // http://localhost:8080/api/accounts
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    // Get account REST API
    // http://localhost:8080/api/accounts/get/1
    @GetMapping("/get/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return new ResponseEntity<>(accountDto,HttpStatus.OK);
    }

    // Deposit REST API
    // http://localhost:8080/api/accounts/deposit/1
    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request){
        AccountDto accountDto = accountService.deposit(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    // Withdraw REST API
    // http://localhost:8080/api/accounts/withdraw/1
    @PutMapping("/withdraw/{id}")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request){
        AccountDto accountDto = accountService.withdraw(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }
    // Get all accounts REST API
    // http://localhost:8080/api/accounts/getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> listOfAccounts = accountService.getAllAccounts();
        return new ResponseEntity<>(listOfAccounts,HttpStatus.OK);
    }

    // Delete Account REST API
    // http://localhost:8080/api/accounts/delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>("Account is deleted successfully!",HttpStatus.OK);
    }

    // Build transfer REST API
    // http://localhost:8080/api/accounts/transfer
    @PostMapping("/transfer")
    public ResponseEntity<String> transferFund(@RequestBody TransferFundDto transferFundDto){
        accountService.transferFunds(transferFundDto);
        return  ResponseEntity.ok("Transfer Successful");
    }
    // Build transaction REST API
    // http://localhost:8080/api/accounts/transaction/2
    @GetMapping("/transaction/{id}")
    public ResponseEntity<List<TransactionDto>> fetchAccountTransaction(@PathVariable("id") Long accountId){
        List<TransactionDto> transactions = accountService.getAccountTransactions(accountId);
        return ResponseEntity.ok(transactions);
    }
}

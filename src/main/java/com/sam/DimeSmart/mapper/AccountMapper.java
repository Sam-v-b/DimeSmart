package com.sam.DimeSmart.mapper;

import com.sam.DimeSmart.dto.AccountDto;
import com.sam.DimeSmart.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
            );
    return account;
    }
//   Using Record class as DTO

//public static Account mapToAccount(AccountDto accountDto){
//    Account account = new Account(
//            accountDto.id(),
//            accountDto.accountHolderName(),
//            accountDto.balance()
//    );
//    return account;
//}
    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
            );
        return accountDto;
    }
}

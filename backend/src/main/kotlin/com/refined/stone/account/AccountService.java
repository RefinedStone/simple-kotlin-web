package com.refined.stone.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired //명시적 선언으로, parameter가 하나일때는 달지 않아도 됨
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Transactional
    public boolean signIn(AccountRequestDto accountRequestDto) {

        if(accountRepository.existsByEmail(accountRequestDto.getEmail())){
            throw new RuntimeException("이미 존재하는 email입니다");
        }
        else{
            Account account = new Account(accountRequestDto);
            accountRepository.save(account);
            return true;
        }
    }

}

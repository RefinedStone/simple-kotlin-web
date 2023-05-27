package com.refined.stone.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired //명시적 선언으로, parameter가 하나일때는 달지 않아도 됨
    public AccountController(AccountService accountService) {
        this.accountService = accountService;

    }

    @PostMapping
    public boolean signIn(@RequestBody AccountRequestDto accountRequestDto) {

        return accountService.signIn(accountRequestDto);
    }

}

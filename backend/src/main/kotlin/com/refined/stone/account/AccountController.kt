package com.refined.stone.account

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController

@Autowired //명시적 선언으로, parameter가 하나일때는 달지 않아도 됨
constructor(private val accountService: AccountService) {
    @PostMapping
    fun signIn(@RequestBody accountRequestDto: AccountRequestDto?): Boolean {
        return accountService.signIn(accountRequestDto)
    }
}
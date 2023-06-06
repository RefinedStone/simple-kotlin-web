package com.refined.stone.account

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class AccountService

@Autowired //명시적 선언으로, parameter가 하나일때는 달지 않아도 됨
constructor(private val accountRepository: AccountRepository) {
    @Transactional
    fun signIn(accountRequestDto: AccountRequestDto): Boolean {
        return if (accountRepository.existsByEmail(accountRequestDto.email)) {
            throw RuntimeException("이미 존재하는 email입니다")
        } else {
            val account = Account(accountRequestDto)
            accountRepository.save(account)
            true
        }
    }
}
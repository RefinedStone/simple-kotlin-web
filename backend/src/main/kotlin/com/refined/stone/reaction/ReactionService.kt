package com.refined.stone.reaction

import com.refined.stone.account.AccountRepository
import org.springframework.stereotype.Service

@Service
class ReactionService(
    private val reactionRepository: ReactionRepository,
    private val accountRepository: AccountRepository,
) {
    fun createReaction(accountUUID: String, request: ReactionRequestDto) {
        //account entity -> uuid column 만들고, Account 객체 만들때 랜덤으로 만들도록 수정해야함
        //또한 unique 옵션으로 걸러주도록 해야함
        val account = accountRepository.findByUuId(accountUUID) ?: throw RuntimeException("Not Found Account")

        val reaction = Reaction(
                account = account,
                avgReactionTime = request.reactionTime,
            )

        reactionRepository.save(reaction)
    }

}

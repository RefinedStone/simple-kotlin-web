package com.refined.stone.reaction

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("/reations")
class ReactionController(
    private val reactionService: ReactionService,
) {

    @PostMapping()
    fun createReaction(
        @RequestBody request:ReactionRequestDto,

    ): Any{
        //account info -> temp mock data
        val accountUUID = UUID.randomUUID().toString()
        reactionService.createReaction(accountUUID,request)
        return true
    }
}
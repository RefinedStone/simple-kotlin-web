package com.refined.stone.reaction

import com.refined.stone.account.Account
import javax.persistence.*

@Entity
class Reaction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,

    @Column
    private val avgReactionTime: Long=0,

    //many reaction result to one account
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    var account: Account? = null
) {



}
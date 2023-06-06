package com.refined.stone.account

import com.refined.stone.reaction.Reaction
import javax.persistence.*


@Entity
class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private val id: Long? = null

    @Column
    private var email: String? = null

    @Column
    private var nickname: String? = null

    //one account to many reaction result
    @OneToMany(mappedBy = "account", cascade = [CascadeType.ALL])
    var reactions: MutableList<Reaction> = ArrayList()

    //진영정보 CounterStrike, SuddenAttack
    @Enumerated(EnumType.STRING)
    private var team: Team? = null

    //NoArgsConstructor
    constructor() {}
    constructor(accountRequestDto: AccountRequestDto) {
        email = accountRequestDto.getEmail()
        nickname = accountRequestDto.getNickname()
        team = accountRequestDto.getTeam()
    }
}
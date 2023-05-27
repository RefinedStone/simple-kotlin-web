package com.refined.stone.account;

import com.refined.stone.reaction.Reaction;
import kotlin.collections.ArrayDeque;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column
    private String email;

    @Column
    private String nickname;

    //one account to many reaction result
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    List<Reaction> reactions = new ArrayList<>();

    //진영정보 CounterStrike, SuddenAttack
    @Enumerated(EnumType.STRING)
    private Team team;

    //NoArgsConstructor
    public Account(){

    }
    public Account(AccountRequestDto accountRequestDto){
        this.email= accountRequestDto.getEmail();
        this.nickname=accountRequestDto.getNickname();
        this.team = accountRequestDto.getTeam();
    }
}

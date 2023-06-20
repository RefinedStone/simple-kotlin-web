//package com.refined.stone.reaction;
//
//import com.refined.stone.account.Account;
//
//import javax.persistence.*;
//
//@Entity
//public class Reaction {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long Id;
//
//    @Column
//    private Long avgReactionTime;
//
//    //many reaction result to one account
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "account_id")
//    Account account;
//}

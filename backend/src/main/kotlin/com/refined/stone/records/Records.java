package com.refined.stone.records;

import com.refined.stone.account.Account;

import javax.persistence.*;

@Entity
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "records_id")
    private Long id;

    @Column
    private Long reactionRecord;

    // many records to one account
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    Account account;

}

package com.refined.stone.account

class AccountRequestDto {
    // getter, setter 선언 필요 X
    var email: String? = null
    var nickname: String? = null
    var team: Team? = null

    //constructor
    constructor(email: String?, nickname: String?, team: Team?) {
        this.email = email
        this.nickname = nickname
    }

    //NoArgs -> 자바처럼 이렇게 해도 되는가?..
    constructor() {}

}
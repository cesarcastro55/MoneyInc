package com.example.moneyinc

data class TokenPost(
    val username: String,
    val password: String)

data class Token(
    val token: String
)

data class UserInfo(
    val id: Int,
    val type: String,
    val titular1: String,
    val titular2: String,
    val titular3: String,
    val iban: String,
    val nib: String,
    val swift: String,
    val active: Boolean,
    val approved: Boolean,
    val createdOn: String,
    val saldo: Double)




package com.example.moneyinc

import android.support.v4.app.INotificationSideChannel

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

data class Lista(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<UserInfo>)

data class ListaC(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Cards>)

data class Cards(
    val account: Int,
    val user: Int,
    val type : String,
    val subtype: String,
    val cost_per_year: Int,
    val plafond: Int,
    val name_on_card: String,
    val number: String,
    val valid_until: String,
    val cvc: String
)
data class ListaP(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Payments>)


data class Payments(
    val id: Int,
    val account: Int,
    val referencia: String,
    val codigo: Int,
    val valor: Int,
    val data_pagamento: String)

data class Pay(
    val account: Int,
    val referencia: String,
    val codigo: Int,
    val valor: Int,
    val data_pagamento: String)







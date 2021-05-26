package com.example.moneyinc

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

private const val BASE_URL = "https://moneyinc.carrola.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface UserToken{
    @POST("/tokens/")
    fun createToken(@Body post: TokenPost):
            Call<Token>
}

object ServiceApi {
    val retrofitService : UserToken by lazy {
        retrofit.create(UserToken::class.java) }
}



package com.example.moneyinc

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val BASE_URL = "https://moneyinc.carrola.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**Buscar o token*/
interface UserToken{
    @POST("/tokens/")
    fun createToken(@Body post: TokenPost):
            Call<Token>
}

object ServiceApi {
    val retrofitService : UserToken by lazy {
        retrofit.create(UserToken::class.java) }
}


/**Buscar informações sobre as contas */
interface AccountInfo{
    @GET("/accounts/32/")
    fun getInformation(@Header("Authorization") token: String):
            Call<UserInfo>
}

object ServiceApi2{
    val retrofitService : AccountInfo by lazy {
        retrofit.create(AccountInfo::class.java) }
}

/**Buscar informações sobre a lista das contas */
interface AccountLista{
    @GET("/accounts/")
    fun getLista(@Header("Authorization") token: String, @Header("page") page: Int):
            Call<Lista>
}

object ServiceApi3{
    val retrofitService : AccountLista by lazy {
        retrofit.create(AccountLista::class.java) }
}


/**Buscar informações sobre a lista dos cartões */
interface CardsLista{
    @GET("/cards/")
        fun getListaCards(@Header("Authorization") token: String, @Header("page") page: Int):
                Call<CardsLista>
}

object ServiceApi4{
    val retrofitService : CardsLista by lazy {
        retrofit.create(CardsLista::class.java) }
}



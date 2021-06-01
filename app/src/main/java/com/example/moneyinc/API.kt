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

/**Buscar lista de informações de contas */
interface AccountLista{
    @GET("/accounts/")
    fun getLista(@Header("Authorization") token: String, @Query("page") page: String):
            Call<Lista>
}

object ServiceApi3{
    val retrofitService : AccountLista by lazy {
        retrofit.create(AccountLista::class.java) }
}


/**Buscar lista de cartões */
interface CardsLista{
    @GET("/cards/")
        fun getListaCards(@Header("Authorization") token: String, @Query("page") page: String):
                Call<ListaC>
}

object ServiceApi4{
    val retrofitService : CardsLista by lazy {
        retrofit.create(CardsLista::class.java) }
}

/**Criar cartões */
interface CreatCard{
    @POST("/cards/")
    fun sendRequest(@Header("Authorization") token: String, @Body post: Cards):
            Call<Cards>
}

object ServiceApi2{
    val retrofitService : CreatCard by lazy {
        retrofit.create(CreatCard::class.java) }
}



/**Mostrar pagamentos */
interface ListaPagamentos{
    @GET("/payments/")
    fun getPayments(@Header("Authorization") token: String, @Query("page") page: String):
            Call<ListaP>
}

object ServiceApi5{
    val retrofitService : ListaPagamentos by lazy {
        retrofit.create(ListaPagamentos::class.java) }
}

/**Efetuar pagamentos */
interface MakePayment{
    @GET("/accounts/")
    fun sendPay(@Header("Authorization") token: String, @Body post: Pay):
            Call<Pay>
}

object ServiceApi6{
    val retrofitService : MakePayment by lazy {
        retrofit.create(MakePayment::class.java) }
}



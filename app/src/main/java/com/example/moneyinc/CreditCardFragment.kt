package com.example.moneyinc

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moneyinc.databinding.FragmentCreditCardBinding
import retrofit2.Call
import retrofit2.Response


class CreditCardFragment : Fragment(), EmpAdapater.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val adapter = EmpAdapater(listOf(), this)
    var lista = mutableListOf<Cards>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentCreditCardBinding>(
            inflater,
            R.layout.fragment_credit_card,
            container,
            false
        )
        var page = "1"
        val aux: CreditCardFragmentArgs ?= arguments?.let { CreditCardFragmentArgs.fromBundle(it) }
        val token = aux?.token.toString()
        Log.d("token cartao", token)

        /*binding.button11.setOnClickListener {
            val aux: NavDirections = CreditCardFragmentDirections.actionCreditCardFragmentToHomeFragment(token)
            findNavController().navigate(aux)
        }

        binding.button13.setOnClickListener {
            val aux: NavDirections = CreditCardFragmentDirections.actionCreditCardFragmentToPaymentFragment(token)
            findNavController().navigate(aux)
        }*/

        getAccountList(token, page)
        binding.recyclreviewcard.layoutManager = LinearLayoutManager(context)
        binding.recyclreviewcard.adapter = adapter


        return binding.root
    }

    private fun getAccountList(token: String, page: String) {

        ServiceApi4.retrofitService.getListaCards(token,page).enqueue(
            object : retrofit2.Callback<ListaC> {
                override fun onResponse(call: Call<ListaC>, response: Response<ListaC>) {
                    lista = mutableListOf<Cards>()
                    for (i in response.body()?.results.orEmpty()) {
                        val item = Cards(i.id, i.account, i.user, i.type, i.subtype, i.cost_per_year,
                            i.plafond, i.name_on_card, i.number, i.valid_until, i.cvc)
                        Log.d("ERRO BURRO", i.account.toString())
                        lista.add(item)
                    }
                    //passar lista ao adapter
                    adapter.reloadItems(lista)
                }

                override fun onFailure(call: Call<ListaC>, t: Throwable) {
                    Log.e("Erro!!", "Sem dados3!!")
                }

            }
        )

    }

    override fun onItemClick(position: Int) {
        TODO("Not yet implemented")
    }
}
package com.example.moneyinc

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moneyinc.databinding.FragmentPaymentBinding
import retrofit2.Call
import retrofit2.Response

class PaymentFragment : Fragment(), PayAdapter.OnItemClickListener {

    private val adapter = PayAdapter(listOf(), this)
    var lista = mutableListOf<Payments>()
    var token = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentPaymentBinding>(
            inflater,
            R.layout.fragment_payment,
            container,
            false
        )

        val aux: PaymentFragmentArgs ?= arguments?.let { PaymentFragmentArgs.fromBundle(it) }
        token = aux?.token.toString()

        var page = "1"
        getPayments(token, page)

        binding.pageup.setOnClickListener{
            var pageup = page.toInt() + 1
            page = pageup.toString()
            getPayments(token, page)
        }

        binding.pagedown.setOnClickListener{
            var pagedown = page.toInt() - 1
            page = pagedown.toString()
            getPayments(token, page)
        }

        binding.payrecyclerview.layoutManager = LinearLayoutManager(context)
        binding.payrecyclerview.adapter = adapter

        binding.efetuarpagamento.setOnClickListener {
            val aux: NavDirections = PaymentFragmentDirections.actionPaymentFragmentToMakePaymentFragment(token)
            findNavController().navigate(aux)
        }

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun getPayments(token: String, page: String){

        ServiceApi5.retrofitService.getPayments(token, page).enqueue(
            object : retrofit2.Callback<ListaP>{
                override fun onResponse(call: Call<ListaP>, response: Response<ListaP>) {
                    lista = mutableListOf<Payments>()
                    for (i in response.body()?.results.orEmpty()) {
                        var item = Payments(i.id, i.account, i.referencia, i.codigo, i.valor, i.data_pagamento)
                        lista.add(item)
                        Log.d("pagamentos", item.id.toString())
                    }
                    adapter.reloadItems(lista)
                }

                override fun onFailure(call: Call<ListaP>, t: Throwable) {
                }
            }
        )
    }


    override fun onItemClick(position: Int) {
        Toast.makeText(context, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val aux: NavDirections = PaymentFragmentDirections.actionPaymentFragmentToShowPayInfoFragment(lista[position].id.toString(),
            lista[position].account.toString(), lista[position].referencia, lista[position].codigo.toString(), lista[position].valor.toString(),
            lista[position].data_pagamento, token)
        findNavController().navigate(aux)
    }
}
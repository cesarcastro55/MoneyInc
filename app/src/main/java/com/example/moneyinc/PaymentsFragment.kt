package com.example.moneyinc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.moneyinc.databinding.FragmentWalletBinding
import retrofit2.Call
import retrofit2.Response

class PaymentsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = DataBindingUtil.inflate<FragmentWalletBinding>(
            inflater,
            R.layout.fragment_payments,
            container,
            false
        )

        val aux: PaymentsFragmentArgs ?= arguments?.let { PaymentsFragmentArgs.fromBundle(it) }
        val token = aux?.token.toString()


        binding.button14.setOnClickListener {
            val aux: NavDirections = PaymentsFragmentDirections.actionPaymentsFragmentToCreditCardFragment(token)
            findNavController().navigate(aux)
        }



        binding.button15.setOnClickListener {
            var account: Int = binding.editTextTextPersonName2.text
            var referencia: Int = binding.editTextTextPersonName3.text
            var codigo: Int = binding.editTextTextPersonName4.text
            var valor: Double = binding.editTextTextPersonName5.text
            var data_pagamento: String = binding.editTextDate.text
        }


        return binding.root
    }

    /*
    fun makePayment(account: Int, referencia: Int, codigo: Int, valor: Double, data_pagamento: String){
        var post: PaymentsPost = Payments(account, referencia, codigo, valor, data_pagamento)
        ServiceApi5.retrofitService.newPayment(post).enqueue(
            object : retrofit2.Callback<Payments>{
                override fun onResponse(call: Call<Payments>, response: Response<Payments>) {

                }

                override fun onFailure(call: Call<Payments>, t: Throwable) {

                }

            }
        )
    }
*/

}
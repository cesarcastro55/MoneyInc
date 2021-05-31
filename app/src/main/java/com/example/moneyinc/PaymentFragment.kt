package com.example.moneyinc

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.moneyinc.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
            val id = aux?.id.toString()


            binding.button14.setOnClickListener {
            val aux: NavDirections = PaymentFragmentDirections.actionPaymentFragmentToWalletFragment(id)
                findNavController().navigate(aux)
            }


            binding.button15.setOnClickListener {
            var referencia: Editable? = binding.editTextTextPersonName3.text
            var codigo: Editable? = binding.editTextTextPersonName4.text
            var valor: Editable? = binding.editTextTextPersonName5.text
            var data_pagamento: Editable? = binding.editTextDate.text

            //makePayment(account, referencia, codigo, valor, data_pagamento)
            }


            return binding.root
        }

/**
fun makePayment(account: Int, referencia: Int, codigo: Int, valor: Double, data_pagamento: String){
var post1: Payments = Payments(account, referencia, codigo, valor, data_pagamento)
ServiceApi5.retrofitService.newPayment().enqueue(
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
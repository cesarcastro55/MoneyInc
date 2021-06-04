package com.example.moneyinc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.moneyinc.databinding.FragmentSelectAccountBinding
import com.example.moneyinc.databinding.FragmentShowAccBindingImpl
import com.example.moneyinc.databinding.FragmentShowPayInfoBinding

class ShowPayInfoFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentShowPayInfoBinding>(
            inflater,
            R.layout.fragment_show_pay_info,
            container,
            false
        )

        val aux: ShowPayInfoFragmentArgs ?= arguments?.let { ShowPayInfoFragmentArgs.fromBundle(it) }
        var id = aux?.id.toString()
        var account = aux?.account.toString()
        var referencia = aux?.referencia.toString()
        var codigo = aux?.codigo.toString()
        var valor = aux?.valor.toString()
        var data_pagamento = aux?.dataPagamento.toString()
        var token = aux?.token.toString()

        binding.idtext.text = id
        binding.accounttext.text = account
        binding.referenciatext.text = referencia
        binding.codigotext.text = codigo
        binding.valortext.text = valor
        binding.datatext.text = data_pagamento

        binding.returnbutton.setOnClickListener {
            val aux: NavDirections = ShowPayInfoFragmentDirections.actionShowPayInfoFragmentToPaymentFragment(token)
            findNavController().navigate(aux)
        }

        return binding.root
    }

}
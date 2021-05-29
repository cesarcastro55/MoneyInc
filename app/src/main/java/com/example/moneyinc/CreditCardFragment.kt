package com.example.moneyinc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.moneyinc.databinding.FragmentCreditCardBinding


class CreditCardFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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

        val aux: CreditCardFragmentArgs ?= arguments?.let { CreditCardFragmentArgs.fromBundle(it) }
        val token = aux?.token.toString()

        binding.button11.setOnClickListener {
            val aux: NavDirections = CreditCardFragmentDirections.actionCreditCardFragmentToHomeFragment(token)
            findNavController().navigate(aux)
        }

        binding.button13.setOnClickListener {
            val aux: NavDirections = CreditCardFragmentDirections.actionCreditCardFragmentToPaymentFragment(token)
            findNavController().navigate(aux)
        }

        return binding.root
    }





}
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
import com.example.moneyinc.databinding.FragmentWalletBinding


class WalletFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = DataBindingUtil.inflate<FragmentWalletBinding>(
            inflater,
            R.layout.fragment_wallet,
            container,
            false
        )

        val aux: WalletFragmentArgs ?= arguments?.let { WalletFragmentArgs.fromBundle(it) }
        val id = aux?.id.toString()

        //Log.e("ID:", )
        /*
        binding.button12.setOnClickListener {
            val aux: NavDirections = WalletFragmentDirections.actionWalletFragmentToHomeFragment(id)
            findNavController().navigate(aux)
        }*/

        binding.button2.setOnClickListener {
            val aux: NavDirections = WalletFragmentDirections.actionWalletFragmentToPaymentFragment(id)
            findNavController().navigate(aux)
        }

        return binding.root
    }

}
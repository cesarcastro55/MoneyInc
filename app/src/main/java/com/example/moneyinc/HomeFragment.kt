package com.example.moneyinc

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.moneyinc.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Response


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        val aux: HomeFragmentArgs ?= arguments?.let { HomeFragmentArgs.fromBundle(it) }
        val id = aux?.id.toString()
        val type = aux?.type.toString()
        val titular1 = aux?.titular1.toString()
        val titular2 = aux?.titular2.toString()
        val titular3 = aux?.titular3.toString()
        val iban = aux?.iban.toString()
        val nib = aux?.nib.toString()
        val swift = aux?.swift.toString()
        val active = aux?.active.toString()
        val approved = aux?.approved.toString()
        val createdOn = aux?.createdOn.toString()
        val saldo = aux?.saldo.toString()
        val args = aux?.token.toString()
        val token = "token $args"



        Log.d("nome recebido!!", titular1)
        Log.d("id recebido!!", id)
        Log.d("token recebido!!", token)

        binding.nometext.text = titular1
        binding.textsaldo.text = saldo + '€'

        //Log.e("Token recebido!!", token)
        //getInfo(token)
        //Log.e("aqui", token)

        binding.button5.setOnClickListener {
            val aux: NavDirections = HomeFragmentDirections.actionHomeFragmentToSelectAccountFragment(id)
            findNavController().navigate(aux)
        }


        binding.button6.setOnClickListener {
            val aux: NavDirections = HomeFragmentDirections.actionHomeFragmentToPaymentFragment(token)
            findNavController().navigate(aux)
        }


        binding.button7.setOnClickListener {
            val aux: NavDirections = HomeFragmentDirections.actionHomeFragmentToPersonFragment(id, titular1, iban, nib, swift)
            findNavController().navigate(aux)
        }

        binding.button8.setOnClickListener {
            val aux: NavDirections = HomeFragmentDirections.actionHomeFragmentToCreditCardFragment(token)
            findNavController().navigate(aux)
        }

        binding.gosettings.setOnClickListener {
            val aux: NavDirections = HomeFragmentDirections.actionHomeFragmentToSettingsFragment()
            findNavController().navigate(aux)
        }


        return binding.root
    }

}
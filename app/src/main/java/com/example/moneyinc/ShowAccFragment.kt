package com.example.moneyinc

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.moneyinc.databinding.FragmentShowAccBinding

class ShowAccFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentShowAccBinding>(
            inflater,
            R.layout.fragment_show_acc,
            container,
            false
        )

        val aux: ShowAccFragmentArgs ?= arguments?.let { ShowAccFragmentArgs.fromBundle(it) }
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

        binding.idtext.text = "ID  " + id
        binding.typetext.text = "TYPE  " + type
        binding.titular1text.text = "TITULAR1  " +  titular1
        binding.titular2text.text = "TITULAR2  " + titular2
        binding.titular3text.text = "TITULAR3  " + titular3
        binding.ibantext.text = "IBAN  " + iban
        binding.nibtext.text = "NIB  " + nib
        binding.swifttext.text = "SWIFT  " + swift
        binding.activetext.text = "ACTIVE  " + active
        binding.approvedtext.text = "APRROVED  " + approved
        binding.createdOn.text = "CREATEDON  " + createdOn
        binding.saldotext.text = "SALDO  " + saldo




        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}
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

class EmployeeMenuFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentPaymentBinding>(
            inflater,
            R.layout.fragment_employee_menu,
            container,
            false
        )

        val aux: PaymentFragmentArgs ?= arguments?.let { PaymentFragmentArgs.fromBundle(it) }
        val id = aux?.id.toString()





        return binding.root
    }
}
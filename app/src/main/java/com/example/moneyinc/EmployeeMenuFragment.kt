package com.example.moneyinc

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.moneyinc.databinding.FragmentEmployeeMenuBinding
import com.example.moneyinc.databinding.FragmentLoginBinding


class EmployeeMenuFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentEmployeeMenuBinding>(
            inflater,
            R.layout.fragment_employee_menu,
            container,
            false
        )

        val aux: EmployeeMenuFragmentArgs ?= arguments?.let { EmployeeMenuFragmentArgs.fromBundle(it) }
        val args = aux?.token.toString()
        val token = "token $args"
        Log.e("Token recebido!!", token)




        return binding.root

    }






}
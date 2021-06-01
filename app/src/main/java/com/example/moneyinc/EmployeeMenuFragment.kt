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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moneyinc.databinding.FragmentEmployeeMenuBinding
import com.example.moneyinc.databinding.FragmentPaymentBinding

class EmployeeMenuFragment : Fragment(), EmpAdapater.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private val adapter = EmpAdapater(listOf(), this)
    var lista = mutableListOf<UserInfo>()

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

        binding.logoutbutton.setOnClickListener {
            val aux: NavDirections = EmployeeMenuFragmentDirections.actionEmployeeMenuFragmentToLoginFragment()
            findNavController().navigate(aux)
        }

        binding.visualizaracc.setOnClickListener {
            val aux: NavDirections = EmployeeMenuFragmentDirections.actionEmployeeMenuFragmentToAccListFragment(token)
            findNavController().navigate(aux)
        }

        return binding.root
    }

    override fun onItemClick(position: Int) {
    }
}
package com.example.moneyinc


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.moneyinc.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentSettingsBinding>(
            inflater,
            R.layout.fragment_settings,
            container,
            false
        )

        /*val aux: SettingsFragmentArgs ?= arguments?.let { SettingsFragmentArgs.fromBundle(it) }
        val token = aux?.token.toString()*/

        /*binding.button10.setOnClickListener {
            val aux: NavDirections = SettingsFragmentDirections.actionSettingsFragmentToHomeFragment(token)
            findNavController().navigate(aux)
        }*/

        binding.logoutbutton.setOnClickListener {
            val aux: NavDirections = SettingsFragmentDirections.actionSettingsFragmentToLoginFragment()
            findNavController().navigate(aux)
        }

        return binding.root
    }
}
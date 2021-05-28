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
        val token = aux?.token.toString()
        val token1 = "7d5861ca4b8d2a0c50b40bad4a3be7228b489aaa"

        Log.e("Token recebido!!", token)
        Log.e("aqui", token)

        fun getInfo(token: String){
            var userI: UserInfo

            ServiceApi2.retrofitService.getInformation(token).enqueue(
                object : retrofit2.Callback<UserInfo>{
                    override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                        Log.e("Erro!!", "Sem dados2!!")
                        Log.e("Erro!!", response.code().toString())
                        userI = response.body()!!
                        Log.e("Nome", userI!!.titular1)
                        Log.e("Saldo", userI!!.saldo.toString())
                        binding.textView10.text = userI!!.saldo.toString()
                        binding.textView11.text = userI!!.titular1

                    }

                    override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                        Log.e("Erro!!", "Sem dados2!!")
                    }
                }
            )
        }

        getInfo(token)

        binding.button5.setOnClickListener {

            val aux: NavDirections = HomeFragmentDirections.actionHomeFragmentToSelectAccountFragment(token1)
            findNavController().navigate(aux)
        }

        binding.button6.setOnClickListener {
            val aux: NavDirections = HomeFragmentDirections.actionHomeFragmentToWalletFragment(token)
            findNavController().navigate(aux)
        }

        binding.button7.setOnClickListener {
            val aux: NavDirections = HomeFragmentDirections.actionHomeFragmentToPersonFragment(token)
            findNavController().navigate(aux)
        }

        binding.button8.setOnClickListener {
            val aux: NavDirections = HomeFragmentDirections.actionHomeFragmentToCreditCardFragment(token)
            findNavController().navigate(aux)
        }

        binding.button9.setOnClickListener {
            val aux: NavDirections = HomeFragmentDirections.actionHomeFragmentToSettingsFragment(token)
            findNavController().navigate(aux)
        }


        return binding.root

    }

    /**
    private fun getInfo(token: String){
        var userT: UserInfo?= null

        ServiceApi2.retrofitService.getInformation(token).enqueue(
            object : retrofit2.Callback<UserInfo>{
                override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                    Log.e("Erro!!", "Sem dados2!!")
                    userT = response.body()
                    //Log.e("User", user.toString())
                    Log.e("Nome", userT!!.titular1)
                    Log.e("Saldo", userT!!.saldo.toString())
                    view?.findViewById<TextView>(R.id.textView11)?.text = userT!!.id.toString()
                    //view?.findViewById<TextView>(R.id.textView10)?.text = user!!.saldo.toString() + "€"
                }

                override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                    Log.e("Erro!!", "Sem dados2!!")
                }
            }
        )
    }*/

/*
    fun getInform(list: List<UserInfo>?):ArrayList<String?>{
        var aux = ArrayList<String?>()
        aux.add(list?.get(0)?.titular1)
        aux.add(list?.get(0)?.iban)

        return aux
    }
*/

}
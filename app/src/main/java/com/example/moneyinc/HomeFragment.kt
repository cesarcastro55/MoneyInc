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
        val id = aux?.id.toString()
        val titular1 = aux?.titular1.toString()
        val titular2 = aux?.titular2.toString()
        val titular3 = aux?.titular3.toString()
        val iban = aux?.iban.toString()
        val nib = aux?.nib.toString()
        val swift = aux?.swift.toString()
        val active = aux?.active.toString()
        val aproved = aux?.approved.toString()
        val createdOn = aux?.createdOn.toString()
        val saldo = aux?.saldo.toString()



        Log.d("nome recebido!!", titular1)
        Log.d("id recebido!!", id)

        binding.nometext.text = titular1
        binding.textView10.text = saldo + '€'


        //Log.e("Token recebido!!", token)
        //getInfo(token)
        //Log.e("aqui", token)

        binding.button5.setOnClickListener {
            val aux: NavDirections = HomeFragmentDirections.actionHomeFragmentToSelectAccountFragment(id)
            findNavController().navigate(aux)
        }


        binding.button6.setOnClickListener {
            val aux: NavDirections = HomeFragmentDirections.actionHomeFragmentToWalletFragment(id)
            findNavController().navigate(aux)
        }


        binding.button7.setOnClickListener {
            val aux: NavDirections = HomeFragmentDirections.actionHomeFragmentToPersonFragment(id, titular1, iban, nib, swift)
            findNavController().navigate(aux)
        }

        binding.button8.setOnClickListener {
            val aux: NavDirections = HomeFragmentDirections.actionHomeFragmentToCreditCardFragment(id)
            findNavController().navigate(aux)
        }

        binding.button9.setOnClickListener {
            val aux: NavDirections = HomeFragmentDirections.actionHomeFragmentToSettingsFragment(id)
            findNavController().navigate(aux)
        }

        /*
        fun getInfo(token: String){
            var user: UserInfo ?= null

            ServiceApi2.retrofitService.getInformation(token).enqueue(
                object : retrofit2.Callback<UserInfo>{
                    override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                        Log.d("Erro!!", "ERRO!!")
                        user = response.body()
                        //Log.e("Nome", user!!.titular1)
                        Log.d("Erro2!!", "ERRO!!2")
                       // Log.e("Nome", user!!.titular1)
                        /**
                        Log.e("User", user.toString())
                        Log.e("Nome", user!!.titular1)
                        Log.e("Saldo", user!!.saldo.toString())
                        view?.findViewById<TextView>(R.id.textView11)?.text = user!!.titular1
                        view?.findViewById<TextView>(R.id.textView10)?.text = user!!.saldo.toString() + "€"*/

                    }

                    override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                        Log.e("Erro!!", "Sem dados2!!")
                    }
                }
            )
        }



        getInfo(token)
        Log.e("aqui", token)*/


        return binding.root

    }

/**
    private fun getInfo(token: String){
        var user: UserInfo ?= null

        ServiceApi2.retrofitService.getInformation(token).enqueue(
            object : retrofit2.Callback<UserInfo>{
                override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                    //Log.d("Nome")
                    user = response.body()
                    /**
                    Log.e("User", user.toString())
                    Log.e("Nome", user!!.titular1)
                    Log.e("Saldo", user!!.saldo.toString())*/
                    view?.findViewById<TextView>(R.id.textView11)?.text = user!!.titular1
                    view?.findViewById<TextView>(R.id.textView10)?.text = user!!.saldo.toString() + "€"
                }

                override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                    Log.e("Erro!!", "Sem dados2!!")
                }
            }
        )
    }


    fun getInform(list: List<UserInfo>?):ArrayList<String?>{
        var aux = ArrayList<String?>()
        aux.add(list?.get(0)?.titular1)
        aux.add(list?.get(0)?.iban)

        return aux
    }

*/
}
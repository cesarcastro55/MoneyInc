package com.example.moneyinc

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.moneyinc.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Response
import kotlin.math.log


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
        val args = aux?.token.toString()
        val token = "token $args"


        Log.e("Token recebido!!", token)


        getInfo(token)

        /**
        binding.button4.setOnClickListener{view: View -> view.findNavController()
        .navigate(R.id.action_homeFragment_to_selectAccountFragment)
        }*/


        binding.button4.setOnClickListener {
            val aux: NavDirections = HomeFragmentDirections.actionHomeFragmentToSelectAccountFragment(token)
            findNavController().navigate(aux)
        }


        return binding.root

    }



    private fun getInfo(token: String){
        var user: UserInfo ?= null

        ServiceApi2.retrofitService.getInformation(token).enqueue(
            object : retrofit2.Callback<UserInfo>{
                override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                    user = response.body()
                    Log.e("User", user.toString())
                    Log.e("Nome", user!!.titular1)
                    Log.e("Saldo", user!!.saldo.toString())
                    view?.findViewById<TextView>(R.id.textView11)?.text = user!!.titular1
                    view?.findViewById<TextView>(R.id.textView10)?.text = user!!.saldo.toString() + "€"
                }

                override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                    Log.e("Erro!!", "Sem dados2!!")
                }

            }
        )

    }


}
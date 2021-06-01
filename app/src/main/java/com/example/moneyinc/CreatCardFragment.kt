package com.example.moneyinc

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.moneyinc.databinding.FragmentCreatCardBinding
import com.example.moneyinc.databinding.FragmentEmployeeMenuBinding
import retrofit2.Call
import retrofit2.Response

class CreatCardFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    var post = Cards(1,1,1,"","", 1, 1,"","","","")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentCreatCardBinding>(
            inflater,
            R.layout.fragment_creat_card,
            container,
            false
        )

        val aux: CreatCardFragmentArgs ?= arguments?.let { CreatCardFragmentArgs.fromBundle(it) }
        val token = aux?.token.toString()

        binding.sendrequest.setOnClickListener {
            var id: String = binding.idtext.text.toString()
            var account: String = binding.accounttext.text.toString()
            var user: String = binding.usertext.text.toString()
            var type: String = binding.typetext.text.toString()
            var subtype: String = binding.subtypetext.text.toString()
            var costperyear: String = binding.costperyeartext.text.toString()
            var plafond: String = binding.plafondtext.text.toString()
            var nameoncard: String = binding.nameoncardtext.text.toString()
            var number: String = binding.numbertext.text.toString()
            var validuntil: String = binding.validuntiltext.text.toString()
            var cvc: String = binding.cvctext.text.toString()
            post = Cards(id.toInt(), account.toInt(), user.toInt(), type, subtype, costperyear.toInt(),
                plafond.toInt(), nameoncard, number, validuntil, cvc)
            requestCard(token, post)
        }

        Log.d("token creat cards aqui", token)
        Log.d("tipo cards aqui", post.type)


        return binding.root
    }
    fun requestCard(token: String, post: Cards){

        ServiceApi2.retrofitService.sendRequest(token, post).enqueue(
            object : retrofit2.Callback<Cards>{
                override fun onFailure(call: Call<Cards>, t: Throwable) {
                    Toast.makeText(context, "Erro!! Credenciais Incorretas", Toast.LENGTH_LONG).show()
                    Log.e("Error!!", "Sem dados!!")
                }

                override fun onResponse(call: Call<Cards>, response: Response<Cards>) {
                    //var PostResponse: Cards? = response.body()
                    Log.d("chegou aqui", post.type)
                    /*if(PostResponse != null){
                        val tempToken = response.body()!!.token
                        if(username == "cliente") {
                            val aux: NavDirections = LoginFragmentDirections.actionLoginFragmentToSelectAccountFragment(tempToken)
                            findNavController().navigate(aux)}
                        else{
                            val aux: NavDirections = LoginFragmentDirections.actionLoginFragmentToEmployeeMenuFragment(tempToken)
                            findNavController().navigate(aux)}
                    }else{
                        Log.e("Erro!!", "Sem dados1!!")
                    }*/
                }

            }
        )
    }

}
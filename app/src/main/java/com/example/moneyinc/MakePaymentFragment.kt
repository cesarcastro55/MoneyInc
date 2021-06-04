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
import com.example.moneyinc.databinding.FragmentCreditCardBinding
import com.example.moneyinc.databinding.FragmentMakePaymentBinding
import retrofit2.Call
import retrofit2.Response

class MakePaymentFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentMakePaymentBinding>(
            inflater,
            R.layout.fragment_make_payment,
            container,
            false
        )
        val aux: MakePaymentFragmentArgs ?= arguments?.let { MakePaymentFragmentArgs.fromBundle(it) }
        val token = aux?.token.toString()

        binding.contatext.setText("29")
        binding.referenciatext.setText("29")
        binding.codigotext.setText("2")
        binding.valortext.setText("5")
        binding.datatext.setText("01-06-2021")

        binding.returnbutton.setOnClickListener{
            val aux: NavDirections = MakePaymentFragmentDirections.actionMakePaymentFragmentToPaymentFragment(token)
            findNavController().navigate(aux)
        }

        binding.confirmButton.setOnClickListener {
            var account: String = binding.contatext.text.toString()
            var referencia: String = binding.referenciatext.text.toString()
            var codigo: String = binding.codigotext.text.toString()
            var valor: String = binding.valortext.text.toString()
            var data: String = binding.datatext.text.toString()

            var temp = Pay(account.toInt(), referencia, codigo.toInt(), valor.toInt(), data)
            MakePay(token, temp)
        }

        return binding.root
    }
    fun MakePay(token: String, temp: Pay){

        ServiceApi6.retrofitService.sendPay(token, temp).enqueue(
            object : retrofit2.Callback<Pay>{
                override fun onFailure(call: Call<Pay>, t: Throwable) {
                    Toast.makeText(context, "Erro!! Credenciais Incorretas", Toast.LENGTH_LONG).show()
                    Log.e("Error!!", "Sem dados!!")
                }

                override fun onResponse(call: Call<Pay>, response: Response<Pay>) {
                    Log.d("chegou aqui pagamentos", response.toString())
                }

            }
        )
    }

}
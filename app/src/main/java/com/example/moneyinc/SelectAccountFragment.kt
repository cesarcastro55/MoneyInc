package com.example.moneyinc


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.moneyinc.databinding.FragmentSelectAccountBinding
import retrofit2.Call
import retrofit2.Response


class SelectAccountFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentSelectAccountBinding>(
            inflater,
            R.layout.fragment_select_account,
            container,
            false
        )


        val aux: SelectAccountFragmentArgs ?= arguments?.let { SelectAccountFragmentArgs.fromBundle(it) }
        val args = aux?.token.toString()
        val token = "token $args"
        Log.e("Token recebido!!", token)

        binding.button2.setOnClickListener {
            val aux: NavDirections = SelectAccountFragmentDirections.actionSelectAccountFragmentToHomeFragment(token)
            findNavController().navigate(aux)
        }


        var page = "1"
        var id: String
        var type: String
        var titular1: String
        var titular2: String
        var titular3: String
        var iban: String
        var nib: String
        var swift: String
        var active: String
        var approved: String
        var createdOn: String
        var saldo: String

        Log.d("aqui", page)

        fun getAccountList(token: String, page: String) {

            ServiceApi3.retrofitService.getLista(token,page).enqueue(
                object : retrofit2.Callback<Lista> {
                    override fun onResponse(call: Call<Lista>, response: Response<Lista>) {

                        Log.e("sucesso", " com dados1!!")
                        for(i in response.body()?.results.orEmpty()){
                            titular1 = i.titular1
                            id = i.id.toString()
                            type = i.type
                            iban = i.iban
                            Log.d("titular", titular1)
                            Log.d("id", id)
                        }
                        //if(response.code() == 404) page = "1" // quando nao houver mais paginas, voltar à pag1
                    }

                    override fun onFailure(call: Call<Lista>, t: Throwable) {
                        Log.e("Erro!!", "Sem dados3!!")
                        //Log.d("aquiFailure", t.message.toString())
                    }

                }
            )

        }
        getAccountList(token, page)

        binding.button16.setOnClickListener{
            var pageup = page.toInt() - 1
            page = pageup.toString()
            getAccountList(token, page)
        }

        binding.button17.setOnClickListener{
            var pageup = page.toInt() + 1
            page = pageup.toString()
            getAccountList(token, page)
        }

        return binding.root
    }




}
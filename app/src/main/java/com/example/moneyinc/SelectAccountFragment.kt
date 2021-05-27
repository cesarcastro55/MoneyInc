package com.example.moneyinc


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
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
        //val token = "token $args"
        Log.e("Token recebido!!", args)

        val page: Int = 1
        //getAccountList(token, page)

        return binding.root
    }

    private fun getAccountList(token: String, page: Int) {
        //var pag: Lista

        ServiceApi3.retrofitService.getLista(token, page).enqueue(
            object : retrofit2.Callback<Lista> {
                override fun onResponse(call: Call<Lista>, response: Response<Lista>) {

                    Log.e("sucesso", " com dados1!!")
                }

                override fun onFailure(call: Call<Lista>, t: Throwable) {
                    Log.e("Erro!!", "Sem dados3!!")
                }

            }
        )

    }


}
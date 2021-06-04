package com.example.moneyinc


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moneyinc.databinding.FragmentSelectAccountBinding
import kotlinx.android.synthetic.main.fragment_select_account.*
import retrofit2.Call
import retrofit2.Response

class SelectAccountFragment : Fragment(), CustomAdapter.OnItemClickListener {

    var args = ""
    private val adapter = CustomAdapter(listOf(), this)
    var lista = mutableListOf<UserInfo>()

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
        args = aux?.token.toString()
        val token = "token $args"
        Log.e("Token recebido!!", token)


        var page = "1"
        getAccountList(token, page)

        /*binding.button2.setOnClickListener {
            val aux: NavDirections = SelectAccountFragmentDirections.actionSelectAccountFragmentToHomeFragment(token)
            findNavController().navigate(aux)
        }*/


        binding.pageup.setOnClickListener{
            var pageup = page.toInt() + 1
            page = pageup.toString()
            getAccountList(token, page)
        }

        binding.pagedown.setOnClickListener{
            var pagedown = page.toInt() - 1
            page = pagedown.toString()
            getAccountList(token, page)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun getAccountList(token: String, page: String) {

        ServiceApi3.retrofitService.getLista(token,page).enqueue(
            object : retrofit2.Callback<Lista> {
                override fun onResponse(call: Call<Lista>, response: Response<Lista>) {
                    lista = mutableListOf<UserInfo>()
                    for (user in response.body()?.results.orEmpty()) {
                        val item = UserInfo(user.id, user.type, user.titular1, user.titular2, user.titular3,
                            user.iban, user.nib, user.swift, user.active, user.approved, user.createdOn, user.saldo)
                        lista.add(item)
                    }
                    //passar lista ao adapter
                    adapter.reloadItems(lista)
                }

                override fun onFailure(call: Call<Lista>, t: Throwable) {
                    Log.e("Erro!!", "Sem dados3!!")
                }

            }
        )

    }
    override fun onItemClick(position: Int) {
        Toast.makeText(context, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val aux: NavDirections = SelectAccountFragmentDirections.actionSelectAccountFragmentToHomeFragment(lista[position].id.toString(),
            lista[position].type, lista[position].titular1, lista[position].titular2, lista[position].titular3,
            lista[position].iban, lista[position].nib, lista[position].swift, lista[position].active, lista[position].approved,
            lista[position].createdOn, lista[position].saldo.toString(), args)
        findNavController().navigate(aux)

    }



}
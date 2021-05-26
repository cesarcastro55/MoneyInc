package com.example.moneyinc

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.moneyinc.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Response
import kotlin.math.log


class HomeFragment : Fragment() {

    companion object{
        fun newInstance() = HomeFragment()
    }

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


        getInfo(token)


        return binding.root
    }

    private fun getInfo(token: String){
        var user: UserInfo ?= null

        ServiceApi2.retrofitService.getInformation(token).enqueue(
            object : retrofit2.Callback<UserInfo>{
                override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                    user = response.body()


                }

                override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                    Log.e("Erro!!", "Sem dados!!")
                }

            }
        )

    }


}
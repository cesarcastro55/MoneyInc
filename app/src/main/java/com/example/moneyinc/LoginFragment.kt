package com.example.moneyinc

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.moneyinc.databinding.FragmentLoginBinding
import retrofit2.Call
import retrofit2.Response
import kotlin.math.round


class LoginFragment : Fragment() {

    var token: String? = null

    companion object{
        fun newInstance() = LoginFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        binding.button.setOnClickListener {
            var username: String = binding.editTextTextPassword.text.toString()
            var password: String = binding.editTextTextPassword.text.toString()

            getToken(username, password)

        }

        return binding.root
    }

    private fun getToken(username: String, password: String){
        var post: TokenPost = TokenPost(username, password)

        ServiceApi.retrofitService.createToken(post).enqueue(
            object : retrofit2.Callback<Token>{
                override fun onFailure(call: Call<Token>, t: Throwable) {
                    Log.e("Error!!", "Sem dados!!")
                }

                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    var PostResponse: Token? = response.body()
                    if(PostResponse != null){
                        token = response.body()?.token
                        val aux: NavDirections = LoginFragmentDirections.actionLoginFragmentToHomeFragment(token)findNavController().navigate(aux)
                    }else{
                        Log.e("Erro!!", "Sem dados!!")
                    }
                }

            }
        )
    }


}